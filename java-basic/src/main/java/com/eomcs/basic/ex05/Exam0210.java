// Stack 과 Deque
package com.eomcs.basic.ex05;

import java.util.ArrayDeque;

public class Exam0210 {

  public static void main(String[] args) {

    // Deque 인터페이스
    // - "Double ended queue"의 약자이다.
    //   즉 앞, 뒤 모두 양방향에서 값을 놓고 꺼낼 수 있다.
    // - 그래서 queue로도 사용할 수 있고 stack으로도 사용할 수 있다.
    // - queue, stack 둘 다 사용할 수 있도록 
    //   queue, stack 사용법을 모두 정의한 인터페이스다.

    // 다음은 Dequeue 구현체 중의 하나이다.
    ArrayDeque<String> stack = new ArrayDeque<>();

    // 다음과 같이 stack으로서 사용할 수 있다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

}

