package com.coursera.nandtotetris.vmtranslator.command;

public class Return extends Command{
  @Override
  public String toHackCode() {
    return lines(
        "@5",
        "D=A",
        "@ARG",
        "D=A-D",
        "@R13",
        "M=D",
        "@SP",
        "A=M-1",
        "D=M",
        "@ARG",
        "A=M",
        "M=D",
        "D=A+1",
        "@SP",
        "M=D",
        "@LCL",
        "D=M",
        "@THAT",
        "MD=D-1",
        "@THIS",
        "MD=D-1",
        "@ARG",
        "MD=D-1",
        "@LCL",
        "MD=D-1",
        "@R13",
        "0;JMP"
    );
  }
}
