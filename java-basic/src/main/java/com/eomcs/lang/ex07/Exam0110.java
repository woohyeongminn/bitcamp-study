package com.eomcs.lang.ex07;

import java.util.Scanner;

public class Exam0110 {


  static void printSpace(int a) {
    for (int spaceCnt = 1; spaceCnt <= a; spaceCnt++) {
      System.out.print(" ");
    }
  }

  static void printStar(int b) {
    for (int starCnt = 1; starCnt <= b; starCnt++) {
      System.out.print("*");
    }
  }

  static int plusValue(int c, int d) {
    return (c-d)/2 ;
  }

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpace(plusValue(len,starLen));
      printStar(starLen);
      System.out.println();
    }
  }
}