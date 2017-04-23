package data_structures.hash_tables;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
    //ArrayList<ArrayList<String>> elems;
    //private List<String> elems;
    ArrayList<String>[] elems;
    // for hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

    ArrayList<String> tempList;

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                int tempHash = hashFunc(query.s);
                if(elems[tempHash]==null){
                    ArrayList<String> l = new ArrayList<>();
                    l.add(query.s);
                    elems[tempHash]=l;
                } else {
                    tempList = elems[tempHash];
                    if (!tempList.contains(query.s))
                        tempList.add(0, query.s);
                }
                break;
            case "del":
                tempHash = hashFunc(query.s);
                if(elems[tempHash]!=null){
                    tempList = elems[tempHash];
                    if (tempList.contains(query.s))
                        tempList.remove(query.s);
                    break;
                } else {
                    break;
                }
            case "find":
                tempHash = hashFunc(query.s);
                if(elems[tempHash]!=null){
                    tempList = elems[tempHash];
                    writeSearchResult(tempList.contains(query.s));
                    break;
                } else {
                    writeSearchResult(false);
                    break;
                }
            case "check":
                //tempHash = hashFunc(query.s);
                if(elems[query.ind]!=null){
                    tempList = elems[query.ind];
                    for (String cur : tempList)
                        out.print(cur + " ");
                    out.println();
                    break;
                } else {
                    out.println();
                }
                    break;
                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
        //ArrayList<String>[] temp = new ArrayList[56];
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        elems = new ArrayList[2*bucketCount];
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
        }
    }

    /*class HashTable {
        Query[] array = new Query[bucketCount];

        void add(String s){
            int hashOfS = hashFunc(s);
            if(array[hashOfS]==null){
                //create new LL
                array[hashOfS]=new
            }
        }

    }*/

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
