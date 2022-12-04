package com.coursera.nandtotetris.vmtranslator.command;

public class Function implements Command {
  public Function(String functionName, String localArgs) {
    this.functionName = functionName;
    this.localArgs = localArgs;
  }

  private final String functionName;
  private final String localArgs;

  @Override
  public String toHackCode() {
    return null;
  }
}
