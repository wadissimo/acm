package codeforces.r449;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    String s = "What are you doing at the end of the world? Are you busy? Will you save us?";
    String a = "What are you doing while sending \"";
    String b = "\"? Are you busy? Will you send \"";
    String c = "\"?";
    int sn = s.length(), an = a.length(), bn = b.length(), cn = c.length();
    StringBuilder res;
    boolean go(int n, long k){
        if(n == 0){
            if(k < sn){
                res.append(s.charAt((int)k));
                return true;
            }
            return false;
        }
        if(k < an){
            res.append(a.charAt((int)k));
            return true;
        }
        k-=an;

        if(k < lens[n-1])
            return go(n-1, k);
        k -= lens[n-1];

        if(k < bn){
            res.append(b.charAt((int)k));
            return true;
        }
        k-=bn;

        if(k < lens[n-1])
            return go(n-1, k);
        k -= lens[n-1];

        if(k < cn){
            res.append(c.charAt((int)k));
            return true;
        }
        return false;
    }
    long MAX_K = 1_000_000_000_000_000_007L;
    int MAX_N = 100_000;
    long[] lens;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        lens = new long[MAX_N+1];
        lens[0] = sn;
        for (int i = 1; i <= MAX_N; i++) {
            lens[i] = an + lens[i-1] + bn + lens[i-1] + cn;
            if(lens[i] > MAX_K)
                lens[i] = MAX_K;
        }

        int Q = in.ni();
        res = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            int n = in.ni();
            long k = in.nl() - 1;
            if(!go(n, k))
                res.append(".");
        }
        out.println(res.toString());
    }
}
