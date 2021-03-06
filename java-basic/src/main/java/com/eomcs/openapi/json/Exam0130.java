// JSON 문자열 --> 객체 : JSON 문자열을 해석하여 객체를 생성하기
package com.eomcs.openapi.json;

import com.google.gson.Gson;

public class Exam0130 {
  public static void main(String[] args) {

    // 1) JSON 문자열 준비
    String jsonStr = "{\"no\":100,\"name\":\"홍길동\",\"email\":\"hong@test.com\",\"password\":\"1111\",\"photo\":\"hong.gif\",\"tel\":\"010-2222-1111\",\"registeredDate\":\"9월 16, 2021\"}\r\n"
        ;

    // 2) JSON 처리 

    Gson gson = new Gson();

    // 3) JSON 문자열을 가지고 객체 만들기
    //  - JSON 문자열에서 해당 프로퍼티 이름과 일치하는 필드가 객체에 있다면 값을 설정해준다.
    //  - 예)
    //     JSON 문자열   ----------->  Board 객체
    //          no                          no
    //          name                        x
    //          email                       x
    //          password                    x
    //          photo                       x
    //          tel                         x
    //          registeredDate              registeredDate
    //
    Board b = gson.fromJson(jsonStr, Board.class);

    System.out.println(b);
  }
}
