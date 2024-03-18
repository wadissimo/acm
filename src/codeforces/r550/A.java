package codeforces.r550;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        for (int i = 0; i < n; i++) {
            String s = in.ns();
            if(s.length() == 1)
                out.println("Yes");
            else {
                boolean yes = true;
                boolean[] used = new boolean[26];
                for (int j = 0; j < s.length(); j++) {
                    int ind = s.charAt(j)-'a';
                    if(!used[ind])
                        used[ind] = true;
                    else{
                        yes = false;
                        break;
                    }
                }
                if(yes) {
                    int cnt = 0;
                    if(used[0])
                        cnt = 1;
                    for (int j = 1; j < 26; j++) {
                        if(used[j] && !used[j-1])
                            cnt++;
                    }
                    if(cnt > 1)
                        yes = false;
                }
                if(yes)
                    out.println("Yes");
                else
                    out.println("No");
            }
        }
    }
}
