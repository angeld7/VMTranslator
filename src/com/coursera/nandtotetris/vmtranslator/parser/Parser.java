package com.coursera.nandtotetris.vmtranslator.parser;

import com.coursera.nandtotetris.vmtranslator.command.Command;
import com.coursera.nandtotetris.vmtranslator.command.CommandFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser implements AutoCloseable {

  private final BufferedReader reader;
  private String line;

  public Parser(String inputFileName) throws IOException {
    reader = new BufferedReader(new FileReader(inputFileName));
    line = reader.readLine();
  }

  public boolean hasMoreCommand() throws IOException {
    if (line == null) {
      return false;
    }
    String lineFormatted = line.trim();
    if (lineFormatted.startsWith("//")) {
      line = "";
    }
    if ("".equals(line)) {
      line = reader.readLine();
      return hasMoreCommand();
    }
    return true;
  }

  public Command parseNext() throws IOException {
    String commandString = line.split("//")[0];
    Command command = CommandFactory.buildCommand(commandString.split(" "));
    line = reader.readLine();
    return command;
  }

  @Override
  public void close() throws Exception {
    reader.close();
  }
}
