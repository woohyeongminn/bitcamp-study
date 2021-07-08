package com.eomcs.basic.ex10;

public class Exam0110 {
  public static void main(String[] args) {
    long millis = System.currentTimeMillis();     //1970-01-01 0부터 현재까지의 ms
    System.out.println(millis);

    java.sql.Date d = new java.sql.Date(millis);   // ms 를 0000-00-00 형식으로 
    System.out.println(d.toString());              // 계산해서 출력한다.


  }
}
