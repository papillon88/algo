package data_structures.pri_que_disj_sets;

/**
 * Created by papillon on 3/25/2017.
 */
public class TestPriorityQueue {

    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue();
        pq.insert(100);
        pq.insert(2);
        pq.insert(-3);
        pq.insert(400);
        pq.insert(5);
        pq.insert(6);
        pq.insert(199);
        System.out.printf("%d%n",pq.extractMax());
        //heapsort
        int[] array = {900,2,5,19,45,23,90,0};
        Heap.heapsort(array);
        for(int i : array)
            System.out.printf("%d ",i);

    }
}
