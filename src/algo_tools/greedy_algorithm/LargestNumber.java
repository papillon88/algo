package algo_tools.greedy_algorithm;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        List<String> list1 = new ArrayList<>(Arrays.asList(a));
        StringBuilder string = new StringBuilder();
        long max;
        int maxIndex;
        while (!list1.isEmpty()){
            max=0;
            maxIndex=0;
            for (int i = 0; i < list1.size(); i++) {
                if(isGreaterOrEqual(Long.parseLong(list1.get(i)),max)){
                    max=Long.parseLong(list1.get(i));
                    maxIndex = i;
                }
            }
            string.append(String.valueOf(Long.parseLong(list1.get(maxIndex))));
            list1.remove(maxIndex);
        }

        return string.toString();
    }
    private static boolean isGreaterOrEqual(long long1,long long2){

        String string1 = String.valueOf(long1);
        String string2 = String.valueOf(long2);

        long newLong1 = Long.parseLong(string1+string2);
        long newLong2 = Long.parseLong(string2+string1);

        if(newLong1>=newLong2)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

