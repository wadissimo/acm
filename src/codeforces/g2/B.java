package codeforces.g2;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeSet;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), H = in.ni();
        int[] a = in.na(n);
        int left = 1, right = n+1;
        while(left < right){
            int mid = (left+right)/2;
            int[] b = Arrays.copyOfRange(a, 0, mid);
            Arrays.sort(b);
            int h = 0;
            for (int i = mid-1; i >= 0 && h <= H; i-=2) {
                if(i > 0){
                    h+= Math.max(b[i], b[i-1]);
                } else
                    h+=b[i];
            }
            if(h <= H){
                left = mid+1;
            } else{
                right = mid;
            }
        }
        out.println(left-1);
    }
}
