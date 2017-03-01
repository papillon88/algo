package greedyalgorithm;


import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {

        double totalValue = 0.0;
        double capacityInDouble = (double)capacity;
        List<List<Double>> newList = new ArrayList<>();

        for(int i=0;i<values.length;i++){
            List<Double> subList = new ArrayList<>();
            subList.add((double)values[i]/weights[i]);
            subList.add((double)values[i]);
            subList.add((double)weights[i]);
            newList.add(subList);
        }
        newList.sort((list1,list2) -> {
            if(list1.get(0)>list2.get(0))
                return -1;
            else
                return 1;
        });
        /*newList.forEach(list -> {
            list.forEach(value -> System.out.printf("%.4f%n",value));
            System.out.printf("*******%n");
        });*/

        for(List<Double> list : newList){
            double valuePerWeight = list.get(0);
            double value = list.get(1);
            double weight = list.get(2);
            double min = Math.min(capacityInDouble,weight);

            if(capacityInDouble!=0){
                totalValue+=valuePerWeight*min;
                capacityInDouble-=min;
            } else
                break;
        }
        return Math.round(totalValue*10000.0)/10000.0;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
