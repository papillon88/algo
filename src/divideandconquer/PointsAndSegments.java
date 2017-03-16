package divideandconquer;

import java.util.*;
import java.util.function.Function;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here

        List<Point> pointsList = new ArrayList<>();
        for(int i=0;i<starts.length;i++){
            pointsList.add(new Point(starts[i],'l'));
            pointsList.add(new Point(ends[i],'r'));
        }
        for(int i=0;i<points.length;i++){
            pointsList.add(new Point(points[i],'p'));
        }
        Function<Point,Integer> funcForComparingByVal = Point::getVal;
        Function<Point,Character> funcForComparingByPos = Point::getPos;
        pointsList.sort(Comparator.comparing(funcForComparingByVal).thenComparing(funcForComparingByPos));
        List<Point> stack = new ArrayList<>();
        List<Point> tempList = new ArrayList<>();

        for(int i=0;i<pointsList.size();i++){
            if(pointsList.get(i).pos=='l'){
                stack.add(pointsList.get(i));
            } else if(pointsList.get(i).pos=='r'){
                if(!stack.isEmpty())
                    stack.remove(stack.size()-1);
            } else if(pointsList.get(i).pos=='p'){
                int stackSize = stack.size();
                pointsList.get(i).count += stackSize;
                tempList.add(pointsList.get(i));
                //int newCount = pointsMap.get(pointsList.get(i).val) + stackSize;
                //pointsMap.put(pointsList.get(i).val,newCount);
            } else {
                //do nothing
            }
        }

        int[] tempPointsListArrayForBinarySearch = new int[tempList.size()];
        for(int i=0;i<points.length;i++){
            tempPointsListArrayForBinarySearch[i]=tempList.get(i).val;
        }

        for(int i=0;i<points.length;i++){
            int index = Arrays.binarySearch(tempPointsListArrayForBinarySearch,points[i]);
            cnt[i] = tempList.get(index).count;
        }
        return cnt;
    }

    private static class Point{
        int val;
        char pos;
        int count;
        Point(int val,char pos){
            this.val=val;
            this.pos=pos;
        }
        int getVal(){
            return val;
        }
        char getPos(){
            return pos;
        }
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        //int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

