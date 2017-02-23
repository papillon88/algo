package intro;

import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        /*if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = ((tmp_previous%m) + (current%m))%m;
        }

        return current;*/

        long[] array = new long[((int) m * 6)+4];
        long periodLength = 0;
        if (m <= 1)
            array[(int) m] = m;
        if (m > 1) {
            array[0] = 0;
            array[1] = 1;
            //System.out.print("0-1-");
            for (int i = 2; i <= ((int) m * 6)-1+4; i++) {
                //array[i] = array[i - 1] + array[i - 2];
                array[i] = (array[i - 1] + array[i - 2]) % m;
                //System.out.print(array[i]+"-");
            }

            /*for(int i=0;i<=array.length-1;i++)
                System.out.print(array[i]+"-");*/

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

