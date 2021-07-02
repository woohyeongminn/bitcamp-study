package com.eomcs.lang.ex03;
public class Exam0420 {
    public static void main(String[] args) {
        System.out.println(65);
        System.out.println((char)65);
        System.out.println((char)0x41);
        System.out.println((char)0xAC00);
        System.out.println((char)(0xAC00 + 1));
        for (int i=0; i<26;i++){
            System.out.print((char)(i + 65) + ",");
        }
    }
}