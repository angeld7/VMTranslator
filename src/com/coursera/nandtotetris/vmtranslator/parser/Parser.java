package com.coursera.nandtotetris.vmtranslator.parser;

import com.coursera.nandtotetris.vmtranslator.command.Command;
import com.coursera.nandtotetris.vmtranslator.command.CommandFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Parser implements AutoCloseable {

  public static final String VM_EXTENSION = ".vm";
  private final Stack<BufferedReader> readerStack;
  private final Stack<String> fileNames;
  private BufferedReader currentReader;
  private String currentFileName;
  private String line;
  private boolean isMultiFile = false;

  public Parser(String inputFileName) throws IOException {
    readerStack = new Stack<>();
    fileNames = new Stack<>();
    setupBufferedReaders(inputFileName);
  }

  private void setupBufferedReaders(String inputFileName) throws IOException {
    if (inputFileName.endsWith(VM_EXTENSION)) {
      readerStack.push(new BufferedReader(new FileReader(inputFileName)));
      String tempFileName = inputFileName;
      if (inputFileName.contains(File.separator)) {
        tempFileName = tempFileName.substring(tempFileName.lastIndexOf(File.separator) + 1);
      }
      fileNames.push(tempFileName.replaceAll(VM_EXTENSION, ""));
    } else {
      isMultiFile = true;
      File directory = new File(inputFileName);
      if (directory.isDirectory()) {
        directoryToBufferedReaders(directory);
      } else {
        throw new IllegalArgumentException(inputFileName + " is not a directory or a .vm file");
      }
    }
    if (readerStack.isEmpty()) {
      throw new IllegalArgumentException("No .vm files present in directory " + inputFileName);
    }
    pop();
    line = currentReader.readLine();
  }

  private void pop() {
    currentReader = readerStack.pop();
    currentFileName = fileNames.pop();
  }

  private void directoryToBufferedReaders(File directory) throws FileNotFoundException {
    File[] files = directory.listFiles();
    if (files == null) return;
    for (File file : files) {
      if (file.isDirectory()) {
        directoryToBufferedReaders(file);
      } else if (file.getName().endsWith(VM_EXTENSION)) {
        readerStack.push(new BufferedReader(new FileReader(file)));
        fileNames.push(file.getName().replaceAll(VM_EXTENSION, ""));
      }
    }
  }

  public boolean isMultiFile() {
    return isMultiFile;
  }

  public boolean hasMoreCommand() throws IOException {
    if (line == null) {
      if (readerStack.empty()) {
        return false;
      }
      currentReader.close();
      pop();
      line = currentReader.readLine();
      return hasMoreCommand();
    }
    String lineFormatted = line.trim();
    if (lineFormatted.startsWith("//")) {
      line = "";
    }
    if ("".equals(line)) {
      line = currentReader.readLine();
      return hasMoreCommand();
    }
    return true;
  }

  public Command parseNext() throws IOException {
    String commandString = line.split("//")[0];
    Command command = CommandFactory.buildCommand(commandString.split(" "), currentFileName);
    line = currentReader.readLine();
    return command;
  }

  @Override
  public void close() throws Exception {
    currentReader.close();
  }
}
