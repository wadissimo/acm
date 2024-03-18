package codeforces.r545;

import chelper.io.FastScanner;
import common.StringUtil;

import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        String t = in.ns();
        int tn = t.length();
        if(tn > s.length()){
            out.println(s);
            return;
        }
        int ns = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1')
                ns++;
        }
        int ns0 = s.length()-ns;
        int[] cnt = new int[tn +1];
        int[] cnt0 = new int[tn +1];
        for (int i = 0; i < tn; i++) {
            cnt[i+1] = cnt[i];
            cnt0[i+1] = cnt0[i];
            if(t.charAt(i) == '1')
                cnt[i+1]++;
            else
                cnt0[i+1]++;
        }
        int ans = 0;
        int rem1 = 0;
        int rem0 = 0;
        int pref = 0;
        int[] z = StringUtil.z(t);
        for (int i = 0; i < tn; i++) {
           if(z[i] == tn-i){
               int rep;

               if(cnt[i] == 0 && cnt0[i] == 0){
                   if(cnt[tn] == 0)
                       rep = ns0/cnt0[tn];
                   else if(cnt0[tn] == 0)
                       rep = ns/cnt[tn];
                   else
                       rep = Math.min(ns/cnt[tn], ns0/cnt0[tn]);
                   if(rep > ans  && tn*rep <= s.length()){
                       ans = rep;
                       pref = i;
                       rem1 = ns-cnt[tn]*ans;
                       rem0 = ns0-cnt0[tn]*ans;
                   }
                   continue;
               } else if(cnt[i] == 0){
                   rep = (ns0-cnt0[tn]+cnt0[i])/cnt0[i];
               } else if (cnt0[i] == 0){
                   rep = (ns-cnt[tn]+cnt[i])/cnt[i];
               }else
                   rep = Math.min((ns-cnt[tn]+cnt[i])/cnt[i], (ns0-cnt0[tn]+cnt0[i])/cnt0[i]);
               if(rep > ans  && tn-i + i*rep <= s.length()){
                   ans = rep;
                   pref = i;
                   rem1 = ns-cnt[tn]+cnt[i]-cnt[i]*ans;
                   rem0 = ns0-cnt0[tn]+cnt0[i]-cnt0[i]*ans;
               }
           }
        }
        //System.out.println(" ans = " + ans);
        if(rem1 < 0 || rem0 < 0)
            throw new RuntimeException();

        if(ans == 0){
            out.println(s);
        } else {
            if(pref > 0){
                String sub = t.substring(0, pref);
                for (int i = 0; i < ans-1; i++) {
                    out.print(sub);
                }
                out.print(t);
            } else {
                for (int i = 0; i < ans; i++) {
                    out.print(t);
                }
            }

            for (int i = 0; i < rem1; i++) {
                out.print('1');
            }
            for (int i = 0; i < rem0; i++) {
                out.print('0');
            }
            out.println();
        }

    }
}
