package codeforces.ecr53;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;

public class TaskEBF {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int k = in.ni();
        int ans = 0;
        long sum = 0;
        for (int i = 1; i < n; i++) {
            String s = Integer.toString(i);
            boolean nums[] = new boolean[10];
            for (int j = 0; j < s.length(); j++) {
                nums[s.charAt(j)-'0'] = true;
            }
            int cnt = 0;
            for (int j = 0; j < 10; j++) {
                if(nums[j]) cnt++;
            }
            if(cnt <= k){
                sum += i;
                //System.out.println(s);
                ans++;
            }
        }
        out.println(sum + " " + ans);
    }
}
