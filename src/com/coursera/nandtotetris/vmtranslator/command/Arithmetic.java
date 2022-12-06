package com.coursera.nandtotetris.vmtranslator.command;

public abstract class Arithmetic extends Command {

  private static String lastFunction = "";
  private static int labelCounter = 0;

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
    String isTrue = getNextLabel("BooleanExpression#", false);
    String end = getNextLabel("BooleanExpression#End", true);
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

  private static String getNextLabel(String name, boolean increaseCounter) {
    String function = Command.getCurrentFunctionPrefix();
    if (!lastFunction.equals(function)) {
      labelCounter = 0;
      lastFunction = function;
    }
    String label = function + name.replaceAll("#", String.valueOf(labelCounter));
    if (increaseCounter) {
      labelCounter++;
    }
    return label;
  }
}
