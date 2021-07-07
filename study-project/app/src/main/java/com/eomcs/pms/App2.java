package com.eomcs.pms;

import java.util.Date;

public class App2 {

  public static void main(String[] args) {

    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    Date dateNow = new Date(System.currentTimeMillis());

    System.out.println("[프로젝트]");
    System.out.print("번호 :");
    int no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("프로젝트명 :");
    String projectName = keyboard.nextLine();

    System.out.print("내용 :");
    String contents = keyboard.nextLine();

    //    System.out.print("시작일 :");
    //
    //    System.out.print("종료일 :");
    //    keyboard.nextLine();

    System.out.print("만든이 :");
    String creator = keyboard.nextLine();

    System.out.print("팀원 :");
    String member = keyboard.nextLine();


    System.out.println("------------------------------------------");
    System.out.println("[프로젝트]");
    System.out.printf("번호: %d\n", no);
    System.out.printf("프로젝트명: %s\n", projectName);
    System.out.printf("내용: %s\n", contents);
    System.out.printf("시작일 :");
    System.out.println(dateNow);
    System.out.printf("종료일: 2022-01-31\n");
    System.out.printf("만든이: %s\n", creator);
    System.out.printf("팀원: %s\n", member);


  }

}
