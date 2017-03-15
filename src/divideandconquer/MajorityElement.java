package divideandconquer;

import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }
        /*if (left + 1 == right) {
            return a[left];
        }*/
        //write your code here
        int halfArrayLength = (right-left+1)/2;
        int mid = left + (right-left)/2;
        int first = getMajorityElement(a,left,mid);
        int second = getMajorityElement(a,mid+1,right);

        //search first in whole to verify overall majority
        int c1=0,c2=0;
        for(int i=left;i<=right;i++){
            if(first==a[i])
                c1++;
        }
        //search second in whole to verify overall majority
        for(int i=left;i<=right;i++){
            if(second==a[i])
                c2++;
        }

        if(first==second & (c1+c2)>halfArrayLength)
            return first;
        else if(first!=second & c1>halfArrayLength)
            return first;
        else if(first!=second & c2>halfArrayLength)
            return second;
        else if(first==-1 & second!=-1 & c2>halfArrayLength)
            return second;
        else if(second==-1 & first!=-1 & c1>halfArrayLength)
            return first;
        else if(first==-1 & second==-1)
            return -1;
        else
            return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

