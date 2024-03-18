package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.*;

public class TaskD {
    TreeMap<Integer,Integer>[] all;
    int N;

    void add(int size, int from){
        if(all[from] == null)
            all[from] = new TreeMap<>();
        all[from].put(size, all[from].getOrDefault(size, 0)+1);
    }

    boolean check(int div) {
        for (int i = 0; i < div; i++) {
            for (int num = i+div; num < N ; num+=div) {
                if(all[num] == null && all[num-div] == null)
                    continue;
                if(all[num] == null || all[num-div] == null)
                    return false;
                if(all[num].entrySet().size() != all[num-div].entrySet().size())
                    return false;
                Iterator<Map.Entry<Integer, Integer>> it1 = all[num].entrySet().iterator();
                Iterator<Map.Entry<Integer, Integer>> it2 = all[num-div].entrySet().iterator();
                while(it1.hasNext()){
                    Map.Entry<Integer, Integer> e1 = it1.next();
                    Map.Entry<Integer, Integer> e2 = it2.next();
                    if(!e1.getKey().equals(e2.getKey()) || !e1.getValue().equals(e2.getValue())){
                        return false;
                    }
                }

            }
        }
        return true;

    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {

        N = in.ni();
        int M = in.ni();
        all = new TreeMap[N];
        for (int i = 0; i < M; i++) {
            int a = in.ni()-1, b = in.ni()-1;
            int left = Math.max(a, b) - Math.min(a, b);
            int right = Math.min(a, b) + N - Math.max(a, b);
            int size = Math.min(left, right);
            if(left < right){
                add(size, Math.min(a,b));
            } else if(right < left){
                add(size, Math.max(a,b));
            } else {
                add(size, a);
                add(size, b);
            }
        }
        for (int div = 1; div*div <= N ; div++) {
            if(N%div == 0) {
                if (check(div)) {
//                    System.out.println("div = " + div);
                    out.println("Yes");
                    return;
                }
                if (div * div < N && div != 1) {
                    if (check(N/div)) {
//                        System.out.println("div = " + (N/div));
                        out.println("Yes");
                        return;
                    }
                }
            }
        }
        out.println("No");
    }
}
