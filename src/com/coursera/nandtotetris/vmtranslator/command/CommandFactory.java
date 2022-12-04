package com.coursera.nandtotetris.vmtranslator.command;

public class CommandFactory {


  public static Command buildCommand(String[] line, String fileName) {
    Command command;
    switch (line[0]) {
      case "push":
        command = new Push(line[1], Integer.parseInt(line[2]), fileName);
        break;
      case "pop":
        command = new Pop(line[1], Integer.parseInt(line[2]), fileName);
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
      case "goto":
        command = new Goto(line[1]);
        break;
      case "if-goto":
        command = new IfGoto(line[1]);
        break;
      case "label":
        command = new Label(line[1]);
        break;
      case "call":
        command = new Call(line[1], line[2]);
        break;
      default:
        throw new IllegalArgumentException("Command not recognized: " + line[0]);
    }
    return command;
  }
}
