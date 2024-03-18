package codeforces.ecr59;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int div = 2;
        ArrayList<Integer> divs = new ArrayList<>();
        divs.add(n);
        for (; div*div < n ; div++) {
            if(n%div == 0){
                divs.add(div);
                divs.add(n/div);
            }
        }
        if(div*div == n)
            divs.add(div);

        BigInteger[] bis = new BigInteger[n];
        String[] bm = new String[]{"0000", "0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            String s = in.ns();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n / 4; j++) {
                char c = s.charAt(j);
                if(c>='0' && c <= '9')
                    sb.append(bm[c-'0']);
                else
                    sb.append(bm[10+c-'A']);

            }
            ss[i] = sb.toString();
            bis[i] = new BigInteger(s, 16);
        }
        boolean[] eq = new boolean[n];
        for (int i = 1; i < n; i++) {
            eq[i] = bis[i].equals(bis[i-1]);
        }


        int ans = 1;
        for (int x : divs) {
            boolean correct = true;

            for (int i = 0; i < n / x && correct; i++) {
                for (int j = 0; j < n / x && correct; j++) {
                    for (int k = 1; k < x; k++) {
                        if(ss[i*x].charAt(j*x + k) != ss[i*x].charAt(j*x+k-1)){
                            correct = false;
                            break;
                        }
                    }
                }

                for (int j = 1; j < x; j++) {
                    if(!eq[i*x+j]){
                        correct = false;
                        break;
                    }
                }
            }

            if(correct)
                ans = Math.max(ans, x);
        }
        out.println(ans);


    }
}
