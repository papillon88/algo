package algo_tools.greedy_algorithm;

/**
 * Created by papillon on 2/15/2017.
 */
public class CarRefuelling {

    public static void main(String[] args){


        int[] distance = {10,10,150,100,10};
        int car = 150;
        int minRefills = 0;

        for(int i=0;i<distance.length;i++){
            if(car>=distance[i]){
                car-=distance[i];
            } else {
                car=150;
                minRefills++;
                i-=1;
            }
        }
        System.out.printf("Min refills : %-5d",minRefills);


    }
}
