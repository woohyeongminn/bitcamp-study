package com.eomcs.testpms;

import java.sql.Date;

public class TestMemberHandler {
  static final int MAX_LENGTH = 5;

  static TestMember[] members = new TestMember[MAX_LENGTH];
  static int size = 0;
  static void add() {
    System.out.println("[회원 등록]");

    TestMember member = new TestMember();

    member.no = TestPrompt.inputInt("번호? ");
    member.name = TestPrompt.inputString("이름? ");
    member.email = TestPrompt.inputString("이메일? ");
    member.password = TestPrompt.inputString("암호? ");
    member.photo = TestPrompt.inputString("사진? ");
    member.tel = TestPrompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());
    members[size++] = member;
  }

  static void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      // 번호, 이름, 이메일, 전화, 가입일
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          members[i].no,
          members[i].name,
          members[i].email,
          members[i].tel,
          members[i].registeredDate);
    }
  }

}
