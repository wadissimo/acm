package atcoder.dp;



import chelper.io.FastScanner;
import java.io.PrintWriter;

public class U_Grouping {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = in.na(n);
        }
        long[] sum = new long[1<<n];
        for (int mask = 1; mask < 1 << n; mask++) {
            for (int i = 0; i < n; i++) {
                if((mask&(1<<i))!=0){
                    for (int j = 0; j < i; j++) {
                        if((mask&(1<<j))!=0){
                            sum[mask] += a[i][j];
                        }
                    }
                }
            }
        }
        long[]dp = new long[1<<n];
        long ans = 0;
        for (int mask = 1; mask < 1 << n; mask++) {
            for (int submask = mask; submask > 0; submask = (submask-1)&mask) {
                int rest = mask^submask;
                dp[mask] = Math.max(sum[submask]+dp[rest], dp[mask]);
            }
            ans = Math.max(dp[mask], ans);
        }
        out.println(ans);
    }
}
