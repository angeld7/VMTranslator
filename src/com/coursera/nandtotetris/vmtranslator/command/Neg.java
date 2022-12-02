package com.coursera.nandtotetris.vmtranslator.command;

public class Neg extends Arithmetic {
  @Override
  protected String writeOperation() {
    return line("M=-M");
  }

  @Override
  public boolean twoOperands() {
    return false;
  }


}
