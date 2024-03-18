package icpc.finals2019;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

public class G {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int MAX = 1_000_007;
        int n = in.ni(), k = in.ni();
        int[] p = new int[n];
        char[] names = new char[n];
        for (int i = 0; i < n; i++) {
            names[i] = in.ns().charAt(0);
            p[i] = in.ni()-1;
        }
        long mod = BigInteger.probablePrime(30, new Random(1)).longValue();
        int prime = 43;
        long[] invs = IntegerUtils.invs(MAX, mod);
        HashMap<Integer, HashMap<Integer, Integer>> mapBySize = new HashMap<>();
        String [] q = new String[k];
        for (int i = 0; i < k; i++) {
            q[i] = in.ns();

        }

    }
}
