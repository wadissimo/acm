package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

public class BGIRL {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.ni();
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
                a--;b--;
                g[a].add(b);
                g[b].add(a);
            }
            int mark[] = new int[n];
            TreeSet<Integer> sizes = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                if(mark[i] == 0){
                    mark[i] = 1;
                    Stack<Integer> st = new Stack<>();
                    st.push(i);
                    int size = 0;
                    while(!st.isEmpty()){
                        Integer node = st.pop();
                        size++;
                        for (Integer child : g[node]) {
                            if(mark[child] == 0){
                                mark[child] = 1;
                                st.push(child);
                            }
                        }
                    }
                    sizes.add(size);
                }
            }
            Iterator<Integer> it = sizes.descendingIterator();
            int ans = -1;
            while (it.hasNext()) {
                Integer size = it.next();
                if(size > 1) {
                    boolean prime = true;
                    for (int i = 2; i <= Math.sqrt(size); i++) {
                        if(size%i==0){
                            prime = false;
                            break;
                        }
                    }
                    if(prime){
                        ans = size;
                        break;
                    }
                }
            }
            out.println(ans);
        }
    }
}
