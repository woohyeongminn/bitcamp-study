package com.eomcs.lang;



class Hello3 {
  public static void main(String[] args) {
    System.out.println("Hello, World!");
    System.out.println("hello");
    System.out.println("okok");
  }
}

//## 실습
//1) 소스 디렉토리 생성
//- /src/main/java/com/eomcs/lang 폴더를 생성한다.
//
//2) 소스 파일 생성
//- Hello3.java 파일을 작성한다.
//
//3) 컴파일하기
//- 프로젝트 폴더에서 실행 할 때:
//  예) $ javac -d bin/main src/main/java/com/eomcs/lang/Hello3.java
//- 클래스 파일은 패키지 폴더에 생성된다.
//  예) /bin/main/com/eomcs/lang/Hello3.class
//
//4) 실행하기
//- 프로젝트 폴더에서 실행 할 때:
//  java [-classpath | -cp] [루트 패키지가 있는 디렉토리 경로] [패키지 이름을 포함한 클래스 이름]
//  예) $ java -cp bin/main com.eomcs.lang.Hello3
//- 다음과 같이 . 대신에 / 를 사용해도 된다.
//  예) $ java -cp bin/main com/eomcs/lang/Hello3
//
//* 주의!
//- 패키지에 소속된 클래스를 실행할 때는 반드시 패키지명과 클래스명을 함께 지정해야 한다.
//- 다음과 같이 -cp에 패키지 경로를 지정한 후 클래스 이름으로 실행할 수 없다.
//  예) $ java -cp bin/main/com/eomcs/lang Hello3  <== 실행 오류!
//


