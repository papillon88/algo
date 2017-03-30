//package tools.dynamicprogramming;

import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here

        int[][][] lcsMatrix = new int[a.length+1][b.length+1][c.length+1];

        for(int i=1;i<lcsMatrix.length;i++){
            for(int j=1;j<lcsMatrix[0].length;j++){
                for(int k=1;k<lcsMatrix[0][0].length;k++){

                    if(a[i-1]==b[j-1] & b[j-1]==c[k-1])
                        lcsMatrix[i][j][k]=lcsMatrix[i-1][j-1][k-1]+1;
                    else {
                        int[] q = {
                                lcsMatrix[i-1][j][k],
                                lcsMatrix[i][j-1][k],
                                lcsMatrix[i][j][k-1],
                                lcsMatrix[i-1][j-1][k],
                                lcsMatrix[i][j-1][k-1],
                                lcsMatrix[i-1][j][k-1]
                        };
                        Arrays.sort(q);
                        lcsMatrix[i][j][k]=q[q.length-1];
                    }
                }
            }
        }
        return lcsMatrix[lcsMatrix.length-1][lcsMatrix[0].length-1][lcsMatrix[0][0].length-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

