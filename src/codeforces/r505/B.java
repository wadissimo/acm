package codeforces.r505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 *
 */
public class B {

    private static void trial(int n, Set<Integer> set) {
        while (n % 2 == 0) {
            set.add(2);
            n /= 2;
        }
        int f = 3;
        while (f * f <= n) {
            if (n % f == 0) {
                set.add(f);
                n /= f;
            } else {
                f += 2;
            }
        }
        if (n != 1) set.add(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] div = null;
        int[] divc = null;
        int max_c = -1;
        int max_n = -1;
        int ans = -1;
        boolean broken = false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (i == 0){
                trial(a, set);
                trial(b, set);
                div = new int[set.size()];
                divc = new int[set.size()];
                int ind = 0;
                for (Integer c : set) {
                    div[ind] = c;
                    ind++;
                }
                ans = a;
            } else {
                boolean found = false;
                for (int j = 0; j < div.length; j++) {
                    int c = div[j];
                    if (a % c == 0 || b % c == 0) {
                        found = true;
                        divc[j]++;
                    }
                }
                if(!found) {
                    broken = true;
                    break;
                }
            }
        }
        if(broken){
            ans = -1;
        } else if(n>1){
            for (int i = 0; i < divc.length; i++) {
                int d = divc[i];
                if (d == n-1) {
                    ans = div[i];
                    break;
                }
            }
        }
        System.out.println(ans);

    }
}


