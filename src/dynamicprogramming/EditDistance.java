package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by papillon on 2/23/2017.
 */
public class EditDistance {


    private static class Node {
        int editDistance;
        List<Integer> pointers;
    }

    public static void main(String[] args){

        char[] array1 = "editing".toCharArray();
        char[] array2 = "distance".toCharArray();
        int colLength = "editing".length()+1;
        int rowLength = "distance".length()+1;

        int[][] editDistance = new int[colLength][rowLength];
        for(int i=0;i<rowLength;i++)
            editDistance[0][i]=i;
        for(int i=0;i<colLength;i++)
            editDistance[i][0]=i;

        for(int i=1;i<colLength;i++){
            for(int j=1;j<rowLength;j++){
                int[] editDistanceArray = {
                        editDistance[i-1][j]+1,
                        editDistance[i][j-1]+1,
                        array1[i-1]==array2[j-1]? editDistance[i-1][j-1] : editDistance[i-1][j-1]+1
                };
                Arrays.sort(editDistanceArray);
                editDistance[i][j]=editDistanceArray[0];
            }
        }

        for(int i=0;i<colLength;i++){
            for(int j=0;j<rowLength;j++){
                System.out.printf("%d  ",editDistance[i][j]);
            }
            System.out.printf("%n");
        }

    }
}
