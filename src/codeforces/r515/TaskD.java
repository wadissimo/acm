package codeforces.r515;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int m = in.ni();
        int k = in.ni();
        int []a = in.na(n);
        int left = 0;
        int right = n-1;
        while(left < right) {
            int mid = (right+left)/2;
            int basket = 0;
            int free_baskets = m;
            for (int i = mid; i < n; i++) {
                if (a[i] + basket <= k) {
                    basket += a[i];
                } else {
                    free_baskets--;
                    if (free_baskets == 0)
                        break;
                    basket = a[i];
                }
            }
            if (free_baskets > 0) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        out.println(n-right);

    }
}
