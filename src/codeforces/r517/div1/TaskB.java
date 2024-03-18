package codeforces.r517.div1;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();int m = in.ni();
        char[][] map = in.nm(n,n);
        int da[][] = new int[n+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            da[0][i] = da[i][0] = Integer.MIN_VALUE;
        }
        da[0][1] = da[1][0] = m;
        int max_layer = -1;
        boolean[][]mark = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                da[i+1][j+1] = Math.max(da[i][j+1], da[i+1][j]);
                if(map[i][j] != 'a')
                    da[i+1][j+1] --;
                if(da[i+1][j+1] == -1){
                    da[i+1][j+1] = -10000;
                    max_layer = Math.max(max_layer, i+j);
                    mark[i][j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(da[n][n] >= 0){
            for (int i = 0; i < 2*n - 1; i++) {
                sb.append('a');
            }
            out.println(sb.toString());
            return;
        }
        for (int i = 0; i < max_layer; i++) {
            sb.append('a');
        }
        for (int layer = max_layer; layer < 2 * n - 1; layer++) {
            int si = 0;
            int sj = layer;
            if(sj > n - 1){
                sj = n-1;
                si = layer-n+1;
            }
            int i = si;
            int j = sj;
            char min_char = 'z';
            while(i<n && j >= 0){
                if(mark[i][j] && map[i][j] < min_char){
                    min_char = map[i][j];
                }
                i++;j--;
            }
            sb.append(min_char);
            i = si;j = sj;
            while(i<n && j >= 0){
                if(mark[i][j] && map[i][j] == min_char){
                    if(i<n-1)
                        mark[i+1][j] = true;
                    if(j<n-1)
                        mark[i][j+1] = true;
                }
                i++;j--;
            }
        }
        out.println(sb.toString());
    }
}
