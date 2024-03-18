package codeforces.r522;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int[] type = new int[n];
        boolean[][] possible = new boolean[n][5];
        for (int i = 0; i < n; i++) {
            if(i < n-1 && (i == 0 || a[i] == a[i-1]) && a[i] != a[i+1])
                type[i] = 1;
            else if(i>0 && (i == n-1 || a[i] == a[i+1]) && a[i-1] != a[i])
                type[i] = 2;
            else if(i == 0 || i== n-1 || a[i] == a[i+1] && a[i] == a[i-1])
                type[i] = 3;
        }
        int shift = 0;
        int max = 0;
        int min = 0;
        int last1 = -1;
        for (int i = 0; i < n; i++) {
            if(type[i] == 3){
                for (int j = 0; j < 5; j++) {
                    possible[i][j] = true;
                }
            }
            if(type[i] == 1)
                last1 = i;
            if(type[i] == 2){
                if(a[i] > a[i-1])
                    shift++;
                else
                    shift--;
                max = Math.max(max, shift);
                min = Math.min(min, shift);
                boolean canleft = false;
                boolean canright = false;
                for (int j = 0; j < 5; j++) {
                    if(j+max <= 4 && j+min >= 0){
                        possible[last1][j] = true;
                        canleft = true;
                    }
                    if(j+max-shift <= 4 && j+min-shift >= 0){
                        possible[i][j] = true;
                        canright = true;
                    }
                }
                if(!canleft || !canright){
                    out.println(-1);
                    return;
                }
                max = 0;
                min = 0;
                shift = 0;
            } else if(type[i] == 0){
                if(a[i] > a[i-1])
                    shift++;
                else
                    shift--;
            }
            max = Math.max(max, shift);
            min = Math.min(min, shift);
        }
        for (int j = 0; j < n; j++) {
            if(type[j] > 0){
                int cnt = 0;
                int ind = -1;
                for (int k = 0; k < 5; k++) {
                    if(possible[j][k]){
                        cnt++;
                        ind = k;
                    }
                }
                if(cnt == 1){
                    if(j>0 && type[j-1] > 0)
                        possible[j-1][ind] = false;
                    if(j<n-1 && type[j+1] > 0)
                        possible[j+1][ind] = false;
                }
            }
        }
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            if(type[j] > 0){
                int cnt = 0;
                int ind = -1;
                for (int k = 0; k < 5; k++) {
                    if(possible[j][k]){
                        cnt++;
                        ind = k;
                    }
                }
                if(cnt == 0){
                    out.println(-1);
                    return;
                }
                ans[j] = ind+1;
                if(j>0 && type[j-1] > 0)
                        possible[j-1][ind] = false;
                if(j<n-1 && type[j+1] > 0)
                    possible[j+1][ind] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            if(type[i] == 0){
                if(a[i] > a[i-1]){
                    ans[i] = ans[i-1]+1;
                } else if (a[i] < a[i-1]){
                    ans[i] = ans[i-1]-1;
                }
            }
        }

        for (int i = n-2; i >= 0 ; i--) {
            if(ans[i] == ans[i+1]){
                if(a[i] < a[i+1])
                    ans[i]--;
                else if(a[i] > a[i+1])
                    ans[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
    }
}
