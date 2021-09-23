package com.eomcs.basic.ex01;

import java.util.ArrayList;
import java.util.List;

public class test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    List list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);

    System.out.println(list);

    // 리스트 remove 를 사용할 때는 뒤에서 부터...

    for(int i = list.size()-1; i >= 0; i--) {
      list.remove(i);
      System.out.println("현재 list는 아래와 같음");
      System.out.println(list);
    }

    System.out.println(list);

  }

}
