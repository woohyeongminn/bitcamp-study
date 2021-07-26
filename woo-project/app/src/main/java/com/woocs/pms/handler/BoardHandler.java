package com.woocs.pms.handler;

import java.sql.Date;
import com.woocs.pms.domain.Board;
import com.woocs.util.Prompt;

public class BoardHandler {

  // 모든 게시판의 최대 배열 개수가 같기 때문에 다음 변수는 
  // 그냥 static 필드로 남겨둔다.
  static final int MAX_LENGTH = 5;

  // 게시판 마다 따로 관리해야 하기 때문에 인스턴스 필드로 전환한다.
  // => static 옵션을 뺀다.
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    //    board.viewCount = 0; // 인스턴스 변수는 생성되는 순간 기본 값이 0으로 설정된다.

    this.boards[this.size++] = board;
  }

  public void list() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          this.boards[i].no, 
          this.boards[i].title, 
          this.boards[i].writer,
          this.boards[i].registeredDate,
          this.boards[i].viewCount, 
          this.boards[i].like);
    }
  }

  public void detail() {
    System.out.println("게시글 상세 보기");
    int no = Prompt.inputInt("번호?>");

    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당번호의 게시글이 없습니다.");
      return;
    }
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %s\n", ++board.viewCount);
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    //    System.out.printf("제목(%s)", board.title);           -> 입력값 출력
    //    String title = Prompt.inputString("?");               -> 입력값 출력, 다른 값을 받을 준비 
    //    board.title = title;

    //    String titleWoo = String.format("제목(%s)?", board.title); -> 입력값 리턴
    //    String title = Prompt.inputString(titleWoo);
    //    board.title = title;
    //    임시 변수에 담을 필요 없이 바로 입력값에 넣어준다.
    //    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    //    board.title = title;

    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }


    board.title = title;
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    // index 값에 -1을 주는 이유
    //  >> 인스턴스 변수에 인덱스번호는 0부터 시작하므로 
    //     만약 0으로 주게 되면 indexOf()메서드에서 for문이 실행되지 않고 리턴하게 되어도
    //     "해당 번호의 게시글이 없습니다." 라는 명령코드가 실행되지 않는다.


    int index = indexOf(no);
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    // 해당 인덱스에 주소값을 지우려면 그 다음번 인덱스에 값을 옮기면 된다.
    // 순차적으로 진행 후 가장 마지막 인덱스에는 'null'값을 주어 빈공간으로 만든다.

    for (int i = index + 1; i < this.size; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    this.boards[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }

  private Board findByNo(int no) {

    for (int i = 0; i < this.size; i++) {
      if (this.boards[i].no == no) {
        return this.boards[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    int boardIndex = -1;

    // Board 인스턴스가 들어 있는 배열을 뒤져서
    // 게시글 번호와 일치하는 Board 인스턴스를 찾는다. 
    for (int i = 0; i < this.size; i++) {
      if (this.boards[i].no == no) {
        return i;
      }
    }
    return -1;     // 0이 아닌 -1을 주는 이유는 위에 있음
  }

}







