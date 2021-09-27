package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[PMS 서버]");

    System.out.println("1) 서버 소캣 준비");
    ServerSocket serverSocket = new ServerSocket(8888);  // 고정 포토번호 주기

    System.out.println("2) 클라이언트의 접속을 기다림");
    Socket socket = serverSocket.accept(); // 클라이언트가 접속하면 리턴한다.

    System.out.println("3) 클라이언트가 접속 했음");

    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter out =new PrintWriter(socket.getOutputStream());

    while (true) {
      String command = in.readLine(); // 클라이언트에서 한 줄의 문자열을 보낼 때까지 기다린다.
      System.out.println("===> " + command);

      if (command.equalsIgnoreCase("quit")) {
        out.println("goodbye");
        out.flush();
        break;
      }

      out.println(command);
      out.flush();
    }

    System.out.println("4) 클라이언트와의 접속을 끊음");
    out.close(); 
    in.close();
    socket.close();

    System.out.println("5) 서버 소켓 종료");
    serverSocket.close();  // 더 이상 클라이언트의 접속을 수용하지 않는다.
  }

} 












