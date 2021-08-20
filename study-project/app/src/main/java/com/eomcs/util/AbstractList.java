package com.eomcs.util;

// 추상 클래스에서 List에 적용할 타입 이름을 E 변수에 받는다.
// 그 변수에 값을 List 인터페이스에 적용한다.
// 이때 추상 클래스에 타입 이름을 전달하는 방법은 
// 서브 클래스를 정의할 때 넘겨준다.
// E 를 받아서 List<E> 에 넘겨 준다. 라는 의미
public abstract class AbstractList<E> implements List<E> {
  protected int size;

  public int size() {
    return this.size;
  }
}
