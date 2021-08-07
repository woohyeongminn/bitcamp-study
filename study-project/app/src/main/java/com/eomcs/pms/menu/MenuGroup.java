package com.eomcs.pms.menu;

import com.eomcs.util.Prompt;

public class MenuGroup extends Menu{

  Menu[] childs = new Menu[100];
  int size;
  boolean disablePrevMenu;
  String prevMenuTitle = "이전 메뉴";

  public MenuGroup(String title) {
    super(title);
  }

  public MenuGroup(String title, boolean disablePrevMenu) {
    super(title);
    this.disablePrevMenu = disablePrevMenu;
  }

  public void setPrevMenuTitle(String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;
  }

  public void add(Menu child) {
    if (this.size == this.childs.length) {
      return;
    }
    this.childs[this.size++] = child;
  }

  public Menu remove(Menu child) {
    int index = indexOf(child);
    if (index == -1) {
      return null;
    }
    for (int i = index+1; i < size; i++) {
      childs[i-1] = childs[i];
    }
    childs[--size] = null;
    return child;
  }

  public Menu getMenu(String title) {
    for (int i = 0; i < size; i++) {
      if (childs[i].title.equals(title)) {
        return childs[i];
      }
    }
    return null;
  }

  private int indexOf(Menu child) {
    for (int i = 0; i < size; i++) {
      if (childs[i] == child) {
        return i;
      }
    }
    return -1;
  }

  public void execute() {
    while (true) {
      System.out.printf("\n[%s]\n",this.title);
      for (int i =0; i < this.size; i++) {
        System.out.printf("%d. %s\n", i+1, this.childs[i].title);
      }
      if (!disablePrevMenu) {
        System.out.printf("0. %s\n", prevMenuTitle);
      }
      int menuNo = Prompt.inputInt("선택> ");
      if (menuNo == 0 && !disablePrevMenu) {
        return;
      }
      if (menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한!!! 메뉴 번호입니다.");
        continue;
      }
      this.childs[menuNo -1].execute(); 
    }

  }



}
