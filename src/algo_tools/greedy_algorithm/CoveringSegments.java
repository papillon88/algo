package algo_tools.greedy_algorithm;

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        Arrays.sort(segments,Comparator.comparing(segment -> segment.end));
        List<Segment> segmentList = new ArrayList<>(Arrays.asList(segments));
        List<Integer> points = new ArrayList<>();
        while(!segmentList.isEmpty()){
            int end = segmentList.get(0).end;
            points.add(end);
            segmentList.remove(0);
            segmentList.removeIf(segment -> segment.start<=end);
        }
        //points.forEach(System.out::println);
        int[] pointsArray = new int[points.size()];
        for(int i=0;i<points.size();i++){
            pointsArray[i]=(int)points.get(i);
        }
        return pointsArray;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
