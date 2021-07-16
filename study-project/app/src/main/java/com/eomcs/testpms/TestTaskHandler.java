package com.eomcs.testpms;

import java.sql.Date;

public class TestTaskHandler {

  static final int LENGTH = 100;
  static int[] no = new int[LENGTH];
  static String[] content = new String[LENGTH];
  static Date[] deadLine = new Date[LENGTH];
  static String[] owner = new String[LENGTH];
  static int[] status = new int[LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[작업 등록]");

    no[size] = TestPrompt.inputInt("번호? ");
    content[size] = TestPrompt.inputString("내용? ");
    deadLine[size] = TestPrompt.inputDate("마감일? ");

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    status[size] = TestPrompt.inputInt("> ");
    owner[size] = TestPrompt.inputString("담당자? ");

    size++;
  }

  static void list() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < size; i++) {
      String stateLabel = null;
      switch (status[i]) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }
      // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          no[i], content[i], deadLine[i], stateLabel, owner[i]);
    }
  }

}
