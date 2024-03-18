package codejam.year2008.r1b;

import chelper.io.FastScanner;
import common.DSU;
import common.IntegerUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class B {
    public static void main(String[] args) throws FileNotFoundException {
//                FastScanner in = new FastScanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner(B.class.getResourceAsStream("B-large-practice.in"));
        PrintWriter out = new PrintWriter(new File("/home/vadim/dev/tmp/B.out"));
        int C = in.ni();
        int MAX = 1_000_000;
        ArrayList<Integer> allPrimes = new ArrayList<>(MAX);
        int[] lp = new int[MAX+1];
        IntegerUtils.sieve(MAX, allPrimes, lp);
        int lastPrime = allPrimes.get(allPrimes.size()-1);
        for (int c = 0; c < C; c++) {
            System.out.print("c = " + c);
            long a = in.nl(), b = in.nl(), P = in.nl();
            int len = (int)(b-a+1);
            if(P > lastPrime){
                out.printf("Case #%d: %d%n", c+1, len);
                continue;
            }
            long[] rem = new long[len+1];
            for (int i = 0; i <= len; i++) {
                rem[i] = a+i;
            }
            boolean[] greater = new boolean[len + 1];
            boolean[] missed = new boolean[allPrimes.size()];
            int[][] divs = new int[len+1][40];
            int[] cnt = new int[len+1];

            DSU dsu = new DSU(allPrimes.size());
            int firstPrimeIndex = -1;
            long opCnt = 0;
            for (int k = 0; k < allPrimes.size(); k++) {
                int p = allPrimes.get(k);
                if(firstPrimeIndex == -1 && p >= P)
                    firstPrimeIndex = k;
                long first = (a + p - 1)/p;
                if(first*p > b)
                    missed[k] = true;
                for (long i = first; i*p <= b ; i++) {

                    int ind = (int)(p*i-a);
                    if(p >= P) {
                        greater[ind] = true;
                        for (int j = 0; j < cnt[ind]; j++) {
                            opCnt++;
                            dsu.union(divs[ind][j], k);
                        }
                        divs[ind][cnt[ind]++] = k;
                    }
//                    else {
//                        while (rem[ind] > MAX && rem[ind] % p == 0)
//                            rem[ind] /= p;
//                    }
                }
            }
            System.out.println(", opCnt = " + opCnt);

            if(firstPrimeIndex == -1){
                System.out.println("P = " + P);
                System.out.println("allPrimes.get(allPrimes.size()-1) = " + allPrimes.get(allPrimes.size() - 1));
            }
            int ans = 0;
            for (int i = firstPrimeIndex; i < allPrimes.size() ; i++) {
                if(!missed[i] && dsu.find(i) == i){
                    ans++;
                }
            }
            for (int i = 0; i < len; i++) {
                if(!greater[i]) {
//                    if(rem[i] <= MAX)
                        ans++;
                }
            }
            out.printf("Case #%d: %d%n", c+1, ans);
        }
        out.flush();
        out.close();

    }
}
