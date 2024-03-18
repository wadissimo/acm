package main;

import chelper.io.FastScanner;
import common.Fenwick;

import java.io.PrintWriter;

public class BApplejackAndStorages {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int a[] = in.na(n);
        int q = in.ni();
        int MAX = 100_007;
        int[] len = new int[MAX];
        for (int i = 0; i < n; i++) {
            len[a[i]]++;
        }
        int[] freq = new int[9];
        for (int i = 0; i < MAX; i++) {
            if(len[i] == 0)
                continue;
            for (int j = 8; j >= 0; j--) {
                if(len[i] >= j) {
                    freq[j]++;
                    break;
                }
            }
        }
        for (int i = 0; i < q; i++) {
            String op = in.ns();
            int x = in.ni();
            //update freq
            if(len[x] > 0) {
                int cnt = len[x];
                if(cnt > 8)
                    cnt = 8;
                freq[cnt]--;
            }
            if(op.charAt(0) == '+'){
                len[x]++;
            } else {
                len[x]--;
            }
            if(len[x] > 0) {
                int cnt = len[x];
                if(cnt > 8)
                    cnt = 8;
                freq[cnt]++;
            }
            // calc
            int[] total = new int[10];
            for (int j = 8; j >=0 ; j--) {
                total[j] = total[j+1]+freq[j];
            }
            if(total[8] > 0 || total[4] >= 2 || total[6] == 1 && total[2] > 1 || total[4] == 1 && total[2] >= 3){
                out.println("YES");
            } else
                out.println("NO");
        }
    }
}
