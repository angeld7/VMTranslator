package com.coursera.nandtotetris.vmtranslator.command;

public class Goto implements Command {

  private final String label;

  public Goto(String label) {
    this.label = label;
  }

  @Override
  public String toHackCode() {
    return lines("@" + label,
        "0;JMP");
  }
}
