package codeforces.all;

import chelper.io.FastScanner;

import java.io.PrintWriter;
import java.util.Arrays;

public class r240C {
    long[] invs;
    long[] invsRev;
    public long numInversionsInt(int[] src, int[] dest, int low, int high, int N) {
        int length = high - low;

        if(length == 1){
            return 0;
        }
        if (length == 2) {
            if(dest[low] > dest[high-1]){
                int t = dest[low];
                dest[low] = dest[high-1];
                dest[high-1] = t;
                invs[N]++;
                return 1;
            }
            if(dest[low] < dest[high-1])
                invsRev[N]++;
            return 0;
        }

        int mid = (low + high) / 2;
        long c1 = numInversionsInt(dest, src, low, mid, N-1);
        long c2 = numInversionsInt(dest, src, mid, high, N-1);
        long c3 = 0;
        long rev = 0;
        for(int i = low, p = low, q = mid; i < high; i++) {
            if (q >= high || p < mid && src[p] <= src[q]) {
                dest[i] = src[p++];
            } else {
                dest[i] = src[q++];
                c3 += mid-p;
            }
        }
        for(int i = low, p = low, q = mid; i < high; i++) {
            if (q >= high || p < mid && src[p] < src[q]) {
                rev += high-q;
                p++;
            } else {
                q++;
            }
        }
        invs[N] += c3;
        invsRev[N] += rev;
        return c1+c2+c3;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        int n = 1<<N;
        int[] a = in.na(n);
        invs = new long[N+1];
        invsRev = new long[N+1];
        int[] src = a.clone(), dest = a.clone();
        numInversionsInt(src, dest, 0, n, N);
        int m = in.ni();
        int state = 0;
//        System.out.println("invs = " + Arrays.toString(invs));
//        System.out.println("invsRev = " + Arrays.toString(invsRev));
        for (int i = 0; i < m; i++) {
            int q = in.ni();
            state ^= (1<<q);
            long res = 0;
            boolean rev = false;
            for (int j = N; j > 0 ; j--) {
                rev ^= (state&(1<<j)) != 0;
                if(!rev){
                    res += invs[j];
                } else {
                    res += invsRev[j];
                }
            }
            out.println(res);
        }
    }
}
