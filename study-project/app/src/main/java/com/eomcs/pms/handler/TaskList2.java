package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Task;

public class TaskList2 {

  static class Node {

    Task task;
    Node next;

    public Node(Task task) {
      this.task = task;
    }
  }

  int size = 0;
  Node head;
  Node tail;

  public void add(Task task) {
    Node node = new Node(task);
    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size ++;
  }

  public Task[] toArray() {
    Task[] arr = new Task[this.size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    Node node = head;
    for (int i = 0; i < size; i++) {
      arr[i] = node.task;
      node = node.next;
    }
    return arr; // 새 배열을 리턴한다.
  }

  public Task findByNo(int no) {
    Node node = head;
    while (node != null) {
      if (node.task.no == no) {
        return node.task;
      }
      node = node.next;
    }
    return null;
  }

  public boolean remove(Task task) {
    Node node = head;
    Node prev = null;
    while (node != null) {
      if (node.task == task) {
        if (node == head) {
          head = node.next;
        } else {
          prev = node.next;
        }
        node.next = null;
        if (node == tail) {
          tail = prev;
        }
        size --;
        return true;
      }
      prev = node;
      node = node.next;
    }
    return false;
  }


}








