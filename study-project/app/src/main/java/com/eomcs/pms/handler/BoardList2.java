package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Board;

public class BoardList2 {

  static class Node {
    Board board;
    Node next;

    public Node(Board board) {
      this.board = board;
    }
  }

  Node head;
  Node tail;
  int size = 0;

  public void add(Board board) {
    Node node = new Node(board);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public Board[] toArray() {
    Board[] arr = new Board[this.size];

    Node node = head;

    for (int i = 0; i < this.size; i++) {
      arr[i] = node.board;
      node = node.next;
    } 
    return arr;
  }

  public Board findByNo(int no) {
    Node node = head;
    while (node != null)  {
      if (node.board.no == no) {
        return node.board;
      }
      node = node.next;
    }
    return null;
  }

  public boolean remove(Board board) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.board == board) {
        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
        }
        node.next = null; // 다음 노드와의 연결을 끊는다.

        if (node == tail) { // 삭제할 현재 노드가 마지막 노드라면
          tail = prev; // 이전 노드를 마지막 노드로 설정한다.
        }
        size--;
        return true;
      }
      // 현재 노드가 아니라면,
      prev = node; // 현재 노드를 prev 에 저장하고,
      node = node.next; // node는 다음 노드를 가리킨다.
    }
    return false;
  }
}








