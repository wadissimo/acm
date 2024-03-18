package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class r552G {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int MAX = 10_000_001;
        int[] nums = new int[MAX];
        int[][] idx = new int[2][MAX];
        Arrays.fill(idx[0], -1);
        for (int i = 0; i < n; i++) {
            nums[a[i]]++;
            if(idx[0][a[i]] != -1)
                idx[1][a[i]] = i;
            else
                idx[0][a[i]] = i;
        }
        long best = (long)MAX*MAX;
        int bestI = -1, bestJ = -1;
        for (int div = 1; div < MAX; div++) {
            int cur = div;
            int first = -1;
            while(cur < MAX){
                if(nums[cur] != 0 ){
                    if(nums[cur] > 1 && first == -1){
                        if((long)cur/div*cur < best){
                            best = (long)cur/div*cur;
                            bestI = idx[0][cur];
                            bestJ = idx[1][cur];
                        }
                        break;
                    } else if(first == -1){
                        first = cur;
                    } else {
                        if((long)cur/div*first < best){
                            best = (long)cur/div*first;
                            bestI = idx[0][first];
                            bestJ = idx[0][cur];
                        }
                        break;
                    }
                }
                cur+=div;
            }
        }
        out.printf("%d %d%n", Math.min(bestI+1, bestJ+1), Math.max(bestI+1, bestJ+1));
    }
}