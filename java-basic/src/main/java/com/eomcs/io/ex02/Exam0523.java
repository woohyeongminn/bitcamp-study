// Byte Stream - 텍스트 데이터 읽기 II
package com.eomcs.io.ex02;

import java.io.FileInputStream;

public class Exam0523 {

  public static void main(String[] args) throws Exception {
    // JVM 환경 변수 'file.encoding' 값
    System.out.printf("file.encoding=%s\n", System.getProperty("file.encoding"));

    FileInputStream in = new FileInputStream("sample/ms949.txt");

    // 파일의 데이터를 한 번에 읽어보자.
    byte[] buf = new byte[1000];
    int count = in.read(buf);

    in.close();

    // 인코딩이 무엇인지는 상관하지 않는다.
    // JVM 환경 변수 'file.encoding'에 설정된 문자표에 상관없이 
    // String 객체를 만들 때 바이트 배열의 인코딩 문자 집합을 정확하게 알려준다면,
    //  UCS2 코드 값으로 정확하게 변환해 줄 것이다.
    String str = new String(buf, 0, count, "ms949");
    System.out.println(str);
  }

}
