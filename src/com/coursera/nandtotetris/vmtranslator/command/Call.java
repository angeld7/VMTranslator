package com.coursera.nandtotetris.vmtranslator.command;

import com.coursera.nandtotetris.vmtranslator.util.VMUtils;

public class Call implements Command {
  private final String functionName;
  private final String numArgs;

  public Call(String functionName, String numArgs) {
    this.functionName = functionName;
    this.numArgs = numArgs;
  }

  @Override
  public String toHackCode() {
    String returnLabel = "RETURN_" + VMUtils.getNextLabel();
    return lines("@" + returnLabel,
        "A=D",
        "@SP",
        "A=M",
        "M=D",
        "@LCL",
        "D=A",
        "@SP",
        "AM=M+1",
        "M=D",
        "@ARG",
        "D=A",
        "@SP",
        "AM=M+1",
        "M=D",
        "@THIS",
        "D=A",
        "@SP",
        "AM=M+1",
        "M=D",
        "@THAT",
        "D=A",
        "@SP",
        "AM=M+1",
        "M=D",
        "@SP",
        "DM=M+1",
        "@" + (5 + Integer.parseInt(numArgs)),
        "D=D-A",
        "@ARG",
        "M=D",
        "@SP",
        "M=A",
        "@LCL",
        "M=D",
        "@" + functionName,
        "0;JMP",
        "(" + returnLabel + ")");
  }
}
