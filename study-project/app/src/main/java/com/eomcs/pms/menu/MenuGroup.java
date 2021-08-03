package com.eomcs.pms.menu;

import com.eomcs.util.Prompt;

// 역할
//  - 다른 메뉴를 포함하는 컨테이너 역할을 수행한다.
//    
public class MenuGroup extends Menu {

  Menu[] childs = new Menu[100];
  int size;
  boolean disableProvMenu;

  // 생성자를 정의하지 않으면 컴파일러가 기본 생성자를 자동으로 추가해 준다.
  // 문제는 컴파일러가 추가한 기본 생성자는 수퍼 클래스의 기본 생성자를 호출하기 때문에
  // 컴파일 오류가 발생한다. 
  // Menu 클래스에는 기본 생성자가 없다.
  // 따라서 개발자가 직접 생성자를 정의해야 한다.

  //  public MenuGroup() {
  //    super();    // 컴파일오류!
  //  }

  public MenuGroup(String title) {
    super(title);
  }

  // 개발자에게 선택권을 준다. 기본값이 아닌 다른 값을 주고 싶을 때
  // 다른 생성자를 추가한다.
  public MenuGroup(String title,  boolean disablePrevMenu) {
    super(title);
    this.disableProvMenu = disablePrevMenu;
  }

  // MenuGroup이 포함하는 하위 Menu를 다룰 수 있도록 메서드를 정의한다.
  public void add(Menu child) {
    if (this.size == this.childs.length) {
      return;   // 하위 메뉴를 저장하는 배열이 꽉 찼다면 더이상 저장해서는 안된다.
    }
    this.childs[this.size++] = child;
  }


  // 배열에 들어 있는 Menu 객체를 찾아 제거한다.
  public Menu remove(Menu child) {
    int index = indexOf(child);

    if (index == -1) {
      return null;
    }

    for (int i = index + 1 ; i < this.size; i++) {
      this.childs[i-1] = this.childs[i];
    }
    this.childs[--this.size] = null;
    return child;
  }


  public int indexOf(Menu child) {
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i] == child) {
        return i;
      }
    }
    return -1;
  }

  //배열에 들어 있는 Menu 객체를 찾는다.
  public Menu getMenu(String title) {

    for (int i = 0; i < this.size; i++) {
      if (this.childs[i].title.equals(title)) {
        return this.childs[i];
      }
    }
    return null;
  }

  @Override   // 컴파일러에게 오버라이딩을 제대로 하는지 조사해 달라고 요구한다.
  public void execute() {
    while (true) {
      System.out.printf("\n[%s]\n", this.title);
      for (int i = 0; i < this.size; i++) {
        System.out.printf("%d. %s\n", i + 1, this.childs[i].title);
      }

      if (!disableProvMenu) {
        System.out.println("0. 이전메뉴");
      }

      int menuNo = Prompt.inputInt("선택> ");

      if (menuNo == 0 && !disableProvMenu) {
        return;
      }

      if (menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한 메뉴 번호입니다.");
        continue;
      }

      this.childs[menuNo - 1].execute();

    }
  }

}














