package com.coursera.nandtotetris.vmtranslator.command;

public class Label implements Command{

  private final String label;

  public Label(String label) {
    this.label = label;
  }

  @Override
  public String toHackCode() {
    return lines("(" + label + ")");
  }
}
