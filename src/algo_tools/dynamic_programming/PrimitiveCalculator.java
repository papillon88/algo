package algo_tools.dynamic_programming;

import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        /*while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }*/

        int[] arr1 = new int[n+1];
        int[] arr2 = new int[n+1];
        for(int i=2;i<arr1.length;i++){
            int num1,num2,num3;
            if(i%2==0)
                num2=arr1[i/2]+1;
            else {
                num2=Integer.MAX_VALUE;
            }
            if(i%3==0)
                num3=arr1[i/3]+1;
            else {
                num3=Integer.MAX_VALUE;
            }
            num1 = arr1[i-1]+1;
            int min1 = Math.min(num1,num2);
            int min2 = Math.min(num2,num3);
            arr1[i]=Math.min(min1,min2);
            if(arr1[i]==num1)
                arr2[i]=i-1;
            else if(arr1[i]==num2)
                arr2[i]=i/2;
            else if(arr1[i]==num3)
                arr2[i]=i/3;
            else {
                //do nothing
            }
        }

        int i = n;
        sequence.add(n);
        while(i>1){
            int m = arr2[i];
            sequence.add(m);
            i=m;
        }

        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

