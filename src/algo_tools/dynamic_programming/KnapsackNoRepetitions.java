package algo_tools.dynamic_programming;

/**
 * Created by papillon on 2/25/2017.
 */
public class KnapsackNoRepetitions {

    public static void main(String[] args){
        int knapsackWeight = 10;
        int[] itemValue = {30,14,16,9};
        int[] itemWeights = {6,3,4,2};
        int[][] knapsackArray = new int[itemValue.length+1][knapsackWeight+1];
        int[] optimal = new int[itemValue.length];

        for(int i=1;i<knapsackArray.length;i++){
            for(int j=1;j<knapsackArray[0].length;j++){
                knapsackArray[i][j]=knapsackArray[i-1][j];
                optimal[i-1]=0;
                if(itemWeights[i-1]<=j){
                    int tempVal = knapsackArray[i-1][j-itemWeights[i-1]] + itemValue[i-1];
                    if(tempVal>knapsackArray[i][j]){
                        knapsackArray[i][j]=tempVal;
                        //optimal[i-1]=1;
                    }
                }
            }
        }
        for(int i=0;i<knapsackArray.length;i++){
            for(int j=0;j<knapsackArray[0].length;j++){
                System.out.printf("%2d ",knapsackArray[i][j]);
            }
            System.out.printf("%n");
        }

        int i = knapsackArray.length-1;
        int j = knapsackArray[0].length-1;

        while (true){
            if(knapsackArray[i][j]==knapsackArray[i-1][j]){
                optimal[i-1]=0;
                i=i-1;
                j=j;
            } else {
                optimal[i-1]=1;
                j=j-itemWeights[i-1];
                i=i-1;
            }
            if(i==0)
                break;
        }

        for(int i1=0;i1<optimal.length;i1++){
            System.out.printf("%d ",optimal[i1]);
        }

    }
}
