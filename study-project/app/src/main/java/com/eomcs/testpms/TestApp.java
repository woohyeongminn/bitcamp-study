package com.eomcs.testpms;

public class TestApp {

  public static void main(String[] args) {


    while (true) {
      String input = TestPrompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        TestMemberHandler.add();

      } else if (input.equals("/member/list")) {
        TestMemberHandler.list();

      }  else if (input.equals("/project/add")) {
        TestProjectHandler.add();

      }  else if (input.equals("/project/list")) {
        TestProjectHandler.list();

      }  else if (input.equals("/task/add")) {
        TestTaskHandler.add();

      }  else if (input.equals("/task/list")) {
        TestTaskHandler.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    TestPrompt.close();

  }
}
