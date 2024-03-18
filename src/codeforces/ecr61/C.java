package codeforces.ecr61;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(),q= in.ni();
        int[] l = new int[q];
        int[] r = new int[q];
        LinkedList<Integer>[] map = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new LinkedList<>();
        }
        int[] cnt = new int[n];
        for (int i = 0; i < q; i++) {
            l[i] = in.ni()-1;r[i] = in.ni()-1;
            for (int j = l[i]; j <= r[i]; j++) {
                if(cnt[j] < 3) {
                    map[j].add(i);
                    cnt[j]++;
                }
            }
        }
        int[][] ans = new int[q][q];
        boolean found = false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(cnt[i] > 0){
                sum++;
                if(cnt[i] < 3)
                    found = true;
            }
        }

        if(!found){
            out.println(sum);
            return;
        }
        //System.out.println("sum = " + sum);
        for (int i = 0; i < n; i++) {
            if(cnt[i] > 0 && cnt[i] < 3){
                if(cnt[i] == 1) {
                    int k = map[i].getFirst();
                    ans[k][k]++;
                } else {
                    int a = map[i].getFirst();
                    int b = map[i].getLast();
                    ans[a][b]++;
                    ans[b][a]++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < q; j++) {
                if(i==j) continue;
                int res = ans[i][j] + ans[i][i] + ans[j][j];
                /*System.out.print("i = " + i);
                System.out.print(", j = " + j);
                System.out.println(", res = " + res);*/
                min = Math.min(res, min);

            }
        }
        out.println(sum-min);
    }
}
