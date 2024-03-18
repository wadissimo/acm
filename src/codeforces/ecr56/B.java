package codeforces.ecr56;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            String s = in.ns();
            char[] cc = s.toCharArray();
            if(s.length() == 1){
                out.println(-1);
            } else{
                char c = cc[0];
                boolean found = false;
                for (int i = 1; i < s.length(); i++) {
                    if(cc[i] != c){

                        char tt = cc[i];
                        cc[i] = cc[s.length()-1];
                        cc[s.length()-1] = tt;

                        found = true;
                        break;
                    }
                }
                if(!found)
                    out.println(-1);
                else{
                    out.println(String.valueOf(cc));
                }
            }
        }
    }
}
