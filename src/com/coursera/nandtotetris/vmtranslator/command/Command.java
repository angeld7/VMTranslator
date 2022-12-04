package com.coursera.nandtotetris.vmtranslator.command;

public interface Command {
  String toHackCode();
  default String lines(String ...lines) {
    StringBuilder output = new StringBuilder();
    for (String line : lines) {
      output.append(line).append("\n");
    }
    return output.toString();
  }
}
