package com.eomcs.algorithm.quiz;

public class Test {

  public static void main(String[] args ) {
    int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
    int half = arr.length /2 ;

    for (int i = 0; i < half; i++) {
      for (int j = 1; j < half+1; j++) {
        int temp = arr[i];
        arr[i] = arr[i + half];
        arr[i + half] = temp ;
      }
      //System.out.printf("%d <--> %d\n",arr[i],arr[i + half]);
    }
    for (int a : arr) {
      System.out.print("{" + a +"," );
    }
  }
}

