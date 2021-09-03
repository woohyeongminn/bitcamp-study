package com.eomcs.lang.ex05;

//# 비트 연산자 : 응용 V - 사용자 권한 관리에 적용
//
public class Exam0480 {
  public static void main(String[] args) {
    // 1) 사용자 권한을 값으로 정의
    final int LOGOUT = 0x01;   // 0000 0001  - 로그아웃
    final int GENERAL = 0x02;  // 0000 0010  - 일반 로그인
    final int ADMIN = 0x04;  // 0000 0100  - 관리자 로그인

    // 2) 메뉴의 접근 범위를 설정
    int menu1 = LOGOUT;    // 로그아웃 상태에서만 접근 가능한 메뉴
    int menu2 = GENERAL;   // 일반으로 로그인 된 사용자만 접근 가능한 메뉴
    int menu3 = ADMIN;   // 관리자로 로그인 된 사용자만 접근 가능한 메뉴
    int menu4 = LOGOUT | GENERAL | ADMIN;  // 모두 접근 가능한 메뉴

    // 3) 접근 테스트
    //  => menu1이 로그아웃 상태에서 접근 가능한 것인지 검사한다.
    System.out.println((menu1 & LOGOUT) > 0);
    // 계산 원리
    //      menu1:   0000 0001
    //      LOGOUT:  0000 0001
    //            &--------------
    //               0000 0001     <----- 0 보다 큰 값이 나온다.
    // 해설:
    //  어떤 값에 대해 LOGOUT 값을 & 한다는 것은
    //  LOGOUT 비트가(오른쪽에서 첫 번째 비트)가 1인지 검사한다는 뜻이다.

    System.out.println((menu1 & GENERAL) > 0);
    // 계산 원리
    //      menu1:   0000 0001
    //      GENERAL: 0000 0010
    //            &--------------
    //               0000 0000     <----- 0 보다 큰 값이 나온다.
    // 해설:
    //  어떤 값에 대해 GENERAL 값을 & 한다는 것은
    //  GENERAL 비트가(오른쪽에서 두 번째 비트)가 1인지 검사한다는 뜻이다.

    System.out.println((menu1 & ADMIN) > 0);
    // 계산 원리
    //      menu1:   0000 0001
    //      ADMI:    0000 0100
    //            &--------------
    //               0000 0000     <----- 0 보다 큰 값이 나온다.
    // 해설:
    //  어떤 값에 대해 ADMIN 값을 & 한다는 것은
    //  ADMIN 비트가(오른쪽에서 세 번째 비트)가 1인지 검사한다는 뜻이다.

  }
}
