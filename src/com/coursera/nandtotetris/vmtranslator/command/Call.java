package com.coursera.nandtotetris.vmtranslator.command;

public class Call extends Command {

  private static String lastFunction = "";
  private static int labelCounter = 0;

  private final String functionName;
  private final String numArgs;

  public Call(String functionName, String numArgs) {
    this.functionName = functionName;
    this.numArgs = numArgs;
  }

  @Override
  public String toHackCode() {
    String returnLabel = getNextLabel();
    return lines("@" + returnLabel,
        "D=A",
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
        "MD=M+1",
        "@LCL",
        "M=D",
        "@" + (5 + Integer.parseInt(numArgs)),
        "D=D-A",
        "@ARG",
        "M=D",
        "@" + functionName,
        "0;JMP",
        "(" + returnLabel + ")");
  }

  public String getNextLabel() {
    String function = Command.getCurrentFunctionPrefix();
    if (!lastFunction.equals(function)) {
      labelCounter = 0;
      lastFunction = function;
    }
    return function + "ret." + labelCounter++;
  }
}
