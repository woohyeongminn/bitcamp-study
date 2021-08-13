// 인터페이스와 추상 클래스를 함께 사용하는 예
package com.eomcs.oop.ex09.i;

public interface Pen {
  boolean use = false;
  void on();
  void off();
  void write(String text);
}
