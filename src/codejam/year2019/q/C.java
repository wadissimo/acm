package codejam.year2019.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class C {


    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();

        for (int t = 0; t < T; t++) {
            String s = in.ns();int l = in.ni();
            BigInteger [] a = new BigInteger[l];
            for (int i = 0; i < l; i++) {
                String str = in.ns();
                a[i] = new BigInteger(str);
            }
            int first = 0;
            for (;first < l; first++) {
                if(!a[first].equals(a[first+1]))
                    break;
            }

            BigInteger second = a[first].gcd(a[first+1]);
            BigInteger[] orig = new BigInteger[l+1];
            TreeMap<BigInteger, Character> abc = new TreeMap<>();

            orig[first+1] = second;
            BigInteger cur = second;

            for (int i = first; i >= 0; i--) {
                orig[i] = a[i].divide(cur);
                cur = orig[i];
            }
            abc.put(second, '.');
            abc.put(orig[first], '.');
            cur = second;
            for (int i = first+1; i < l; i++) {
                cur = a[i].divide(cur);
                orig[i+1] = cur;
                abc.put(cur, '.');
            }
            int idx = 0;
            for (Map.Entry<BigInteger, Character> entry : abc.entrySet()) {
                entry.setValue((char)('A' + idx));
                idx++;
            }
            StringBuilder ans = new StringBuilder();
            for (BigInteger p : orig) {
                ans.append(abc.get(p));
            }
            out.printf("Case #%d: %s%n", t+1, ans.toString());
        }


    }
}
