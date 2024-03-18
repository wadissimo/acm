package codeforces.mailru2018.r2;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String[] a = new String[n];
        String[] b = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ns();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.ns();
        }
        String s = null, t = null;
        int min = 0;
        int max = 0;
        String ss = null;
        for (int i = 0; i < n; i++) {
            if(!a[i].equals(b[i])){
                if(s==null) {
                    s = a[i];
                    t = b[i];
                    min = a[i].length();
                    max = 0;
                    for (int j = 0; j < a[i].length(); j++) {
                        if(a[i].charAt(j) != b[i].charAt(j)){
                            min = Math.min(j, min);
                            max = Math.max(j, max);
                        }
                    }
                    ss = s.substring(min, max+1);
                } else {
                    int first = a[i].indexOf(ss);
                    if(first == -1){
                       out.println("NO");
                       return;
                    }
                    int si = min-1;
                    for (int j = first-1; j >= 0 ; j--) {

                    }
                    boolean match = true;
                    for (int j = 0; j < a[i].length(); j++) {
                        if(j >= first && j < first + s.length()){
                            if(t.charAt(j-first) != b[i].charAt(j)){
                                match = false;
                                break;
                            }
                        } else {
                            if(a[i].charAt(j) != b[i].charAt(j)){
                                match = false;
                                break;
                            }
                        }
                    }
                    if(!match){
                        out.println("NO");
                        return;
                    }

                }
            }
        }
        out.println("YES");
        out.println(s);
        out.println(t);
    }
}
