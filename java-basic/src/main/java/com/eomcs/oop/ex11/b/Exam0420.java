//static nested class : import static 사용 후
package com.eomcs.oop.ex11.b;

import static com.eomcs.oop.ex11.b.E.m1;
import static com.eomcs.oop.ex11.b.E.v1;
import static com.eomcs.oop.ex11.b.sub.M.m2;
import static com.eomcs.oop.ex11.b.sub.M.v2;
// 중첩 클래스를 import 할 때는 static을 적지 않는다.
import com.eomcs.oop.ex11.b.E.X;
import com.eomcs.oop.ex11.b.sub.M.Y;

///////////////////////////////////////
///////////////////////////////////////
class E {
  static int v1;
  static void m1() {}

  static class X {
    void test() {
      System.out.println("test()");
    }
  }



  int v3;
  int m3(int i) {
    this.v3 = i;
    return this.v3;
  }
  static class X3 {
    void test3() {
      System.out.println("test3()");
    }
  }

}
///////////////////////////////////////
///////////////////////////////////////

public class Exam0420 {

  public  void main(String[] args) {
    // 같은 패키지 클래스의 스태틱 멤버
    //  -클래스명 생략가능!
    v1 = 100;
    m1();
    X obj = new X();

    // 다른 패키지 클래스의 스태틱 멤버
    //  -클래스명 생략가능!
    v2 = 200;
    m2();
    Y obj2 = new Y();

    E woo  = new E();
    int min = woo.m3(100);
    System.out.println(min);

    System.out.println("hello");


  }

}
