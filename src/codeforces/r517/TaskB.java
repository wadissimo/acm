package codeforces.r517;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n-1);
        int[] b = in.na(n-1);
        int t[] = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int c = a[i]&b[i];
            int d = a[i]|b[i];
            if(b[i] != c || a[i] != d){
                out.println("NO");
                return;
            }
        }

        boolean possible = true;
        for (int st = 0; st <=3; st++) {
            Arrays.fill(t, -1);
            t[0] = st;
            possible = true;
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j <=3 ; j++) {
                    if((t[i]&j) == b[i] && (t[i]|j) == a[i]){
                        t[i+1] = j;
                        break;
                    }
                }
                if(t[i+1] == -1) {
                    possible = false;
                    break;
                }
            }
            if(possible)
                break;
        }

        if(!possible){
            out.println("NO");
        } else {
            out.println("YES");
            for (int i = 0; i < n-1; i++) {
                if((a[i] != (t[i]|t[i+1])) || (b[i] != (t[i]&t[i+1]))){
                    throw new RuntimeException();
                }
            }
            for (int i = 0; i < n; i++) {
                out.print(t[i] + " ");
            }
            out.println();
        }

    }
}
