package com.coursera.nandtotetris.vmtranslator.util;

public class VMUtils {
  private static int nextLabel = 0;

  public static String getNextLabel() {
    return "LABEL_" + nextLabel++;
  }

}
