package divideandconquer;

import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (left==right) {
            b[0]=a[left];
            return numberOfInversions;
        }
        int mid = left + (right - left) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, mid);
        List<Integer> l1 = new ArrayList<>();
        int bSize = mid - left + 1;
        for(int i=0;i<bSize;i++){
            l1.add(b[i]);
        }
        numberOfInversions += getNumberOfInversions(a, b, mid+1, right);
        List<Integer> l2 = new ArrayList<>();
        bSize = right - mid;
        for(int i=0;i<bSize;i++){
            l2.add(b[i]);
        }
        //write your code here
        List<Integer> merged = new ArrayList<>();

        //l1,l2,merged
        while(!l1.isEmpty() & !l2.isEmpty()){
            if(l1.get(0)>l2.get(0)){
                numberOfInversions+=l1.size();
                merged.add(l2.get(0));
                l2.remove(0);
            } else {
                merged.add(l1.get(0));
                l1.remove(0);
            }
        }
        if(!l1.isEmpty()){
            while(!l1.isEmpty()){
                merged.add(l1.get(0));
                l1.remove(0);
            }
        } else if(!l2.isEmpty()){
            while(!l2.isEmpty()){
                merged.add(l2.get(0));
                l2.remove(0);
            }
        } else {
            //blank;do nothing
        }

        for(int i=0;i<merged.size();i++){
            b[i]=merged.get(i);
        }

        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}

