package data_structures.pri_que_disj_sets;

import java.io.*;

//for testing purpose
//import java.security.SecureRandom;
import java.util.*;
import java.util.PriorityQueue;

public class JobQueue {
    //for testing purpose
    //private static SecureRandom rand = new SecureRandom();
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    //for testing purpose
    //private int[] assignedWorkerBF;
    //private long[] startTimeBF;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    //generating testing data
    /*private void readData() throws IOException {
        numWorkers = rand.nextInt(200) + 1;
        int m = rand.nextInt(2000000) + 20;
        jobs = new int[m];
        //System.out.printf("**************%n");
        //System.out.printf("workers : %d%njobs : %d%n",numWorkers,m);
        for (int i = 0; i < m; ++i) {
            jobs[i] = rand.nextInt(500000) + 100;
            //System.out.printf("%d ",jobs[i]);
        }
        //System.out.printf("%n**************%n");
    }*/


    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        PriorityQueue<PackagedJobs> pq =
                new PriorityQueue<>(jobs.length,Comparator.comparing(PackagedJobs::getJobTime)
                        .thenComparing(PackagedJobs::getThreadId));
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        int fillIndex = 0;
        long start = 0;
        long cumulativeCorrection = 0;
        //initial scheduling at t=0
        if(numWorkers<=jobs.length){
            for(int i=0;i<numWorkers;i++){
                pq.add(new PackagedJobs(jobs[i],i));
                assignedWorker[i]=i;
                startTime[i]=0;
                fillIndex++;
            }
            while(fillIndex<jobs.length){
                PackagedJobs temp = pq.peek();
                pq.remove(temp);
                //int tempReserve = temp.reserve;
                int tempThreadId = temp.threadId;
                long tempJobTime = temp.jobTime;
                start+=(tempJobTime-cumulativeCorrection);
                cumulativeCorrection = tempJobTime;
                startTime[fillIndex]=start;
                assignedWorker[fillIndex] = tempThreadId;
                pq.add(new PackagedJobs(jobs[fillIndex]+tempJobTime,tempThreadId));
                fillIndex++;
            }
        } else {
            for(int i=0;i<jobs.length;i++){
                pq.add(new PackagedJobs(jobs[i],i));
                assignedWorker[i]=i;
                startTime[i]=0;
            }
        }

        //for testing purpose
        //brute force
        /*assignedWorkerBF = new int[jobs.length];
        startTimeBF = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorkerBF[i] = bestWorker;
            startTimeBF[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }

        int a=0,length=assignedWorker.length;
        for(int i=0;i<length;i++){
            if(assignedWorker[i]!=assignedWorkerBF[i] | startTime[i]!=startTimeBF[i]){
                a++;
                break;
            }
        }
        if(a!=0){
            System.out.println("ERROR");
            System.out.println(numWorkers);
            *//*for(int i=0;i<length;i++){
                System.out.print(jobs[i]+" ");
            }*//*
            System.out.println(jobs.length);
            System.out.println("*******************************");
        } else {
            System.out.println("OKAY");
        }*/

    }

    static class PackagedJobs {
        long jobTime;
        int threadId;
        //int reserve;
        PackagedJobs(long jobTime,int threadId){
            this.jobTime = jobTime;
            this.threadId = threadId;
            //this.reserve = reserve;
        }
        long getJobTime(){
            return this.jobTime;
        }
        int getThreadId(){
            return this.threadId;
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        //testing code
        /*while(true){
            try{
                readData();
                assignJobs();
                //writeResponse();
            } catch (Exception e){
                System.out.println("ERROR OCCURED+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }*/
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
