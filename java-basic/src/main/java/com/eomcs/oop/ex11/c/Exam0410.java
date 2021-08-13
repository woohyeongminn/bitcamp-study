// inner class : import 사용
package com.eomcs.oop.ex11.c;

import com.eomcs.oop.ex11.c.D.X;
import com.eomcs.oop.ex11.c.sub.M;
import com.eomcs.oop.ex11.c.sub.M.Y;

///////////////////////////////////
///////////////////////////////////

class D {

  ////////////////////////////////
  class X {
    void test() {
      System.out.println("test()");
    }
  }
  ////////////////////////////////
}

///////////////////////////////////
///////////////////////////////////

public class Exam0410 {

  public static void main(String[] args) {
    D outer = new D();      // 선언 및 호출 >> 내부에 있는 이너 클래스.....
    X obj = outer.new X();  // new X(outer);
    obj.test();

    M outer2 = new M();
    Y obj2 = outer2.new Y();
    obj2.test();
  }

}
