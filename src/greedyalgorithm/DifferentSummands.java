package greedyalgorithm;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();
        //write your code here
        int backupForN = n;
        for(int i=1;;i++){
            int temp = n-i;
            if(temp<=i)
                break;
            else{
                n-=i;
                summands.add(i);
            }
        }
        int sum=0;
        for(int i=0;i<summands.size();i++)
            sum+=summands.get(i);
        summands.add(backupForN-sum);
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

