// Statement 와 SQL 삽입 공격
// 원래 만들고자 하는 sql을 왜곡 시키는 것
package com.eomcs.jdbc.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    String no = null;
    String title = null;
    String contents = null;

    try (Scanner keyboard = new Scanner(System.in)) {

      System.out.print("제목? ");
      title = keyboard.nextLine();

      System.out.print("내용? ");
      contents = keyboard.nextLine();
    }

    try (Connection con = DriverManager.getConnection( 
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement
            ("insert into x_board(title, contents) values(?,?)")) {

      // 위에서 준비한 SQL 문에 값을 설정한다.
      // => ? : 값을 놓일 자리를 의미한다. 'in-parameter' 라 부른다.
      // => in-parameter에 들어갈 값을 타입에 따라 적절한 setXxx() 메서드를 호출한다.

      stmt.setString(1, title);
      stmt.setString(2, contents);

      // => 이미 SQL을 준비한 상태이기 때문에 실행할 때는 SQL를 줄 필요가 없다.
      // => 서버에 SQL을 전달할 때는 SQL과 값을 분리해서 보내고,
      //    서버에서 분리된 값을 따로 처리할 것이기 때문에
      //    SQL 삽입 공격이 불가능한다.
      int count = stmt.executeUpdate();

      System.out.println(count + " 개를 입력하였습니다.");
    }
  }
}
