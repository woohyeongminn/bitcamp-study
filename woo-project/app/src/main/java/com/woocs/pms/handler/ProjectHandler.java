package com.woocs.pms.handler;

import java.sql.Date;
import com.woocs.pms.domain.Project;
import com.woocs.util.Prompt;

public class ProjectHandler {

  static final int MAX_LENGTH = 5;

  Project[] projects = new Project[MAX_LENGTH];
  int size = 0;

  //ProjectHandler가 지속적으로 사용할 의존 객체는 다음과 같이 인스턴스 필드로 받는다.
  // 이 인스턴스 변수에 의존 객체의 주소를 넣을 수 있도록 접근모드를 공개로 설정한다.
  public MemberHandler memberHandler;

  // 생성자 선언
  //  - 인스턴스를 생성할 때 반드시 호출되는 메서드이다..
  //  - 생성자는 리턴 타입이 없다.
  //  - 메서드 이름이 클래스 이름과 같아야 한다.
  //  - 인스턴스 변수를 유효환 값으로 초기화시킨다.
  //  - 필요하다면 인스턴스 변수를 초기화시킬 때 사용할 값을 파라미터로 받을 수 있다.

  public void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");
    project.owner = promptOwner();
    if (project.owner == null) {
      System.out.println("프로젝트 등록을 취소합니다.");
      return; // 메서드 실행을 즉시 종료!
    }

    project.members = promptMembers();

    this.projects[this.size++] = project;
  }

  public void list() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          this.projects[i].no, 
          this.projects[i].title, 
          this.projects[i].startDate, 
          this.projects[i].endDate, 
          this.projects[i].owner,
          this.projects[i].members);
    }
  }

  public void detail() {
    System.out.println("[프로젝트 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Project project = null;

    for (int i = 0; i < this.size; i++) {
      if (this.projects[i].no == no) {
        project = this.projects[i];
        break;
      }
    }

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.title);
    System.out.printf("내용: %s\n", project.content);
    System.out.printf("시작일: %s\n", project.startDate);
    System.out.printf("종료일: %s\n", project.endDate);
    System.out.printf("만든이: %s\n", project.owner);
    System.out.printf("팀원: %s\n", project.members);
  }

  public void update() {
    System.out.println("[프로젝트 변경]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);
    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.content));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.startDate));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.endDate));

    String owner = promptOwner( project.owner);
    if (owner == null) {
      System.out.println("프로젝트 변경을 취소합니다.");
      return;
    }

    String members = promptMembers(project.members);

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    project.title = title;
    project.content = content;
    project.startDate = startDate;
    project.endDate = endDate;
    project.owner = owner;
    project.members = members;

    System.out.println("프로젝트를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);
    if (index == -1) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.projects[i - 1] = this.projects[i];
    }
    this.projects[--this.size] = null;

    System.out.println("프로젝트를 삭제하였습니다.");
  }

  private Project findByNo(int no) {

    for (int i = 0; i < this.size; i++) {
      if (this.projects[i].no == no) {
        return this.projects[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.projects[i].no == no) {
        return i;
      }
    }
    return -1;
  }

  private String promptOwner() {
    return promptOwner(null);
  }
  private String promptOwner(String ownerName) {

    while (true) {

      //      String owner;
      //      if (ownerName == null) {
      //        owner = Prompt.inputString("만든이?(취소 : 빈 문자열)");
      //      }
      //      else {
      //        owner = Prompt.inputString(String.format("만든이(%s)?(취소: 빈 문자열)", ownerName));
      //      }
      String owner = Prompt.inputString(String.format(
          "만든이%s?(취소: 빈 문자열) ", 
          ownerName != null ? "(" + ownerName + ")" : ""));

      if (this.memberHandler.exist(owner)) {
        return owner;
      } else if (owner.length() == 0) {
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  private String promptMembers() {
    return promptMembers(null);
  }
  private String promptMembers(String oldMembers) {
    String members = "";

    while (true) {
      String member;
      if (oldMembers == null) {
        member = Prompt.inputString("팀원?(완료 : 빈 문자열)");
      }
      else {
        member = Prompt.inputString(String.format("팀원(%s)?(완료: 빈 문자열)", oldMembers));
      }

      //      String easymember = Prompt.inputString(String.format(
      //          "팀원%s?(완료: 빈 문자열) ",
      //          oldMembers != null ? "(" + oldMembers + ")" : ""));

      if (this.memberHandler.exist(member)) {
        if (members.length() > 0) {
          members += ",";
        }
        members += member;
        continue;
      } else if (member.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    return members;
  }

}