package SPOJ;

import chelper.io.InputReader;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.*;

public class CHUNK2 {
    public static ArrayList<Integer> getPrimes() {
        boolean[] primes=new boolean[1400000];
        Arrays.fill(primes, true);
        primes[0]=primes[1]=false;
        for (int i=2;i<primes.length;i++) {
            if(primes[i]) {
                for (int j=2;i*j<primes.length;j++) {
                    primes[i*j]=false;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>(110000);
        for (int i = 0; i < primes.length; i++) {
            if(primes[i]) {
                res.add(i);
            }
        }
        return res;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.ni();
        ArrayList<Integer> primes = getPrimes();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            int m = in.ni();
            LinkedList<Integer> g[] = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                g[i] = new LinkedList<>();
            }
            for (int i = 0; i < m; i++) {
                int a = in.ni();
                int b = in.ni();
                a--;
                b--;
                g[a].add(b);
                g[b].add(a);
            }
            int mark[] = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (mark[i] == 0) {
                    mark[i] = 1;
                    Stack<Integer> st = new Stack<>();
                    st.push(i);
                    int size = 0;
                    while (!st.isEmpty()) {
                        Integer node = st.pop();
                        size++;
                        for (Integer child : g[node]) {
                            if (mark[child] == 0) {
                                mark[child] = 1;
                                st.push(child);
                            }
                        }
                    }
                    max = Math.max(max, size);
                }
            }
            if(max < 2)
                out.println(-1);
            else
                out.println(primes.get(max-1));
        }
    }
}
