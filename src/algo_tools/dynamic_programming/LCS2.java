package algo_tools.dynamic_programming;

import java.util.Scanner;

/**
 * Created by papillon on 3/1/2017.
 */
public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here

        int[][] lcsMatrix = new int[a.length+1][b.length+1];
        for(int i=0;i<lcsMatrix.length;i++)
            lcsMatrix[i][0]=0;
        for(int i=0;i<lcsMatrix[0].length;i++)
            lcsMatrix[0][i]=0;

        for(int i=1;i<lcsMatrix.length;i++){
            for(int j=1;j<lcsMatrix[0].length;j++){
                if(a[i-1]==b[j-1])
                    lcsMatrix[i][j]=lcsMatrix[i-1][j-1]+1;
                else {
                    int q1 = lcsMatrix[i-1][j];
                    int q2 = lcsMatrix[i][j-1];
                    lcsMatrix[i][j]=Math.max(q1,q2);
                }
            }
        }
        return lcsMatrix[lcsMatrix.length-1][lcsMatrix[0].length-1];
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
        /*int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }*/
        System.out.println(lcs2(a, b));
    }
}
