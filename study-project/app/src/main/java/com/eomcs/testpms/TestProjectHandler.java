package com.eomcs.testpms;

public class TestProjectHandler {

  static final int LENGTH = 1000;
  static int size = 0;
  static TestProject[] projects = new TestProject[LENGTH];


  static void add() {
    System.out.println("[프로젝트 등록]");

    TestProject project = new TestProject();

    project.no = TestPrompt.inputInt("번호? ");
    project.title = TestPrompt.inputString("프로젝트명? ");
    project.content = TestPrompt.inputString("내용? ");
    project.startDate = TestPrompt.inputDate("시작일? ");
    project.endDate = TestPrompt.inputDate("종료일? ");
    project.owner = TestPrompt.inputString("만든이? ");
    project.member = TestPrompt.inputString("팀원? ");

    projects[size++] = project;

  }

  static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < size; i++) {
      // 번호, 프로젝트명, 시작일, 종료일, 만든이
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          projects[i].no, 
          projects[i].title, 
          projects[i].startDate, 
          projects[i].endDate, 
          projects[i].owner);
    }
  }

}
