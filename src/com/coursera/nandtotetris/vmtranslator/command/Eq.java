package com.coursera.nandtotetris.vmtranslator.command;

public class Eq extends Arithmetic {
  @Override
  protected String writeOperation() {
    return lines("D=D-M") +
        booleanExpression("D;JEQ");
  }

  @Override
  public boolean twoOperands() {
    return true;
  }
}
