package chelper.r236;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int k = in.ni();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        int d[] = new int[n];
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            if(v[i] == 0 && a[i]>i*k) {
                int h = a[i];
                for (int j = i + 1; j < n; j++) {
                    h += k;
                    if (a[j] == h) {
                        d[i]++;
                        v[j] = 1;
                    }
                }
            }
        }
        int maxH = 0;
        int maxI = 0;
        for (int i = 0; i < n - 1; i++) {
            if(d[i] > maxH) {
                maxH = d[i];
                maxI = i;
            }
        }
        d[maxI] = a[maxI];
        if(maxI > 0) {
            for (int i = maxI - 1; i >= 0; i--) {
                d[i] =  d[i+1]-k;
            }
        }
        for (int i = maxI+1; i < n; i++) {
            d[i] = d[i-1]+k;
        }
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] != d[i]) {
                ans++;
                if(a[i] > d[i]) {
                    sb.append("- ").append(i + 1).append(" ").append(a[i] - d[i]).append("\n");
                } else {
                    sb.append("+ ").append(i + 1).append(" ").append(d[i] - a[i]).append("\n");
                }
            }
        }
        out.println(ans);
        out.println(sb);
    }
}
