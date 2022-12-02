package com.coursera.nandtotetris.vmtranslator.command;

public class Gt extends Arithmetic {
  @Override
  protected String writeOperation() {
    return line("D=D-M") +
        booleanExpression("D;JLT");
  }

  @Override
  public boolean twoOperands() {
    return true;
  }
}
