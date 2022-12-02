package com.coursera.nandtotetris.vmtranslator.command;

public class Push extends MemoryAccess {

  protected Push(String segment, int value) {
    super(segment, value);
  }

  @Override
  public String toHackCode(String fileName) {
    return getSegmentAccessCommands(fileName, true) +
        line("@SP") +
        line("A=M") +
        line("M=D") +
        line("@SP") +
        line("M=M+1");
  }
}
