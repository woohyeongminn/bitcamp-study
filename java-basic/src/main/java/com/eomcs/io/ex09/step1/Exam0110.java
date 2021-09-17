// 데코레이터 패턴 적용 - 부품과 부품을 손쉽게 연결할 수 있다. 기능 확장 및 제거가 매우 쉽다.
package com.eomcs.io.ex09.step1;

import java.io.FileInputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {

    // FileInputStream
    // - 파일 저장소에서 데이터를 읽는 일을 한다.
    FileInputStream in0 = new FileInputStream("temp/test4.data");

    // FileInputStream + BufferedInputStream
    // - 버퍼를 이용하여 일정량의 데이터를 왕창 읽어온 다음에 바이트를 꺼낸다.
    // - 읽기 속도를 높이는 일을 한다.
    BufferedInputStream in1 = new BufferedInputStream(in0);

    // FileInputStream + BufferedInputStream + DataInputStream
    // - 문자열이나 자바 기본 타입의 데이터를 좀 더 쉽게 읽기
    // - 이제 BufferedInputStream과 DataInputStream도 
    //   InputStream의 자식이기 때문에 
    //   다른 객체에 연결할 수 있다.
    DataInputStream in2 = new DataInputStream(in1); // OK!

    Member member = new Member();
    member.name = in2.readUTF();
    member.age = in2.readInt();
    member.gender = in2.readBoolean();

    // 객체를 닫을 때는 마지막에 연결된 부품부터 닫는다.
    in2.close();
    in1.close();
    in0.close();

    System.out.println(member);
  }

}
