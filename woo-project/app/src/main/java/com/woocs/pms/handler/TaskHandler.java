package com.woocs.pms.handler;

import java.sql.Date;
import com.woocs.pms.domain.Task;
import com.woocs.util.Prompt;

public class TaskHandler {

  static final int MAX_LENGTH = 5;

  Task[] tasks = new Task[MAX_LENGTH];
  int size = 0;

  // TaskHandler의 여러 메서드에서 지속적으로 사용할 의존 객체를 인스턴스 필드로 받는다.
  // 다른 패키지의 클래스에서 이 변수를 사용할 수 있도록 접근 모드는 공개한다.
  public MemberHandler memberHandler;

  // add()에서 사용할 MemberHandler는 메서드를 호출하기 전에
  // 인스턴스 변수에 미리 주입되어 있어야 한다.
  public void add() {
    System.out.println("[작업 등록]");

    Task task = new Task();

    task.no = Prompt.inputInt("번호? ");
    task.content = Prompt.inputString("내용? ");
    task.deadline = Prompt.inputDate("마감일? ");
    task.status = promptStatus();

    task.owner = PromptOwner(null);
    if (task.owner == null) {
      System.out.println("작업 등록을 취소합니다.");
      return; 
    }

    this.tasks[this.size++] = task;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < this.size; i++) {

      System.out.printf("%d, %s, %s, %s, %s\n",
          this.tasks[i].no, 
          this.tasks[i].content, 
          this.tasks[i].deadline, 
          getStatusLabel(this.tasks[i].status), 
          this.tasks[i].owner);
    }
  }

  public void detail() {
    System.out.println("[작업 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }
    System.out.printf("내용: %s\n", task.content);
    System.out.printf("마감일: %s\n", task.deadline);
    System.out.printf("상태: %s\n", getStatusLabel(task.status));
    System.out.printf("담당자: %s\n", task.owner);
  }


  // update()가 사용할 MemberHandler 는
  // 인스턴스 변수에 미리 주입 받기 때문에 파라미터로 받을 필요가 없다.
  public void update() {
    System.out.println("[작업 변경]");
    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", task.content));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.deadline));
    int status = promptStatus();

    String owner = null;
    while (true) {
      owner = Prompt.inputString(String.format(
          "담당자(%s)?(취소: 빈 문자열) ", task.owner));
      if (memberHandler.exist(owner)) {
        break;
      } else if (owner.length() == 0) {
        System.out.println("작업 변경을 취소합니다.");
        return; // 메서드 실행을 즉시 종료!
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 변경을 취소하였습니다.");
      return;
    }

    task.content = content;
    task.deadline = deadline;
    task.status = status;
    task.owner = owner;

    System.out.println("작업를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[작업 삭제]");
    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);
    if (index == -1) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.tasks[i - 1] = this.tasks[i];
    }
    this.tasks[--this.size] = null;

    System.out.println("작업를 삭제하였습니다.");
  }

  private Task findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i].no == no) {
        return this.tasks[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i].no == no) {
        return i;
      }
    }
    return -1;
  }

  private String PromptOwner(String ownerName) {

    String owner;
    while (true) {
      //      if (ownerName == null) {
      //        owner = Prompt.inputString("담당자?(취소: 빈 문자열) ");
      //      } else {
      //        owner = Prompt.inputString(String.format(
      //            "담당자(%s)?(취소: 빈 문자열) ", ownerName));
      //      }

      owner = Prompt.inputString(String.format(
          "담당자%s(취소: 빈 문자열) ", 
          ownerName != null ? "(" + ownerName + ")" : ""));

      if (owner.length() == 0) {
        return null; 

        // MemberHandler의 인스턴스는 미리 주입받은 인스턴스를 사용한다.
      } else if (this.memberHandler.exist(owner)) {
        return  owner;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  private String getStatusLabel(int status) {
    switch (status) {
      case 1: return  "진행중";
      case 2: return  "완료";
      default: return  "신규";
    }
  }

  private int promptStatus() {
    System.out.printf("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    return Prompt.inputInt("> ");
  }
}