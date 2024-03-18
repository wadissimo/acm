package atcoder.agc32;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class B {
    class Edge{
        int a,b;

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();

        List<Edge> ans = new LinkedList<>();
        int mid = n+1;
        if(n%2 == 1)
            mid = n;
        for (int i = 1; i <= n; i++) {
            if(n%2 == 1 && i == n){
                break;
            }
            for (int j = i+1; j <=n; j++) {
                if(j == mid-i)
                    continue;
                ans.add(new Edge(i, j));
            }
        }
        out.println(ans.size());
        for (Edge edge : ans) {
            out.println(edge.a + " " + edge.b);
        }
    }
}
