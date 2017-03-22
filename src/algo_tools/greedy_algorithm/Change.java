package algo_tools.greedy_algorithm;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here

        //no restriction such that exchanged coins must be min etc...
        if(m>=0 & m<5){
            return m;
        } else if(m>=5 & m<10){
            return 1 + getChange(m-5);
        } else {
            return 1 + getChange(m-10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

