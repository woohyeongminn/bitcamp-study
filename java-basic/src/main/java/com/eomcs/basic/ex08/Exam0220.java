// java.util.HashMap - value 목록만 꺼내기
package com.eomcs.basic.ex08;

import java.util.HashMap;

public class Exam0220 {
  public static void main(String[] args) {

    HashMap<String,Member> map = new HashMap<>();
    map.put("s01", new Member("홍길동", 20));
    map.put("s02", new Member("임꺽정", 30));
    map.put("s03", new Member("유관순", 16));
    map.put("s04", new Member("안중근", 20));
    map.put("s05", new Member("윤봉길", 30));

    // key 객체는 중복되어서는 안되기 때문에
    // key 객체 목록은 Set 에 담아서 리턴한다.
    // value 객체는 중복 저장될 수 있기 때문에
    // value 객체 목록은 Collection 에 담아서 리턴한다.
    //
    java.util.Collection<Member> values = map.values();
    // values()의 리턴 타입이 Collection 이다.
    // Collection 인터페이스는 Iterable 인터페이스를 상속받았다.
    for (Member value : values) {
      System.out.println(value);
    }

  }

}


