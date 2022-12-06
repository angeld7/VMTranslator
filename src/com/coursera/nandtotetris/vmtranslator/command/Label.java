package com.coursera.nandtotetris.vmtranslator.command;

public class Label extends Command{

  private final String label;

  public Label(String label) {
    this.label = label;
  }

  @Override
  public String toHackCode() {
    return lines("(" + Command.getCurrentFunctionPrefix() + label + ")");
  }
}
