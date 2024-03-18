package yandex.qual;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class F {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int m = in.ni();
        int l[]= new int[m];
        int r[] = new int[m];
        for (int i = 0; i < m; i++) {
            l[i] = in.ni();
            r[i] = in.ni();
        }
        int a[] = new int[m];
        int n = in.ni();
        for (int i = 0; i < n; i++) {
            int road = in.ni();
            a[road-1] ++;
        }
        for (int i = 0; i < m; i++) {
            if(a[i] < l[i]) {
                out.println("Green");
            } else if(a[i] > r[i]) {
                out.println("Red");
            } else {
                out.println("Orange");
            }
        }
    }
}
