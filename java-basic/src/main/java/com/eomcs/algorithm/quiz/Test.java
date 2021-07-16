package com.eomcs.algorithm.quiz;

public class Test {

  public static void main(String[] args ) {
    int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
    int half = arr.length /2 ;

    for (int i = 0; i < half; i++) {
      for (int j = 0; j < half+1; j++) {
        //                int temp = arr[i];
        //                arr[i] = arr[half+j];
        //                arr[half+j] = arr[i];
        System.out.printf("%d <--> %d\n",arr[i],arr[j]);
      }
    }

  }
}

