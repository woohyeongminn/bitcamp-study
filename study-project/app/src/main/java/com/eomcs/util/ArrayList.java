package com.eomcs.util;

import java.util.Arrays;

// 일반 클래스에 제네릭을 적용하면,
// 최종적인 타입 이름은        
// 해당 클래스의 인스턴스를 생성할 때 전달한다.
public class ArrayList<E> extends AbstractList<E> {

  static final int MAX_LENGTH = 5;

  Object[] list = new Object[MAX_LENGTH];

  @Override
  public void add(E obj) {
    if (size == list.length) {
      Object[] arr = new Object[list.length + (list.length >> 1)];
      for (int i = 0; i < size; i++) {
        arr[i] = list[i];
      }
      list = arr;
    }
    this.list[this.size++] = obj;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    for (int i = 0; i < this.size; i++) { // 배열에 저장된 값을 새 배열에 복사한다.
      arr[i] = list[i];
    }
    return arr; // 새 배열을 리턴한다.
  }

  public boolean remove(E obj) {
    int index = indexOf(obj);
    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.list[--this.size] = null;

    return true;
  }

  private int indexOf(E obj) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i] == obj) {
        return i;
      }
    }
    return -1;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E get(int index) {
    if (index < 0 || index >= this.size) {  // 유효하지 않은 인덱스인 경우
      return null;
    }
    return (E)this.list[index];
  }

  @SuppressWarnings("unchecked")   // 배열에 들어간게 E 타입 맞으니깐 경고하지 마!
  @Override
  public E remove(int index) {

    if (index < 0 || index >= this.size) {  // 인덱스가 무효하다면
      return null;
    }

    E deleted = (E)this.list[index]; // 삭제할 항목 저장

    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.list[--this.size] = null;

    return deleted;  // 삭제한 항목 리턴
  }

  @SuppressWarnings("unchecked")
  @Override 
  // T가 무엇인지는 메서드가 호출되는 시점에서 결정된다.
  public  E[] toArray(E[] arr) {

    if (arr.length >= this.size) {
      // 1) 파라미터로 받은 배열이 현재 목록에 있는 값을 담을 만큼 충분히 크다면
      //    -현재 목록에 있는 값을 파라미터로 받은 배열에 복사한다.
      //
      //     배열을 복사할 때 자바에서 제공하는 클래스를 사용하면
      //     반복문을 작성할 필요 없이 보다 쉽게 배열을 복사할 수 있다.
      //        => System.arraycopy(
      //            원래배열, 복사시작인덱스, 값을받을배열, 복사시작인덱스, 복사할개수)
      System.arraycopy(this.list, 0, arr, 0, this.size);
      return arr;  // 파라미터로 받은 배열을 그대로 리턴한다.

    } else {
      // 2) 파라미터로 받은 배열이 현재 목록에 들어 있는 값을 담을 만큼 크지 않다면
      //     - 새 배열을 만들어 복사한다. 
      // 다음과 같이 제네릭을 적용한 배열 인스턴스는 생성할 수 없다.
      // E[] temp = new E[this.size];  // 컴파일 오류

      // 해결책?
      // => 배열을 만들어 주는 클래스의 도움을 받아야 한다.
      //        => Arrays.copyOf(
      //            원래배열, 복사할개수, 새로만들배열의타입)
      return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass() );
    }
  }


}






















