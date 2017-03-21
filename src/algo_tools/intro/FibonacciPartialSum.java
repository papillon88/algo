package algo_tools.intro;

import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long[] array = new long[64];
        long periodLength = 0;
        if (from == 1 & to == 1){
            return from;
        }
        if (from == 0 & to == 0){
            return from;
        }
        if (from == 0 & to == 1){
            return to - from;
        }
        if (to > 1) {
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
        long pisanoPeriod = (to+1)/periodLength;
        long pisanoRemainder = (to+1)%periodLength;
        long sumTo = 0;
        for(int i=0;i<periodLength;i++){
            sumTo = (sumTo%10 + array[i]%10)%10;
        }
        sumTo = sumTo*pisanoPeriod%10;
        for(int i=0;i<pisanoRemainder;i++){
            sumTo = (sumTo%10 + array[i]%10)%10;
        }
        pisanoPeriod = (from)/periodLength;
        pisanoRemainder = (from)%periodLength;

        long sumFrom = 0;
        for(int i=0;i<periodLength;i++){
            sumFrom = (sumFrom%10 + array[i]%10)%10;
        }
        sumFrom = sumFrom*pisanoPeriod%10;
        for(int i=0;i<pisanoRemainder;i++){
            sumFrom = (sumFrom%10 + array[i]%10)%10;
        }
        long finalSum = sumTo - sumFrom;
        if(finalSum<0)
            return 10 + finalSum;
        else
            return finalSum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

