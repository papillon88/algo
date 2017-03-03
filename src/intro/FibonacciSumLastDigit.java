package intro;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long m) {
        long[] array = new long[64];
        long periodLength = 0;
        if (m <= 1){
            return m;
        }
        if (m > 1) {
            array[0] = 0;
            array[1] = 1;
            for (int i = 2; i < array.length; i++) {
                //array[i] = array[i - 1] + array[i - 2];
                array[i] = (array[i - 1]%10 + array[i - 2]%10) % 10;
                //System.out.print(array[i]+"-");
            }

            for(int i=3;i<=array.length-3;i++){
                //System.out.print(array[i]+"-");
                if(array[i]==0)
                    if(array[i+1]==1)
                        if(array[i+2]==1){
                            periodLength=i;
                            break;
                        } else {
                            continue;
                        }
            }
            //System.out.println("period length is : " + periodLength);
        }
        long pisanoPeriod = (m+1)/periodLength;
        long pisanoRemainder = (m+1)%periodLength;
        long sum = 0;
        for(int i=0;i<periodLength;i++){
            sum = (sum%10 + array[i]%10)%10;
        }
        sum = sum*pisanoPeriod%10;
        for(int i=0;i<pisanoRemainder;i++){
            sum = (sum%10 + array[i]%10)%10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

