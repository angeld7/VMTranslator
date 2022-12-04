package com.coursera.nandtotetris.vmtranslator.command;

public class Push extends MemoryAccess {

  private final String fileName;

  protected Push(String segment, int value, String fileName) {
    super(segment, value);
    this.fileName = fileName;
  }

  @Override
  public String toHackCode() {
    return getSegmentAccessCommands(fileName, true) +
        lines("@SP",
            "A=M",
            "M=D",
            "@SP",
            "M=M+1"
        );
  }
}
