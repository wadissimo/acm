package codejam.year2021.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            int[]a = in.na(n);
            long cost = 0;
            for (int i = 0; i < n-1; i++) {
                int min = a[i];
                int idx = i;
                for (int j = i+1; j < n; j++) {
                    if(a[j] < min){
                        min = a[j];
                        idx = j;
                    }
                }
                cost += idx-i+1;
                int left = i, right = idx;
                while(left < right){
                    int tmp = a[right];
                    a[right] = a[left];
                    a[left] = tmp;
                    left++;
                    right--;
                }
            }
            out.printf("Case #%d: %d%n", t+1, cost);
        }
    }
}
