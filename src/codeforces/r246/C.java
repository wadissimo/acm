package codeforces.r246;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Vadim_2 on 15.05.2014.
 */
public class C {

    static TreeSet<Integer> fillPrimes(int n) {
        boolean[] primes=new boolean[n];
        Arrays.fill(primes, true);
        primes[0]=primes[1]=false;
        for (int i=2;i<primes.length;i++) {
            if(primes[i]) {
                for (int j=2;i*j<primes.length;j++) {
                    primes[i*j]=false;
                }
            }
        }
        TreeSet<Integer> res = new TreeSet<Integer>();
        for (int i = 0; i < primes.length; i++) {
            if(primes[i]) {
                res.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] pos = new int[n+1];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            pos[a[i]] = i + 1;
        }

        long t1 = System.currentTimeMillis();
        int k = 0;
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> primes = fillPrimes(n + 3);
        HashSet<Integer> integerHashSet = new HashSet<Integer>();

        for (int i = 1; i < n+1; i++) {
            int shift = pos[i]-i+1;
            while(shift > 1) {
                int p = primes.floor(shift);
                int newPos = pos[i]-p +1;
                k++;
                sb.append(newPos).append(" ").append(pos[i]).append("\n");
                int t = a[pos[i]-1];
                a[pos[i]-1] = a[newPos-1];
                a[newPos-1] = t;

                pos[a[pos[i]-1]] = pos[i];
                pos[i] = newPos;


                shift = shift - p + 1;
            }
        }
        long t2 = System.currentTimeMillis();

        System.out.println(k);
        System.out.println(sb);
        System.out.println(t2-t1);
    }
}
