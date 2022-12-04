package com.coursera.nandtotetris.vmtranslator.command;

public class And extends Arithmetic {
  @Override
  protected String writeOperation() {
    return lines("M=D&M");
  }

  @Override
  public boolean twoOperands() {
    return true;
  }


}
