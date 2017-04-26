package data_structures.hash_tables;

import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;
    private static final long X = 1;
    private static final long P = 100000007;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        //testing code
        /*while(true){
            getOccurrences(readInput());
        }*/
        //end of testing code

        //normal code
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    //normal code
    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    //testing code
    /*private static Data readInput() throws IOException {
        SecureRandom random = new SecureRandom();
        int patternL = 5+random.nextInt(4);
        int textL = 300+random.nextInt(10000);

        StringBuilder pattern = new StringBuilder();
        StringBuilder text = new StringBuilder();

        for(int i=0;i<patternL;i++){
            int flip = random.nextInt(5);
            char c;
            if(flip>2){
                //uppercase
                c = (char)(65+random.nextInt(3));
            } else {
                //lowercase
                c = (char)(97+random.nextInt(3));
            }
            pattern.append(c);
        }
        for(int i=0;i<textL;i++){
            int flip = random.nextInt(5);
            char c;
            if(flip>2){
                //uppercase
                c = (char)(65+random.nextInt(3));
            } else {
                //lowercase
                c = (char)(97+random.nextInt(3));
            }
            text.append(c);
        }
        String finalPattern = pattern.toString();
        String finalText = text.toString();
        return new Data(finalPattern, finalText);
    }*/
    //end of testing code

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static long hashFunc(String s) {
        long hash = 0;
        for (int i=0;i<s.length();i++){
            long a = (hash+(long)s.charAt(i)*(long)Math.pow(X,i));
            hash=(a%P+P)%P;
        }
        return hash;
    }

    private static List<Integer> getOccurrences(Data input) {
        String s = input.pattern, t = input.text;
        int m = s.length(), n = t.length();
        List<Integer> occurrences = new ArrayList<Integer>();
        //List<Integer> occurrencesBruteForce = new ArrayList<Integer>();
        //List<Integer> hash = new ArrayList<>();
        long hashPattern = hashFunc(s);
        long[] hash = new long[n-m+1];
        hash[hash.length-1]=hashFunc(t.substring(n-m,n));
        for(int i=hash.length-2;i>=0;i--){
            long a = (long)((long)t.charAt(i)+(long)hash[i+1]*X-(long)t.charAt(i+m)*(long)Math.pow(X,m));
            hash[i]=(a%P+P)%P;
        }
        for(int i=0;i<hash.length;i++){
            if(hash[i]==hashPattern){
               if(t.regionMatches(i,s,0,m))
                    occurrences.add(i);
            }

        }
        //testing code
        /*for(int i=0;i<=n-m;i++){
            if(t.substring(i,i+m).equals(s))
                occurrencesBruteForce.add(i);
        }
        if(occurrences.size()==occurrencesBruteForce.size()){
            int temp = 0;
            for(int i=0;i<occurrences.size();i++){
                if(!occurrences.get(i).equals(occurrencesBruteForce.get(i))){
                    temp++;
                    System.out.printf("Errrrrrrr   %nOccurence(i):%d%n    OccurenceBF(i):%d%n      Text:%s%n   Pattern:%s%n",
                            occurrences.get(i),occurrencesBruteForce.get(i),t,s);
                    break;
                }
            }
            if(temp!=0){
                //do nothing
            } else
                System.out.printf("Allsssssss wellllllll%nOccurence:%d%nOccurenceBF:%d%nText:%s%nPattern:%s%n",
                        occurrences.size(),occurrencesBruteForce.size(),t,s);
        } else {
            System.out.printf("Errrrrrrr due to unequal sizes%nOccurence:%d%nOccurenceBF:%d%nText:%s%nPattern:%s%n",
                    occurrences.size(),occurrencesBruteForce.size(),t,s);
        }*/
        //end of testing code
        return occurrences;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
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

