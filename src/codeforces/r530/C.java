package codeforces.r530;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int sn = s.length();
        char[] a = s.toCharArray();
        int n = in.ni();
        int cnt = 0;
        for (int i = 0; i < sn; i++) {
            if(a[i] != '?' && a[i] != '*')
                cnt++;
        }
        if(cnt == n){
            for (int i = 0; i < sn; i++) {
                if(a[i] != '?' && a[i] != '*')
                    out.print(a[i]);
            }
            out.println();
        } else if(cnt < n){
            int pos = -1;
            for (int i = 0; i < sn; i++) {
                if(a[i] == '*'){
                    pos = i;
                    break;
                }
            }
            if(pos == -1){
                out.println("Impossible");
            } else {
                for (int i = 0; i < sn; i++) {
                    if(i == pos){
                        for (int j = 0; j < n - cnt; j++) {
                            out.print(a[pos-1]);
                        }
                    } else if(a[i] != '?' && a[i] != '*'){
                        out.print(a[i]);
                    }
                }
                out.println();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sn; i++) {
                if(i < sn-1 && (a[i+1] == '?' || a[i+1] == '*') && cnt > n){
                    cnt--;
                } else if(a[i] != '?' && a[i] != '*'){
                    sb.append(a[i]);
                }
            }
            if(cnt > n){
                out.println("Impossible");
            } else {
                out.println(sb.toString());
            }
        }
    }
}
