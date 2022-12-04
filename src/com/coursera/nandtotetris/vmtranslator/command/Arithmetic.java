package com.coursera.nandtotetris.vmtranslator.command;

import com.coursera.nandtotetris.vmtranslator.util.VMUtils;

public abstract class Arithmetic implements Command {

  protected abstract String writeOperation();

  public abstract boolean twoOperands();

  public String toHackCode() {
    return lines("@SP",
        "AM=M-1") +
        (twoOperands() ?
            lines("D=M",
                "@SP",
                "AM=M-1")
            : "") +
        writeOperation() +
        lines("@SP",
            "M=M+1");
  }

  protected String booleanExpression(String jumpCommand) {
    String isTrue = VMUtils.getNextLabel();
    String end = VMUtils.getNextLabel();
    return lines("@" + isTrue,
        jumpCommand,
        "@SP",
        "A=M",
        "M=0",
        "@" + end,
        "0;JMP",
        "(" + isTrue + ")",
        "@SP",
        "A=M",
        "M=-1",
        "(" + end + ")");
  }
}
