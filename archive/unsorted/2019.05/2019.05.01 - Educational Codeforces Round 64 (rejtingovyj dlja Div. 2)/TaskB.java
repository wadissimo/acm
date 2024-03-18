package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        int SIGMA = 26;
        for (int t = 0; t < T; t++) {
            int[] cnt = new int[SIGMA];
            String  s = in.ns();
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i)-'a']++;
            }
            StringBuffer odd = new StringBuffer();
            StringBuffer even = new StringBuffer();
            for (int i = 0; i < SIGMA; i++) {
                if(i%2 == 0){
                    while(cnt[i] > 0){
                        even.append((char)('a'+i));
                        cnt[i]--;
                    }
                } else {
                    while(cnt[i] > 0){
                        odd.append((char)('a'+i));
                        cnt[i]--;
                    }
                }
            }
            if(odd.length() > 0 && even.length() > 0){
                if(Math.abs(odd.charAt(0) - even.charAt(even.length()-1)) > 1){
                    out.println(even.toString() + odd.toString());
                } else if (Math.abs(even.charAt(0) - odd.charAt(odd.length()-1)) > 1) {
                    out.println(odd.toString() + even.toString());
                } else {
                    out.println("No answer");
                }
            } else {
                out.println(s);
            }
        }
    }
}
