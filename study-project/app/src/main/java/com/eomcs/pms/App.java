package com.eomcs.pms;

import java.util.Date;
import java.util.Scanner;

//1) 배열 사용전
//2) 배열 사용후
//3) 반복문 적용 : while 문  
//4) 반복문 적용 : for 문

//5) 여러 문장에서 반복해서 사용하는 값은 변수에 담아서 사용한다.
//6) 조회용으로만 사용할 변수라면 상수로 선언한다. 변수 앞에 final 입력
//          변수명은 대문자로 하는 것이 좋다.
//7) 특정 조건에 따라 반복을 멈춘다.
//8) 날짜의 출력형식을 "yyyy-MM-dd"로 변경한다.


public class App {

  public static void main(String[] args) {
    System.out.println("[회원]");

    final int MAX = 100;
    int secnum =0;
    int size = 0;
    int i = 0;

    int[] no = new int[MAX];
    String[] name = new String[MAX];
    String[] email = new String[MAX];
    String[] password = new String[MAX];
    String[] photo = new String[MAX];
    String[] tel = new String[MAX];
    Date[] now = new Date[MAX];

    Scanner keyboardScan = new Scanner(System.in);



    for (i = 0; i < MAX; i = i + 1) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());
      System.out.print("이름? ");
      name[i] = keyboardScan.nextLine();
      System.out.print("이메일? ");
      email[i] = keyboardScan.nextLine();
      System.out.print("암호? ");
      password[i] = keyboardScan.nextLine();
      System.out.print("사진? ");
      photo[i] = keyboardScan.nextLine();
      System.out.print("전화? ");
      tel[i] = keyboardScan.nextLine();
      now[i] = new Date();
      System.out.println();
      size = size + 1;

      System.out.println("계속 입력하시겠습니까? (y/N)");





      while(true) {
        String input = keyboardScan.nextLine();
        if (!input.equalsIgnoreCase("n") && !input.equalsIgnoreCase("y")) {
          System.out.println("제대로 입력하세요");
          // String input1 = keyboardScan.nextLine();
        } else if (input.equalsIgnoreCase("n")) {
          secnum = secnum +1;
          break;
        } else if (input.equalsIgnoreCase("y")) {
          break;
        }
      } // while문 끝
      if(secnum ==1)
        break;

    }  








    keyboardScan.close(); 

    System.out.println("--------------------------------");
    for (i = 0; i < size; i = i + 1) {
      System.out.printf("%d %s %s %s %tY-%5$tm-%5$td\n",
          no[i],
          name[i],
          email[i],
          tel[i],
          now[i]);

    }
  }
}
