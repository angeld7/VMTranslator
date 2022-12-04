package com.coursera.nandtotetris.vmtranslator.writer;

import com.coursera.nandtotetris.vmtranslator.command.Call;
import com.coursera.nandtotetris.vmtranslator.command.Command;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeWriter implements AutoCloseable {
  private final BufferedWriter writer;
  private String fileName;

  public CodeWriter(String inputFileName, Boolean multiFile) throws IOException {
    fileName = inputFileName.replace(".vm", "");
    if (inputFileName.contains(File.separator)) {
      String beforeLastSeparator = inputFileName.substring(0, inputFileName.lastIndexOf(File.separator));
      if (inputFileName.endsWith(File.separator)) {
        fileName = inputFileName + beforeLastSeparator.substring(inputFileName.lastIndexOf(File.separator) + 1);
      } else if (multiFile) {
        fileName = inputFileName + File.separator + inputFileName.substring(beforeLastSeparator.length());
      }
    }
    fileName += ".asm";
    writer = new BufferedWriter((new FileWriter(fileName)));
    if (multiFile) {
      writeInit();
    }
  }

  private void writeInit() throws IOException {
    writer.write("@256\nD=A\n@SP\nM=D\n");
    Call call = new Call("Sys.init", "0");
    writer.write(call.toHackCode());
  }

  public void writeCommand(Command command) throws IOException {
    writer.write(command.toHackCode());
  }

  @Override
  public void close() throws Exception {
    writer.write("(END)\n@END\n0;JMP");
    writer.close();
    System.out.println("Created file: " + fileName);
  }
}
