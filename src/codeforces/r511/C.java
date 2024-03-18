package codeforces.r511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

/**
 * Created on 21.09.2018.
 */
public class C {
    static int[] lp;
    static ArrayList<Integer> pr;
    static void sieve(int n) {
        lp = new int[n+1];
        pr = new ArrayList<>();
        for (int i=2;i<n+1;i++) {
            if(lp[i] == 0) {
                lp[i] = i;
                pr.add(i);
            }
            int j=0;
            while(j < pr.size() && pr.get(j) <= lp[i] && i*pr.get(j) <= n) {
                lp[i * pr.get(j)] = pr.get(j);
                j ++;
            }
        }
    }
    static int gcd(int a, int b) {
        while (b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int a[] = new int[n];
        int max_a = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            max_a = max(a[i], max_a);
        }
        int gcd = gcd(a[0], a[1]);
        for (int i = 1; i < n; i++) {
            gcd = gcd(gcd, a[i]);
        }

        max_a/=gcd;
        for (int i = 0; i < n; i++) {
                a[i] = a[i] / gcd;
        }

        sieve(max_a);
        int counts[] = new int[max_a+7];
        for (int i = 0; i < n; i++) {
            int x = a[i];
            while(x>1) {
                int p = lp[x];
                while(x%p==0)
                    x/=p;
                counts[p]++;
            }
        }
        int max_cnt=0;
        for (int i = 0; i < counts.length; i++) {
            max_cnt = max(max_cnt, counts[i]);
        }
        if(max_cnt>0){
            System.out.println(n-max_cnt);
        } else{
            System.out.println(-1);
        }
    }
}
