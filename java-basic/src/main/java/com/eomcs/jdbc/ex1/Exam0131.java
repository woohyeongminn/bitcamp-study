// JDBC 드라이버 준비 - 드라이버 클래스 로딩과 등록
package com.eomcs.jdbc.ex1;

import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;

public class Exam0131 {

  public static void main(String[] args) {
    try {
      Properties props = new Properties();
      props.load(new FileReader("./jdbc-driver.properties"));
      System.out.println(props.getProperty("jdbc.driverClassName"));
      System.out.println(props.getProperty("jdbc.url"));

      Class.forName(props.getProperty("jdbc.driverClassName"));
      java.sql.Driver driver = DriverManager.getDriver(props.getProperty("jdbc.url"));
      System.out.println(driver);
      // 프로그래밍이 나중에 쉬워지려면 지금 코딩이 복잡해진다.

      // 소스코드를 손대지 않고 property 만 수정할 수 있어 편리하다.
      // 단 코딩이 복잡해진다 => 유지보수가 나아진다.
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


