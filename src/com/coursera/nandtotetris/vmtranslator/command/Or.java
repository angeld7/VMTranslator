package com.coursera.nandtotetris.vmtranslator.command;

public class Or extends Arithmetic {
  @Override
  protected String writeOperation() {
    return line("M=D|M");
  }

  @Override
  public boolean twoOperands() {
    return true;
  }


}
