package com.coursera.nandtotetris.vmtranslator.command;

public abstract class Command {
  private static String currentFunction = "";
  private static String currentFile = "";
  private String comment = "\n";

  public static String getCurrentFile() {
    return currentFile;
  }

  public static void setCurrentFile(String currentFile) {
    Command.currentFile = currentFile;
  }

  public static String getCurrentFunction() {
    return currentFunction;
  }

  public static String getCurrentFunctionPrefix() {
    return "".equals(currentFunction) ? "" : currentFunction + "$";
  }

  public static void setCurrentFunction(String currentFunction) {
    Command.currentFunction = currentFunction;
  }

  public void setComment(String comment) {
    if (comment != null && !comment.trim().equals("")) {
      this.comment = " // " + comment.trim() + "\n";
    }
  }

  protected abstract String toHackCode();

  public String getHackCode() {
    return toHackCode().replaceFirst("\n", comment);
  }

  String lines(String... lines) {
    StringBuilder output = new StringBuilder();
    for (String line : lines) {
      output.append(line).append("\n");
    }
    return output.toString();
  }
}
