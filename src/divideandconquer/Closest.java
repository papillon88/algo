//package divideandconquer;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)",this.x,this.y);
        }
    }

    static double minimalDistance(int[] x, int y[]) {
        double ans = Double.POSITIVE_INFINITY;
        //write your code here

        Point[] pointArray = new Point[x.length];
        for(int i=0;i<pointArray.length;i++){
            pointArray[i] = new Point(x[i],y[i]);
        }

        Arrays.sort(pointArray);
        ans = partitionThenFindMinDistance(pointArray,0,pointArray.length-1);
        return ans;
    }
    static double partitionThenFindMinDistance(Point[] pointArray,int down,int up){

        if(up-down==1){
            //2 points
            long x1 = pointArray[down].x;
            long x2 = pointArray[up].x;
            long y1 = pointArray[down].y;
            long y2 = pointArray[up].y;
            return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        } else if(up-down==2){
            //3 points
            int mid = down + 1;
            long x1 = pointArray[down].x;
            long y1 = pointArray[down].y;
            long x2 = pointArray[mid].x;
            long y2 = pointArray[mid].y;
            long x3 = pointArray[up].x;
            long y3 = pointArray[up].y;
            double min1 = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
            double min2 = Math.sqrt(Math.pow(x2-x3,2)+Math.pow(y2-y3,2));
            double min3 = Math.sqrt(Math.pow(x1-x3,2)+Math.pow(y1-y3,2));
            double tempMin1 = Math.min(min1,min2);
            double tempMin2 = Math.min(min2,min3);
            return Math.min(tempMin1,tempMin2);
        } else {
            //do nothing
        }

        int mid = down + (up - down)/2;
        double min1 = partitionThenFindMinDistance(pointArray,mid+1,up);
        double min2 = partitionThenFindMinDistance(pointArray,down,mid);
        double min3 = Math.sqrt(Math.pow(pointArray[mid].x-pointArray[mid+1].x,2)
                +Math.pow(pointArray[mid].y-pointArray[mid+1].y,2));

        double minFromTwoPartitions = Math.min(min1,min2);
        double intermediateMinFromTwoPartitions = minFromTwoPartitions;

        List<Point> upperPart = new ArrayList<>();
        List<Point> lowerPart = new ArrayList<>();

        int upperPoint = mid + 1;
        long yOfUpperPoint = pointArray[upperPoint].y;
        while(upperPoint<=up){
            if(pointArray[upperPoint].y==yOfUpperPoint){
                upperPart.add(pointArray[upperPoint]);
                upperPoint++;
            } else {
                break;
            }
        }
        int lowerPoint = mid;
        long yOfLowerPoint = pointArray[lowerPoint].y;
        while(lowerPoint>=down){
            if(pointArray[lowerPoint].y==yOfLowerPoint){
                lowerPart.add(pointArray[lowerPoint]);
                lowerPoint--;
            } else {
                break;
            }
        }

        for(Point pu : upperPart){
            for(Point pl : lowerPart){
                double dist = Math.sqrt((Math.pow(pu.x-pl.x,2))
                        +Math.pow(pu.y-pl.y,2));
                if(dist<intermediateMinFromTwoPartitions)
                    intermediateMinFromTwoPartitions = dist;
            }
        }
        return Math.min(minFromTwoPartitions,intermediateMinFromTwoPartitions);
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
