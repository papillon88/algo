package algo_tools.intro;

import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    /*if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);*/
    long[] array = new long[n+1];
    if (n <= 1)
      array[n] = n;
    if (n > 1){
      array[0] = 0;
      array[1] = 1;
      //System.out.print("0-1-");
      for (int i = 2; i <= n; i++){
        array[i] = array[i - 1] + array[i - 2];
        //array[i] = (array[i - 1] + array[i - 2])%5;
        //System.out.print(array[i]+"-");
      }

    }
    return array[n];
    //3867759273386675073
    //957756044990980578
    //8259707399215967867
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib(n));
  }
}
