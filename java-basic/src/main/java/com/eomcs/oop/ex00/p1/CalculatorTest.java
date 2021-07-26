package com.eomcs.oop.ex00.p1;

public class CalculatorTest {

  public static void main(String[] args) {
    // 2 + 3 + 4 - 7 * 3 = 6
    // 3 * 2 - 1 = 5

    Calculator woo1 = new Calculator();
    Calculator woo2 = new Calculator();

    woo1.plus(2);
    woo1.plus(3);
    woo1.plus(4);
    woo1.minus(7);
    woo1.multiple(3);

    woo2.plus(3);
    woo2.multiple(2);
    woo2.minus(1);

    System.out.println(woo1.result);
    System.out.println(woo2.result);
  }
}



