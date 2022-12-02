package com.coursera.nandtotetris.vmtranslator.command;

public interface Command {
  String toHackCode(String fileName);
  default String line(String text) {
    return text + "\n";
  }
}
