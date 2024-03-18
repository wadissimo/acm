package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class ecr55E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), c = in.ni();
        int[] a = in.na(n);
        int[] cn = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
            if(a[i] == c)
                cn[i]++;
            if(i>0)
                cn[i] += cn[i-1];
        }
        LinkedList<Integer> [] nums = new LinkedList[max+1];
        for (int i = 0; i < n; i++) {
            if(nums[a[i]] == null)
                nums[a[i]] = new LinkedList<>();
            nums[a[i]].add(i);
        }
        int ans = cn[n-1];
        for (int i = 1; i <= max; i++) {
            if(i!= c && nums[i] != null){
                int d = 0;
                int prev = -1;
                for (int ind : nums[i]) {
                    int cCnt = cn[ind];
                    if(prev != -1)
                        cCnt-=cn[prev];
                    d-=cCnt-1;
                    if(d <= 0){
                        d = 1;
                    }
                    ans = Math.max(ans, d+cn[n-1]);
                    prev = ind;
                }

            }
        }
        out.println(ans);
    }
}
