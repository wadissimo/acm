package codeforces.r517;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long a = in.ni();long b = in.ni();
        long kk = 1;
        for (; (kk+1)*kk/2 <=a+b; kk++);
        kk--;
        int k = (int)kk;
        int[] res = new int[k+1];
        int mark = 1;
        long num = a;
        if(b<a){
            mark = 2;
            num = b;
        }
        for (int i = k; i > 0 && num > 0 ; i--) {
            if(i <= num){
                res[i] = mark;
                num-=i;
            }
        }

        mark = 2;
        num = b;
        if(b<a){
            mark = 1;
            num = a;
        }

        for (int i = 1; i <= k && num > 0 ; i++) {
            if(res[i] == 0){
                res[i] = mark;
                num-=i;
            }
        }
        int an = 0;
        int bn = 0;
        for (int i = 0; i < k + 1; i++) {
            if(res[i] == 1)
                an++;
            else if(res[i] == 2)
                bn++;
        }
        out.println(an);
        for (int i = 1; i < k + 1; i++) {
            if(res[i] == 1) {
                out.print(i + " ");
            }
        }
        out.println();
        out.println(bn);
        for (int i = 1; i < k + 1; i++) {
            if(res[i] == 2) {
                out.print(i + " ");
            }
        }
        out.println();
    }
}
