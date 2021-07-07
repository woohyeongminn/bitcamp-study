package com.eomcs.pms;

//import java.util.Scanner;
import java.util.Date;
public class App {
  public static void main(String[] args) {
    //java.io.InputStream keyboard = System.in;
    java.util.Scanner keyScan = new java.util.Scanner(System.in);
    Date dateNow = new Date(System.currentTimeMillis());

    System.out.print("[회원]\n");
    //keyScan.nextLine();

    System.out.print("번호 : ");
    int no = keyScan.nextInt();
    keyScan.nextLine();         //키보드 메모리에 남아있는 찌꺼기 엔터 코드 제거

    System.out.print("이름 :");
    String name = keyScan.nextLine();

    System.out.print("이메일 : ");
    String email = keyScan.nextLine();

    System.out.print("암호 : ");
    String password = keyScan.nextLine();

    System.out.print("사진 : ");
    String photo = keyScan.nextLine();

    System.out.print("전화 : ");
    String tel = keyScan.nextLine();


    keyScan.close();



    System.out.println("-------------------------");

    System.out.printf("번호: %d\n",no);
    System.out.printf("이름: %s\n",name);
    System.out.printf("이메일: %s\n",email);
    System.out.printf("암호: %s\n",password);
    System.out.printf("사진: %s\n",photo);
    System.out.printf("전화: %s\n",tel);
    System.out.println(dateNow);




  }
}
