package com.coursera.nandtotetris.vmtranslator.command;

public abstract class MemoryAccess implements Command {
  protected final String segment;
  protected final int value;

  protected MemoryAccess(String segment, int value) {
    this.segment = segment;
    this.value = value;
  }

  protected String getSegmentAccessCommands(String fileName, boolean moveToD) {
    String code = "";
    switch (segment) {
      case "local":
        code = getBasicAccessCommand("LCL");
        break;
      case "argument":
        code = getBasicAccessCommand("ARG");
        break;
      case "this":
        code = getBasicAccessCommand("THIS");
        break;
      case "that":
        code = getBasicAccessCommand("THAT");
        break;
      case "static":
        code = line("@" + fileName + "." + value);
        break;
      case "temp":
        code = line("@" + (5 + value));
        break;
      case "pointer":
        if (value == 0) {
          code = line("@THIS");
        } else if (value == 1) {
          code = line("@THAT");
        } else {
          throw new IllegalArgumentException("pointer value can only be 0 or 1");
        }
        break;
      case "constant":
        if (!moveToD) {
          throw new IllegalArgumentException("A constant cannot be written to.");
        }
        code = line("@" + value) +
            line("D=A");
        moveToD = false;
    }
    if (moveToD) {
      code += line("D=M");
    }
    return code;
  }

  private String getBasicAccessCommand(String segment) {
    return line("@" + value) +
        line("D=A") +
        line("@" + segment) +
        line("A=D+M");
  }

}
