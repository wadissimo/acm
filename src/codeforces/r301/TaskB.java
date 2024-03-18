package codeforces.r301;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int k = in.ni();
        int p = in.ni();
        int x = in.ni();
        int y = in.ni();
        int a[] = new int[k];
        int l = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            a[i] = in.ni();
            sum+=a[i];
            if (a[i] < y) l ++;
        }
        if(sum > x || n-k > x-sum) {
            out.println("-1");
            return;
        }
        int mid = n/2 + 1;
        int n1 = mid - l -1;
        if(n1 < 0) {
            out.println("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - k; i++) {
            if(i < n1) {
                sum += 1;
                sb.append("1 ");
            } else {
                sum += y;
                sb.append(y+ " ");
            }
        }
        if(sum > x) {
            out.println("-1");
            return;
        }
        out.println(sb);

    }
}
