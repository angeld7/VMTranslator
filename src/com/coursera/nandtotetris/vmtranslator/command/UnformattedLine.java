package com.coursera.nandtotetris.vmtranslator.command;

public class UnformattedLine extends Command{
  private final String line;

  public UnformattedLine(String line) {
    this.line = line;
  }

  @Override
  protected String toHackCode() {
    return lines(line);
  }
}
