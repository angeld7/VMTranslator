package com.coursera.nandtotetris.vmtranslator.command;

public class Push extends MemoryAccess {

  protected Push(String segment, int value) {
    super(segment, value);
  }

  @Override
  public String toHackCode() {
    return getSegmentAccessCommands(true) +
        lines("@SP",
            "M=M+1",
            "A=M-1",
            "M=D"
        );
  }
}
