package com.coursera.nandtotetris.vmtranslator.command;

public class Pop extends MemoryAccess {

  protected Pop(String segment, int value) {
    super(segment, value);
  }

  @Override
  public String toHackCode(String fileName) {
    return
        getSegmentAccessCommands(fileName, false) +
        line("D=A") +
        line("@R13") +
        line("M=D") +
        line("@SP") +
        line("AM=M-1") +
        line("D=M") +
        line("@R13") +
        line("A=M") +
        line("M=D");
  }
}
