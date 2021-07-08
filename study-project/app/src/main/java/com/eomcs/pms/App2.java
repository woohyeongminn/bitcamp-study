package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    System.out.println("[프로젝트]");

    Scanner keyboardScan = new Scanner(System.in);

    final int MAX = 100;
    int size = 0;
    int i ;

    int[] no = new int[MAX];
    String[] title = new String[MAX];
    String[] content = new String[MAX];
    Date[] startDate = new Date[MAX];
    Date[] endDate = new Date[MAX];
    String[] owner = new String[MAX];
    String[] members = new String[MAX];



    for (i=0; i<MAX; i=i+1) {


      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());
      System.out.print("프로젝트명? ");
      title[i] = keyboardScan.nextLine();
      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();
      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboardScan.nextLine());
      keyboardScan.nextLine();
      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboardScan.nextLine());
      keyboardScan.nextLine();
      System.out.print("만든이? ");
      owner[i] = keyboardScan.nextLine();
      System.out.print("팀원? ");
      members[i] = keyboardScan.nextLine();

      size = size + 1;

      System.out.println("계속 입력하시겠습니까?(y/N)");
      String inp = keyboardScan.nextLine();

      if (inp.equalsIgnoreCase("N")||inp.equalsIgnoreCase("")) {
        break;
      }

    }

    keyboardScan.close();

    System.out.println("--------------------------------");

    for (i=0; i<size; i=i+1) {

      System.out.printf("번호: %d %s %s %s %s\n",
          no[i],
          title[i],
          startDate[i],
          endDate[i],
          owner[i]);

    }
  }
}
