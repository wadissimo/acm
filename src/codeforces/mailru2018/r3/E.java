package codeforces.mailru2018.r3;

import chelper.io.FastScanner;
import common.StringUtil;

import java.io.PrintWriter;

public class E {
    private boolean check(String s, StringUtil.Hashing h, int st0, int st1, int len0, int len1) {
        int ti = 0;
        if (len0 == len1) {
            if (h.getHash(st0, len0) == h.getHash(st1, len1))
                return false;
        }
        long h0 = h.getHash(st0, len0);
        long h1 = h.getHash(st1, len1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (h.getHash(ti, len0) != h0) {
                    return false;
                }
                ti += len0;
            } else {
                if (h.getHash(ti, len1) != h1) {
                    return false;
                }
                ti += len1;
            }
        }
        return true;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        String t = in.ns();
        int c0 = 0, c1 = 0;
        int pos0 = -1, pos1 = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c0++;
                if (pos0 == -1)
                    pos0 = i;
            } else {
                if (pos1 == -1)
                    pos1 = i;
            }
        }
        StringUtil.Hashing hashing = new StringUtil.Hashing(t);
        c1 = s.length() - c0;
        int tn = t.length();
        int st0, st1;
        int ans = 0;
        for (int len0 = 1; len0 <= tn / c0; len0++) {
            if ((tn - len0 * c0) % c1 == 0) {
                int len1 = (tn - len0 * c0) / c1;
                if (len1 > 0 && len0 * c0 + len1 * c1 == tn) {
                    st1 = pos1 * len0;
                    st0 = pos0 * len1;
                    if (check(s, hashing, st0, st1, len0, len1))
                        ans++;

                }
            }
        }
        out.println(ans);

    }
}
