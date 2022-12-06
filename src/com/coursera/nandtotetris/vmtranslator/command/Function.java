package com.coursera.nandtotetris.vmtranslator.command;

public class Function extends Command {
  public Function(String functionName, String localArgs) {
    this.functionName = functionName;
    this.localArgs = Integer.parseInt(localArgs);
  }

  private final String functionName;
  private final int localArgs;

  @Override
  public String toHackCode() {
    Command.setCurrentFunction(functionName);
    StringBuilder lines = new StringBuilder(lines("(" + Command.getCurrentFunction() + ")"));
    if (localArgs > 0) lines.append(lines("@0", "D=A"));
    for (int i = 0; i < localArgs; i++) {
      lines.append(lines("@SP", "M=M+1", "A=M-1", "M=D"));
    }
    return lines.toString();
  }
}
