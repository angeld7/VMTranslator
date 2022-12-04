package com.coursera.nandtotetris.vmtranslator.command;

public class Add extends Arithmetic {
  @Override
  protected String writeOperation() {
    return lines("M=D+M");
  }

  @Override
  public boolean twoOperands() {
    return true;
  }


}
