package codeforces.r555;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class F {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int MAX = 200_007;
        int[] cnt = new int[MAX];
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
        }
        int best = 0;
        int sum = 0;
        int from = 0;
        int bestFrom = 0;
        int bestTo = 0;

        for (int i = 1; i < MAX; i++) {
            if(cnt[i] == 1 && cnt[i-1] <= 1){
                sum = cnt[i]+cnt[i-1];
                if(sum > best){
                    best = sum;
                    if(cnt[i-1] > 0)
                        bestFrom = i-1;
                    else
                        bestFrom = i;
                    bestTo = i;
                }
            }
            if(cnt[i] >= 2 && cnt[i-1] < 2){
                sum = cnt[i];
                if(cnt[i-1] == 1) {
                    from = i-1;
                    sum +=cnt[i-1];
                } else{
                    from = i;
                }
            } else if(cnt[i] >= 2){
                sum+=cnt[i];
            }else if(cnt[i] < 2 && cnt[i-1] >= 2){
                sum+=cnt[i];
                if(sum > best){
                    best = sum;
                    bestFrom = from;
                    if(cnt[i] == 1)
                        bestTo = i;
                    else
                        bestTo = i-1;
                }
            }
        }
        out.println(best);
        for (int i = bestFrom; i <= bestTo; i++) {
            if(cnt[i] > 0){
                out.print(i + " ");
                cnt[i]--;
            }
        }
        for (int i = bestTo; i >= bestFrom; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                out.print(i + " ");
            }
        }
    }
}
