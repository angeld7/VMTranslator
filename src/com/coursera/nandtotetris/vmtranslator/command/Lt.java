package com.coursera.nandtotetris.vmtranslator.command;

public class Lt extends Arithmetic {
  @Override
  protected String writeOperation() {
    return line("D=D-M") +
        booleanExpression("D;JGT");
  }

  @Override
  public boolean twoOperands() {
    return true;
  }
}
