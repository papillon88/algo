package algo_tools.dynamic_programming;

/**
 * Created by papillon on 2/25/2017.
 */
public class KnapsackRepetitions {

    static class Items{
        int value;
        int weight;
        Items(int value,int weight){
            this.value=value;
            this.weight=weight;
        }
    }

    public static void main(String[] args){
        int knapsackWeight = 10;
        int[] knapsackArray = new int[knapsackWeight+1];
        int[] itemValue = {30,14,16,9};
        int[] itemWeights = {6,3,4,2};
        for(int i=0;i<knapsackArray.length;i++){
            knapsackArray[i]=0;
            for(int j=0;j<itemValue.length;j++){
                if(itemWeights[j]<=i){
                    int tempVal = knapsackArray[i-itemWeights[j]] + itemValue[j];
                    if(tempVal>knapsackArray[i])
                        knapsackArray[i]=tempVal;
                }
            }
        }
        for(int t : knapsackArray)
            System.out.printf("%d ",t);
    }
}
