package com.coursera.nandtotetris.vmtranslator.command;

public class IfGoto extends Command {

  private final String label;

  public IfGoto(String label) {

    this.label = label;
  }

  @Override
  public String toHackCode() {
    return lines("@SP",
        "AM=M-1",
        "D=M",
        "@" + Command.getCurrentFunctionPrefix() + label,
        "D;JNE");
  }
}
