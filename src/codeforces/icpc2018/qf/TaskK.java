package codeforces.icpc2018.qf;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskK {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();int k = in.ni();
        int [] a = in.na(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+= a[i];
        }
        if(sum%k!=0){
            out.println("No");
        }else{
            int t = sum/k;
            sum = 0;
            int cnt = 0;
            int[] ans = new int[k];
            int ai = 0;
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                sum+=a[i];
                cnt++;
                if(sum==t){
                    sum = 0;
                    ans[ai++] = cnt;
                    cnt = 0;
                } else if(sum > t){
                    possible = false;
                    break;
                }
            }
            if(possible){
                out.println("Yes");
                for (int i = 0; i < k; i++) {
                    out.print(ans[i]+" ");
                }
                out.println();
            }else{
                out.println("No");
            }
        }
    }
}
