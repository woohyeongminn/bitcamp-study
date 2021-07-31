// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0111 {

  public static void main(String[] args) {

    Bike bike = new Bike();

    Vehicle vehicle = bike; // OK

    // 이렇게 상위 클래스의 레퍼런스로 하위 클래스의 인스턴스를 가리킬 수 있는 이유?
    // => 하위 클래스의 인스턴스는 상위 클래스의 인스턴스 멤버를 갖고 있기 때문이다.
    // => 그래서 상위 클래스의 레퍼런스로
    //    상위 클래스의 인스턴스 멤버 사용을 보장한다.
    //

    // vehicle을 통해 Vehicle의 인스턴스 변수에 접근할 수 있다.
    vehicle.model = "티코";
    vehicle.capacity = 5;

    // vehicle.engine = false;
    // 컴파일 오류!  -> 레퍼런스 타입이 Vehicle이면 Vehicle이 가지고 있는 인스턴스만 
    //                  사용할 수 있다. 따라서 Bike에 있는 engine변수는 사용 할 수 없다.

    // ((Bike)vehicle).engine = false;  // 따라서 Bike에 있는 engine 변수를 사용하고 하면
    //                                     Bike로 형변환해야 한다.

    // 형 변환시 new를 통해 생성하는 타입으로만 가능하다. 다른 레퍼런스로 형변환을 하게 되면
    // 문법적으로는 오류가 없으나(컴파일은 진행된다.)  
    // 실행시 오류가 발생한다.



    // 왜?
    // => Bike 인스턴스에는 수퍼 클래스인 Vehicle의 인스턴스 변수가 있기 때문.
  }

}









