package algo_tools.intro;

import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        int[] arr = new int[n+1];
        if (n <= 1){
            arr[n]=n;
            return arr[n];
        }
        if(n>1){
            arr[0]=0;
            arr[1]=1;
            for(int i=2;i<arr.length;i++){
                arr[i]=(arr[i-1]+arr[i-2])%10;
            }
        }
/*
        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = ((tmp_previous%10) + (current%10))%10;
        }*/



        return arr[n];
        //return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getFibonacciLastDigitNaive(scanner.nextInt()));
    }
}

