package algo_tools.intro;

import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {

        long[] array = new long[((int) m * 6)+4];
        long periodLength = 0;
        if (m <= 1)
            array[(int) m] = m;
        if (m > 1) {
            array[0] = 0;
            array[1] = 1;
            for (int i = 2; i < array.length; i++) {
                //array[i] = array[i - 1] + array[i - 2];
                array[i] = (array[i - 1]%m + array[i - 2]%m) % m;
                //System.out.print(array[i]+"-");
            }

            for(int i=3;i<=array.length-1-3;i++){
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
        long pisanoRemainder = (n+1)%periodLength;
        //return array[((int) m * 6)-1];
        //System.out.println(pisanoRemainder);
        if(pisanoRemainder==0)
            return array[(int)periodLength-1];
        else
            return array[(int)pisanoRemainder-1];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

