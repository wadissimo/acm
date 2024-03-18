package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import static java.lang.Math.*;

public class SHINCARD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        long a[] = in.nal(n);
        Arrays.sort(a);
        if(n<3){
            out.println(a[n-1]);
        } else{
            long s[] = new long[n+2];
            long t[] = new long[n+2];
            s[n-1]=t[n-1]=a[n-1]+a[0];
            for (int i = n-2; i > 1 ; i--) {
                s[i] = 2*a[0] + a[i] + min(s[i+1], t[i+1]);
                t[i] = a[i+1] +2*a[1] + a[0] + min(s[i+2], t[i+2]);
            }
            out.println(min(s[2], t[2])+a[1]);
        }
    }
}
