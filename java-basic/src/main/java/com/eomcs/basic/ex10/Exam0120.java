package com.eomcs.basic.ex10;

public class Exam0120 {
  public static void main(String[] args) {
    java.util.Date d = new java.util.Date();   // D객체를 만드는 순간의 시각을 저장해 둔다.
    System.out.println(d.toString());
    System.out.printf("%tY-%tm-%td\n",d,d,d);
    System.out.printf("%tY-%1$tm-%1$td\n",d); 
    System.out.printf("%tY-%tm-%td-%1$th",d,d,d);
  }
}
