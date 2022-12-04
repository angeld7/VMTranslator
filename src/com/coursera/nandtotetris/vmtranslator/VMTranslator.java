package com.coursera.nandtotetris.vmtranslator;

import com.coursera.nandtotetris.vmtranslator.parser.Parser;
import com.coursera.nandtotetris.vmtranslator.writer.CodeWriter;

public class VMTranslator {

  public static void main(String[] args) {
    if (args == null || args.length == 0) {
      throw new IllegalArgumentException("No filename specified");
    }
    VMTranslator vmTranslator = new VMTranslator();
    vmTranslator.translate(args[0]);
  }

  public void translate(String inputFileName) {
    try (
        Parser parser = new Parser(inputFileName);
        CodeWriter codeWriter = new CodeWriter(inputFileName, parser.isMultiFile())
    ) {
      while (parser.hasMoreCommand()) {
        codeWriter.writeCommand(parser.parseNext());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
