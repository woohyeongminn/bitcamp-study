package com.eomcs.testpms;

import java.sql.Date;
import java.util.Scanner;

public class TestPrompt {
  static Scanner keyboardScan = new Scanner(System.in);

  static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  static void close() {
    keyboardScan.close();
  }

}
