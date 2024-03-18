package codeforces.g1;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[] a = in.na(n);
        int[] cnt = new int[m+7];
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
        }
        long [][] cur = new long[5][3];
        long [][] nxt = new long[5][3];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                cur[i][j] = nxt[i][j] = -1;
            }
        }
        //System.out.println("Arrays.toString(cnt) = " + Arrays.toString(cnt));
        nxt[0][0] = cur[0][0] = 0;
        long ans = 0;
        for (int i = 1; i <= m+1; i++) {
            if(cnt[i] > 0){
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 3; k++) {
                        if(cur[j][k] != -1){
                            for (int l = 0; l < 3; l++) {
                                if(j+l <= cnt[i] && k+l<=cnt[i+1] && l <= cnt[i+2]){
                                   nxt[k+l][l] = Math.max(nxt[k+l][l], l + cur[j][k] + (cnt[i]-l-j)/3);
                                }
                            }
                        }
                    }
                }
                long[][]tmp = cur;
                cur = nxt;
                nxt = tmp;
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 3; k++) {
                        nxt[j][k] = -1;
                    }
                }
            } else {
                if(cnt[i-1] > 0) {
                    ans += cur[0][0];
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 3; k++) {
                            cur[j][k] = -1;
                        }
                    }
                    cur[0][0] = 0;
                }
            }
        }
        out.println(ans);
    }
}
