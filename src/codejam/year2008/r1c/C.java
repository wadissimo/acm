package codejam.year2008.r1c;

import chelper.io.FastScanner;
import common.Fenwick;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class C {

    static long[] tree;
    static long mod = (int)1e9 + 7;
    private static long get(int r) {
        long ans = 0;
        while (r >= 0) {
            ans = (ans + tree[r])%mod;
            r = (r & (r + 1)) - 1;
        }
        return ans;
    }

    private static void add(int pos, long val) {
        while (pos < tree.length) {
            tree[pos] = (tree[pos] + val)%mod;
            pos |= pos + 1;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//                                FastScanner in = new FastScanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner(C.class.getResourceAsStream("C-large-practice.in"));
        PrintWriter out = new PrintWriter(new File("/home/vadim/dev/tmp/C.out"));

        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni(), m = in.ni();
            long x = in.ni(), y = in.ni(), z = in.ni();
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = in.ni();
            }
            int[] s = new int[n];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                s[i] = a[i%m];
                map.put(s[i], -1);
                a[i%m] = (int)((x*a[i%m] + y*(i+1))%z);
            }
            int idx = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                entry.setValue(idx++);
            }
            tree = new long[idx];
            for (int i = 0; i < n; i++) {
                int num = map.get(s[i]);
                if(num != 0){
                    add(num, get(num-1));
                }
                add(num, 1);
            }
            out.printf("Case #%d: %d%n", t+1, get(idx-1));

//            System.out.println("Arrays.toString(s) = " + Arrays.toString(s));

        }
        out.flush(); out.close();

    }
}
