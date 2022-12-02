package com.coursera.nandtotetris.vmtranslator.writer;

import com.coursera.nandtotetris.vmtranslator.command.Command;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeWriter implements AutoCloseable {
  private final BufferedWriter writer;
  private final File file;

  public CodeWriter(String inputFileName) throws IOException {
    String fileName = inputFileName.substring(0, inputFileName.lastIndexOf('.'));
    file = new File(fileName + ".asm");
    writer = new BufferedWriter((new FileWriter(file)));
  }

  public void writeCommand(Command command) throws IOException {
    writer.write(command.toHackCode(file.getName().replace(".asm", "")));
  }

  @Override
  public void close() throws Exception {
    writer.write("(END)\n@END\n0;JMP");
    writer.close();
    System.out.println("Created file: " + file.getAbsolutePath());
  }
}
