package codeforces.all;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class R471_C {
    long max = 1_000_000_000_000_000_000L;
    BigInteger MAX = BigInteger.valueOf(max);

    long root2(long x) {
        long s = (long) Math.sqrt(x);
        while (s * s < x) s++;
        while (s * s > x) s--;
        return s;
    }
    long root3(long x) {
        long s = (long) Math.pow(x, 1.0/3.0);
        while (s * s * s < x) s++;
        while (s * s * s > x) s--;
        return s;
    }
    long root6(long x) {
        long s = (long) Math.pow(x, 1.0/6.0);
        while (s * s * s * s * s * s < x) s++;
        while (s * s * s * s * s * s > x) s--;
        return s;
    }
    long countPow(long r, int pow){
        long approx = (long)Math.pow(r, 1.0/pow);
        BigInteger A = BigInteger.valueOf(approx);
        BigInteger R = BigInteger.valueOf(r);
        if(A.pow(pow).compareTo(R) == 0) return A.longValue()-1;
        else if(A.pow(pow).compareTo(R) < 0){
            for (int i = 0; i < 10000; i++) {//todo: binary search?
                A = A.add(BigInteger.ONE);
                if(A.pow(pow).compareTo(R) > 0){
                    return A.longValue()-2;
                }
            }
        } else {
            for (int i = 0; i < 10000; i++) {//todo: binary search?
                A = A.subtract(BigInteger.ONE);
                if(A.pow(pow).compareTo(R) < 0){
                    return A.longValue()-1; // minus 1
                }
            }
        }
        System.out.println("r = " + r);
        System.out.println("approx = " + approx);
        System.out.println("pow = " + pow);
        throw new RuntimeException("not found");
    }
    int[] pows = new int[]{5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59};
    long toPow(long a, int pow){
        long res = a;
        for (int i = 1; i < pow; i++) {
            if(res > max/a)
                return -1;
            res *= a;
        }
        return res;
    }
    long count(long r){
        if(r == 0)
            return 0;
        long res = root2(r) + root3(r) - root6(r);//add 1
        Map.Entry<Long, Integer> e = all.floorEntry(r);
        if(e != null){
            res += e.getValue();
        }
        return res;
    }
    TreeMap<Long, Integer> all = new TreeMap();
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int q = in.ni();
        for(int pow: pows){
            int num = 2;
            long numpow = 0;
            while(numpow != -1 && numpow <= max){
                numpow = toPow(num, pow);
                boolean skip = false;
                long root2 = (long)Math.sqrt(num);
                if(root2*root2 == num)
                    skip = true;
                long root3 = root3(num);
                if(root3*root3*root3 == num)
                    skip = true;
                if(numpow != -1 && !skip)
                    all.put(numpow, 0);
                num++;
            }
        }
        int id = 1;
        for (Long val : all.keySet()) {
            all.put(val, id++);
        }
        for (int i = 0; i < q; i++) {
            long l = in.nl(), r = in.nl();
            out.println(count(r) - count(l-1));
        }
    }
}

