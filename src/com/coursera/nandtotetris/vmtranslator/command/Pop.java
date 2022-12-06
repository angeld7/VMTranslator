package com.coursera.nandtotetris.vmtranslator.command;

public class Pop extends MemoryAccess {

  protected Pop(String segment, int value) {
    super(segment, value);
  }

  @Override
  public String toHackCode() {
    return
        getSegmentAccessCommands(false) +
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
