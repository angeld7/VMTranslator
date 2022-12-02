package com.coursera.nandtotetris.vmtranslator.command;

import com.coursera.nandtotetris.vmtranslator.util.VMUtils;

public abstract class Arithmetic implements Command {

  protected abstract String writeOperation();

  public abstract boolean twoOperands();

  public String toHackCode(String fileName) {
    return line("@SP") +
        line("AM=M-1") +
        (twoOperands() ?
            line("D=M") +
                line("@SP") +
                line("AM=M-1")
            : "") +
        writeOperation() +
        line("@SP") +
        line("M=M+1");
  }

  protected String booleanExpression(String jumpCommand) {
    String isTrue = VMUtils.getNextLabel();
    String end = VMUtils.getNextLabel();
    return line("@" + isTrue) +
        line(jumpCommand) +
        line("@SP") +
        line("A=M") +
        line("M=0") +
        line("@" + end) +
        line("0;JMP") +
        line("(" + isTrue + ")") +
        line("@SP") +
        line("A=M") +
        line("M=-1") +
        line("(" + end + ")");
  }
}
