package codeforces.r494;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int q = in.ni();
        int[] a = in.na(n);
        int[] v = new int[31];
        for (int i = 0; i < n; i++) {
            v[Integer.numberOfTrailingZeros(a[i])]++;
        }
        int pow[] = new int[31];
        for (int i = 0; i < 31; i++) {
            pow[i] = 1<<i;
        }
        for (int i = 0; i < q; i++) {
            int b = in.ni();
            int cnt = 0;
            int sum = 0;
            for (int j = 30; j >= 0 && b > 0 ; j--) {
                if(v[j] > 0 && pow[j] <= b){
                    cnt = b/pow[j];
                    if(cnt > v[j])
                        cnt = v[j];
                    b-=cnt*pow[j];
                    sum += cnt;
                }
            }
            if(b==0){
                out.println(sum);
            } else {
                out.println(-1);
            }
        }
    }
}
