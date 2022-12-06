package com.coursera.nandtotetris.vmtranslator.command;

public class Goto extends Command {

  private final String label;

  public Goto(String label) {
    this.label = label;
  }

  @Override
  public String toHackCode() {
    return lines("@" + Command.getCurrentFunctionPrefix() + label,
        "0;JMP");
  }
}
