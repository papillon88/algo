//package tools.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
        int size = exp.length()/2;
        long[][] minMatrix = new long[size+1][size+1];
        long[][] maxMatrix = new long[size+1][size+1];
        int diff=0,i=0;
        while(diff<exp.length()){
            while(i+diff<exp.length()){
                minAndMax(i,i+diff,minMatrix,maxMatrix,exp);
                i+=2;
            }
            diff+=2;
            i=0;
        }
        /*for(int a=0;a<minMatrix.length;a++){
            for(int b=0;b<minMatrix[0].length;b++){
                System.out.printf("%4d ",minMatrix[a][b]);
            }
            System.out.println();
        }
        for(int a=0;a<minMatrix.length;a++){
            for(int b=0;b<minMatrix[0].length;b++){
                System.out.printf("%4d ",maxMatrix[a][b]);
            }
            System.out.println();
        }*/
        return maxMatrix[0][size];
    }

    private static void minAndMax(int i,int j,long[][] minMatrix,long[][] maxMatrix,String exp){
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        if(i==j){
            minMatrix[i/2][j/2]=Long.parseLong(exp.substring(i,i+1));
            maxMatrix[i/2][j/2]=Long.parseLong(exp.substring(i,i+1));
        } else {
            for(int k=i+1;k<j;k+=2){
                long[] minNums = {
                        eval(minMatrix[i/2][(k-1)/2],minMatrix[(k+1)/2][j/2],exp.charAt(k)),
                        eval(minMatrix[i/2][(k-1)/2],maxMatrix[(k+1)/2][j/2],exp.charAt(k)),
                        eval(maxMatrix[i/2][(k-1)/2],minMatrix[(k+1)/2][j/2],exp.charAt(k)),
                        eval(maxMatrix[i/2][(k-1)/2],maxMatrix[(k+1)/2][j/2],exp.charAt(k)),
                        min
                };
                long[] maxNums = {
                        eval(minMatrix[i/2][(k-1)/2],minMatrix[(k+1)/2][j/2],exp.charAt(k)),
                        eval(minMatrix[i/2][(k-1)/2],maxMatrix[(k+1)/2][j/2],exp.charAt(k)),
                        eval(maxMatrix[i/2][(k-1)/2],minMatrix[(k+1)/2][j/2],exp.charAt(k)),
                        eval(maxMatrix[i/2][(k-1)/2],maxMatrix[(k+1)/2][j/2],exp.charAt(k)),
                        max
                };
                Arrays.sort(minNums);
                Arrays.sort(maxNums);
                min=minNums[0];
                max=maxNums[maxNums.length-1];
                minMatrix[i/2][j/2]=min;
                maxMatrix[i/2][j/2]=max;
            }
        }
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

