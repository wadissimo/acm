package codejam.year2008.r1a;

import chelper.io.FastScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class B {
    static class Customer{
        TreeMap<Integer, Integer> orders = new TreeMap<>();
        TreeMap<Integer, Integer> orig = new TreeMap<>();
        int malted = -1;
    }
    public static void main(String[] args) throws FileNotFoundException {
        FastScanner in = new FastScanner(A1.class.getResourceAsStream("B-large-practice.in"));
        PrintWriter out = new PrintWriter(new File("/home/vadim/dev/tmp/B-large.out"));
        int C = in.ni();

        for (int c = 0; c < C; c++) {
            int n = in.ni();
            Deque<Integer> queue = new LinkedList<>();
            boolean[] res = new boolean[n];
            int m = in.ni();
            Customer[] customers = new Customer[m];
            for (int i = 0; i < m; i++) {
                customers[i] = new Customer();
                int t = in.ni();
                for (int j = 0; j < t; j++) {
                    int x = in.ni()-1, y = in.ni();
                    customers[i].orders.put(x, y);
                    customers[i].orig.put(x, y);
                    if(y == 1 && t == 1){
                        res[x] = true;
                        queue.offer(x);
                    }
                }
            }
            boolean impossible = false;
            while(!queue.isEmpty()){
                int malted = queue.pop();
                for (int i = 0; i < m; i++) {
                    TreeMap<Integer, Integer> orders = customers[i].orders;
                    if(orders.isEmpty())
                        continue;
                    orders.remove(malted);
                    if (orders.size() == 1 && orders.firstEntry().getValue() == 1) {
                        Integer key = orders.firstEntry().getKey();
                        if (!res[key]) {
                            res[key] = true;
                            queue.offer(key);
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                boolean can = false;
                TreeMap<Integer, Integer> orders = customers[i].orig;
                for (int order : orders.keySet()) {
                    if(orders.get(order) == 1) {
                        if (res[order]) {
                            can = true;
                            break;
                        }
                    }else{
                        if(!res[order]){
                            can = true;
                            break;
                        }
                    }
                }
                if(!can){
                    impossible = true;
                    break;
                }
            }
            if(impossible){
                out.printf("Case #%d: IMPOSSIBLE%n", c+1);
            } else {
                out.printf("Case #%d: ", c+1);
                for (int i = 0; i < n; i++) {
                    if(res[i])
                        out.print("1 ");
                    else
                        out.print("0 ");
                }
                out.println();
            }

        }
        out.flush();
        out.close();
    }
}
