package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    System.out.println("[작업]");

    Scanner keyboardScan = new Scanner(System.in);

    System.out.print("프로젝트? ");
    String project = keyboardScan.nextLine();

    int max = 100;
    int[] no = new int[max];
    int[] status = new int[max];
    int size = 0;
    String[] content = new String[max];
    String[] owner = new String[max];
    Date[] deadLine = new Date[max];



    for (int i = 0; i < max; i = i + 1) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());
      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();
      System.out.print("마감일? ");
      deadLine[i] = Date.valueOf(keyboardScan.nextLine());
      System.out.printf("상태?\n" + "0: 신규\n"+"1: 진행중\n"+"2: 완료\n");
      System.out.print("> ");
      status[i] = Integer.valueOf(keyboardScan.nextLine());
      System.out.print("담당자? ");
      owner[i] = keyboardScan.nextLine();
      size = size + 1;

      System.out.println("계속 출력하시겠습니까?(y/N)");
      String input = keyboardScan.nextLine();

      if (input.equalsIgnoreCase("n") || input.contentEquals("")) {
        break;
      }
    }


    keyboardScan.close();

    System.out.println("--------------------------------");
    for (int i = 0; i < size; i = i + 1) {
      System.out.printf("%s, %s, %s,", 
          no[i],content[i],deadLine[i]);

      switch (status[i]) {
        case 1:
          System.out.print(" 진행중,");
          break;
        case 2:
          System.out.print(" 완료,");
          break;
        default:
          System.out.print(" 신규,");
      }

      System.out.printf(" %s\n", owner);
    }

  }
}
