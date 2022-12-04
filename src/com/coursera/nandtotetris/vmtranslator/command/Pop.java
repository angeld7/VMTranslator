package com.coursera.nandtotetris.vmtranslator.command;

public class Pop extends MemoryAccess {
  private final String fileName;

  protected Pop(String segment, int value, String fileName) {
    super(segment, value);
    this.fileName = fileName;
  }

  @Override
  public String toHackCode() {
    return
        getSegmentAccessCommands(fileName, false) +
        lines("D=A",
            "@R13",
            "M=D",
            "@SP",
            "AM=M-1",
            "D=M",
            "@R13",
            "A=M",
            "M=D"
        );
  }
}
