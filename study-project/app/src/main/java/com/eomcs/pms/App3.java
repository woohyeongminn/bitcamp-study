package com.eomcs.pms;

public class App3 {


  public static void main(String[] args) {
    java.util.Scanner scan = new java.util.Scanner(System.in);

    System.out.println("[작업]");

    System.out.print("프로젝트:");
    String project = scan.nextLine();


    System.out.print("번호:");
    int no = scan.nextInt();
    scan.nextLine();
    //    int no = Integer.parseInt(scan.nextLine());

    System.out.print("내용:");
    String contents = scan.nextLine();

    System.out.print("완료일:");
    String end = scan.nextLine();

    // Date deadline = Date.valueOf(scan.nextLine());

    System.out.print("상태:");
    int i = scan.nextInt();
    scan.nextLine();


    System.out.print("담당자:");
    String manager = scan.nextLine();
    scan.close();


    System.out.println("------------------------");

    System.out.println("[작업]");
    System.out.printf("프로젝트: %s\n", project);
    System.out.printf("번호: %d\n", no);
    System.out.printf("내용: %s\n", contents);
    System.out.printf("완료일: %s\n", end);

    if (i==-0) {
      System.out.println("신규");
    }
    if (i==1) {
      System.out.println("진행중");
    }
    if (i==2) {
      System.out.println("완료");
    }

    System.out.printf("담당자: %s", manager);
  }
}
