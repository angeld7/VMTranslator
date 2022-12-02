package com.coursera.nandtotetris.vmtranslator.command;

public class CommandFactory {


  public static Command buildCommand(String[] line) {
    Command command;
    switch (line[0]) {
      case "push":
        command = new Push(line[1], Integer.parseInt(line[2]));
        break;
      case "pop":
        command = new Pop(line[1], Integer.parseInt(line[2]));
        break;
      case "add":
        command = new Add();
        break;
      case "sub":
        command = new Sub();
        break;
      case "neg":
        command = new Neg();
        break;
      case "eq":
        command = new Eq();
        break;
      case "gt":
        command = new Gt();
        break;
      case "lt":
        command = new Lt();
        break;
      case "and":
        command = new And();
        break;
      case "or":
        command = new Or();
        break;
      case "not":
        command = new Not();
        break;
      default:
        throw new IllegalArgumentException("Command not recognized: " + line[0]);
    }
    return command;
  }
}
