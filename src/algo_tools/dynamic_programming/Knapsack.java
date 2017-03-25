package algo_tools.dynamic_programming;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int knapsackWeight = W;
        int[] itemValue = w;
        int[] itemWeights = w;
        int[][] knapsackArray = new int[itemValue.length+1][knapsackWeight+1];

        for(int i=1;i<knapsackArray.length;i++){
            for(int j=1;j<knapsackArray[0].length;j++){
                knapsackArray[i][j]=knapsackArray[i-1][j];
                if(itemWeights[i-1]<=j){
                    int tempVal = knapsackArray[i-1][j-itemWeights[i-1]] + itemValue[i-1];
                    if(tempVal>knapsackArray[i][j])
                        knapsackArray[i][j]=tempVal;
                }
            }
        }
        /*for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }*/
        return knapsackArray[knapsackArray.length-1][knapsackArray[0].length-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

