package data_structures.pri_que_disj_sets;

/**
 * Created by papillon on 3/25/2017.
 */
public class Heap {

    public static void heapsort(int[] array){
        PriorityQueue pq = new PriorityQueue(array);
        for(int i=0;i<array.length;i++){
            array[array.length-1-i]=pq.extractMax();
        }
    }

    public static void buildHeap(int[] array){
        int n = array.length;
        for(int i=n/2;i>1;i--){
            int l = 2*i;
            int r = 2*i + 1;


        }
    }
}
