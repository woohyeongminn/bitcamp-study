// Data Persistence Framework 도입 - 코드 정리!
package com.eomcs.mybatis.ex01.a;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0130 {

  public static void main(String[] args) throws Exception {

    //    InputStream mybatisConfigInputStream = Resources.getResourceAsStream(
    //        "com/eomcs/mybatis/ex01/a/mybatis-config.xml");
    //
    //    SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
    //
    //    SqlSessionFactory factory = factoryBuilder.build(mybatisConfigInputStream);
    //
    //    SqlSession sqlSession = factory.openSession();



    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex01/a/mybatis-config.xml")).openSession();

    System.out.println("mybatis 사용 준비 완료3!");

    sqlSession.close();
  }

}


