package data_structures.pri_que_disj_sets;

import java.util.Arrays;

/**
 * Created by papillon on 3/24/2017.
 */
public class PriorityQueue {

    private int[] pqArray;
    private int pos = 1;

    public PriorityQueue(int n){
        pqArray = new int[n+1];
    }
    public PriorityQueue(){
        this(10);
    }
    public PriorityQueue(int[] array){
        pqArray = new int[array.length + 1];
        for(int i=0;i<array.length;i++){
            this.insert(array[i]);
        }
    }
    private int getParent(int i){
        return i/2;
    }
    private int getLChild(int i){
        return 2*i;
    }
    private int getRChild(int i){
        return 2*i+1;
    }
    private void siftUp(int i){
        while(i>1) {
            if(pqArray[getParent(i)]<pqArray[i]){
                int temp = pqArray[i];
                pqArray[i] = pqArray[getParent(i)];
                pqArray[getParent(i)] =  temp;
                i = getParent(i);
            } else {
                break;
            }
        }
    }
    private void siftDown(int i){
        int maxIndex = i;
        int l = getLChild(i);
        int r = getRChild(i);
        if(l<pos && pqArray[l]>pqArray[maxIndex])
            maxIndex  = l;
        if(r<pos && pqArray[r]>pqArray[maxIndex])
            maxIndex  = r;
        if(maxIndex != i){
            int temp = pqArray[i];
            pqArray[i] = pqArray[maxIndex];
            pqArray[maxIndex] = temp;
            siftDown(maxIndex);
        }
    }
    public void insert(int p){
        pqArray[pos] = p;
        siftUp(pos);
        pos++;
    }
    public int extractMax(){
        int result = pqArray[1];
        pqArray[1] = pqArray[pos-1];
        pqArray[pos-1] = result;
        pos--;
        siftDown(1);
        return result;
    }
}
