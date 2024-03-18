package codeforces.r522;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int n = s.length();
        int r = n / 20 + (n%20 == 0 ? 0 : 1);
        int addstar[] = new int[5];
        //System.out.println("r = " + r);
        for (int c = 1; c <= 20; c++) {
            if(n <= r*c){
                int rem = r*c-n;
                if(rem > 0){
                    for (int i = 0; i < rem; i++) {
                        addstar[r-i-1] = 1;
                    }
                }
                int si = 0;
                //System.out.println("c = " + c);
                //System.out.println(Arrays.toString(addstar));
                out.println(r + " " + c);
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if(j == c-1 && addstar[i] == 1)
                            out.print('*');
                        else
                            out.print(s.charAt(si++));
                    }
                    out.println();
                }

                break;
            }
        }

    }
}
