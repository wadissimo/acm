package codeforces.r550;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int MAX = 200_000;
        int[] cnt = new int[MAX +1];
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
        }
        int max = 0;
        int maxNum = 0;
        for (int i = 0; i <= MAX; i++) {
            if(cnt[i] > max){
                max = cnt[i];
                maxNum = i;
            }
        }
        int firstMax = -1;
        for (int i = 0; i < n; i++) {
            if(a[i] == maxNum){
                firstMax = i;
                break;
            }
        }
        out.println(n-max);
        for (int i = firstMax-1; i >= 0 ; i--) {
            if(a[i] < a[i+1]){
                a[i] = a[i+1];
                out.printf("1 %d %d%n", i+1, i+2);
            } else {
                a[i] = a[i+1];
                out.printf("2 %d %d%n", i+1, i+2);
            }
        }
//        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//        System.out.println("max = " + max);
        for (int i = 0; i < n; i++) {
            if(a[i] == maxNum)
                continue;
            if(a[i] > a[i-1]){
                a[i] = a[i-1];
                out.printf("2 %d %d%n", i+1, i);
            } else if(a[i] < a[i-1]){
                a[i] = a[i-1];
                out.printf("1 %d %d%n", i+1, i);
            }
        }
    }
}
