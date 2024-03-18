package codeforces.ecr53;

import chelper.io.FastScanner;
import common.Fenwick;

import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        long t = in.nl();
        int a[] = in.na(n);
        Fenwick tree = new Fenwick(n+7);
        for (int i = 0; i < n; i++) {
            tree.add(i+1, a[i]);
        }
        long ans = 0;
        int cnt = n;
        while(t > 0){
            long sum = tree.get(n);
            if(sum == 0)
                break;
            if(sum<=t){
                ans += cnt*(t/sum);
                t%=sum;
            }
            if(t<=0)
                break;
            int left = 0;
            int right = n+1;
            while(left<right){
                int mid = (left+right)/2;
                if(tree.get(mid) <= t){
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
            cnt--;
            tree.add(left, -a[left-1]);
            //System.out.println(left+ " " + right);
        }
        if(t<0)
            throw new RuntimeException();
        out.println(ans);

    }
}
