package codeforces.icpc2018.qf;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();int k = in.ni();
        int []a= in.na(n);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans+=a[i]/k;
            int rem = a[i]%k;
            if(i==n-1 && rem > 0){
                ans++;
            }
            if(rem > 0 && i < n-1){
                ans++;
                a[i+1] -= k-rem;
                if(a[i+1] < 0){
                    a[i+1] = 0;
                }
            }
        }
        out.println(ans);
    }
}
