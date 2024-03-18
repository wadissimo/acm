package codeforces.r514;

import chelper.io.InputReader;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        if(n == 1){
            out.println(1);
        } else if (n==2){
            out.println("1 2");
        } else if (n==3){
            out.println("1 1 3");
        } else {
            int cnt = 0;
            int ans[] = new int[n];
            Arrays.fill(ans, 1);
            int ai = n-1;
            for (int i = 19; i>=1; i--) {
                int pow = 1 << i;
                if (pow > n)
                    continue;

                int d = n/pow-cnt;
                if(cnt == 0 && d == 1 && n-n%(1<<i-1) > n/pow){
                    ans[ai--] = n-n%(1<<i-1);
                }else {
                    for (int j = 0; j < d; j++) {
                        ans[ai--] = pow;
                    }
                }
                cnt += d;
            }

            out.println(ArrayUtils.printArray(ans));
        }
    }
}
