package com.coursera.nandtotetris.vmtranslator.command;

public interface Command {
  String toVMCode(String fileName);
  default String line(String text) {
    return text + "\n";
  }
}
