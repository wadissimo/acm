package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni(), m = in.ni();
        LinkedList<Integer>[] rems = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            rems[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            int a = in.ni();
            rems[a%m].add(a);
        }
        for (int i = 0; i < m; i++) {
            if(rems[i].size() >= k){
                out.println("Yes");
                for (Integer num : rems[i]) {
                    out.print(num + " ");
                    k--;
                    if(k == 0)
                        break;
                }
                return;
            }
        }
        out.println("No");
    }
}
