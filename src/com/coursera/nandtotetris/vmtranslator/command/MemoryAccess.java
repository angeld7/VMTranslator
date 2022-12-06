package com.coursera.nandtotetris.vmtranslator.command;

public abstract class MemoryAccess extends Command {
  protected final String segment;
  protected final int value;

  protected MemoryAccess(String segment, int value) {
    this.segment = segment;
    this.value = value;
  }

  protected String getSegmentAccessCommands(boolean moveToD) {
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
        code = lines("@" + Command.getCurrentFile() + "." + value);
        break;
      case "temp":
        code = lines("@" + (5 + value));
        break;
      case "pointer":
        if (value == 0) {
          code = lines("@THIS");
        } else if (value == 1) {
          code = lines("@THAT");
        } else {
          throw new IllegalArgumentException("pointer value can only be 0 or 1");
        }
        break;
      case "constant":
        if (!moveToD) {
          throw new IllegalArgumentException("A constant cannot be written to.");
        }
        code = lines("@" + value, "D=A");
        moveToD = false;
    }
    if (moveToD) {
      code += lines("D=M");
    }
    return code;
  }

  private String getBasicAccessCommand(String segment) {
    return lines("@" + value,
        "D=A",
        "@" + segment,
        "A=D+M");
  }

}
