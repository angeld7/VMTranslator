package com.coursera.nandtotetris.vmtranslator.command;

public class Sub extends Arithmetic {
  @Override
  protected String writeOperation() {
    return lines("M=M-D");
  }

  @Override
  public boolean twoOperands() {
    return true;
  }


}
