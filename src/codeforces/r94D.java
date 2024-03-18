package codeforces;

import chelper.io.FastScanner;
import common.StringUtil;

import java.io.PrintWriter;
import java.util.Arrays;

public class r94D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();

        int k = in.ni();
        int n = s.length()+1;
        int[] p = new int[n];
        int[] c = new int[n];
        s = s + "|";
        StringUtil.suffixArray(s, p, c);

//        System.out.println("Arrays.toString(p) = " + Arrays.toString(p));
//        System.out.println("Arrays.toString(c) = " + Arrays.toString(c));
        int[] used = new int[n];
        int ai = -1;
        int li = -1;
        for (int i = 0; i < n-1 && k > 0; i++) {
            int maxlen = n-1 - p[i];
//            System.out.println("maxlen = " + maxlen);
            for (int len = used[i]+1; len <= maxlen && k > 0; len++) {
                for (int j = i; j < n - 1 ; j++) {
//                    System.out.println("len = " + len);
//                    System.out.println("j = " + j);
//                    System.out.println("s.substring(ai, ai+li) = " + s.substring(p[j], p[j] + len));
                    k--;
                    if(k == 0){
                        ai = p[j];li = len;
                        break;
                    }
                    used[j]++;
                    if(j >= n-2 || used[j+1] != used[j]-1 || s.charAt((p[j] + len-1)%n) != s.charAt((p[j+1] + len-1)%n)){
                        break;
                    }
                }
            }
        }
        if(ai == -1){
            out.println("No such line.");
        } else {
            out.println(s.substring(ai, ai+li));
        }

    }
}
