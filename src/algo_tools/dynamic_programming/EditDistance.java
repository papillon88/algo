package algo_tools.dynamic_programming;

import java.util.*;

class EditDistance {

  public static int EditDistance(String s, String t) {
    //write your code here
    String s1 = s;  //"bread";//"editing";
    String s2 = t;  //"really";//"distance";

    char[] array1 = s1.toCharArray();
    char[] array2 = s2.toCharArray();
    int colLength = s1.length()+1;
    int rowLength = s2.length()+1;

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
                //array1[i-1]==array2[j-1]? editDistance[i-1][j-1] : Integer.MAX_VALUE
        };
        Arrays.sort(editDistanceArray);
        editDistance[i][j]=editDistanceArray[0];
      }
    }
    return editDistance[colLength-1][rowLength-1];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
