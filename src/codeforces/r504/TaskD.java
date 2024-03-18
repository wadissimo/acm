package codeforces.r504;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();int q = in.ni();
        int []a = in.na(n);
        int []r = new int[q+1];
        int maxa = 0;
        int cnt0 = 0;
        for (int i = 0; i < n; i++) {
            maxa = Math.max(maxa, a[i]);
            r[a[i]] = i;
            if(a[i] == 0)
                cnt0++;
        }
        int[] st = new int[q+1];
        int sti = 0;
        boolean correct = true;
        for (int i = 0; i < n; i++) {
            if(a[i] == 0)
                continue;
            if(sti > 0){
                int top = st[sti-1];
                if(r[top] == i)
                    sti--;
                else{
                    if(a[i] < top){
                        correct = false;
                        break;
                    } else if(a[i] > top){
                        if(r[a[i]] > i)
                            st[sti++] = a[i];
                    }
                }
            } else {
                if(r[a[i]] > i)
                    st[sti++] = a[i];
            }
        }
        if(cnt0 == 0 && maxa < q)
            correct = false;
        if(correct){
            out.println("YES");
            if(maxa < q)
                a[r[0]] = q;
            int first = -1;
            for (int i = 0; i < n; i++) {
                if(a[i] != 0){
                    first = a[i];
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if(a[i] == 0){
                    if(i == 0)
                        a[i] = first;
                    else
                        a[i] = a[i-1];
                }
                out.print(a[i] + " ");
            }
            out.println();
        } else {
            out.println("NO");
        }
    }
}
