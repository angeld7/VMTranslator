package com.coursera.nandtotetris.vmtranslator.command;

public class Push extends MemoryAccess {

  protected Push(String segment, int value) {
    super(segment, value);
  }

  @Override
  public String toHackCode() {
    return getSegmentAccessCommands(true) +
        lines("@SP",
            "A=M",
            "M=D",
            "@SP",
            "M=M+1"
        );
  }
}
