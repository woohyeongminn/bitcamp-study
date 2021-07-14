package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Exam0110 {

  static void printSpace(int len) {

    for (int spaceCnt = 1; spaceCnt <= len; spaceCnt++) {
      System.out.print(" ");
    }
  }
  static void printStar(int len) {

    for (int starCnt = 1; starCnt <= len; starCnt++) {
      System.out.print("*");
    }
  }

  static int getSpaceLength(int ts, int ds) {
    return  (ts - ds) / 2;
  }




  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpace((len - starLen) / 2);
      printStar(starLen);
      System.out.println();

    }
  }
}