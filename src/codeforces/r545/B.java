package codeforces.r545;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String a = in.ns();
        String b = in.ns();
        int c11 = 0;
        int c10 = 0;
        int c01 = 0;
        int[] type = new int[n];
        for (int i = 0; i < n; i++) {
            if(a.charAt(i) == '1') {
                if (b.charAt(i) == '1') {
                    c11++;
                    type[i] = 11;
                }else {
                    type[i] = 10;
                    c10++;
                }
            }else if (b.charAt(i) == '1') {
                type[i] = 1;
                c01++;
            }
        }
        boolean found = false;
        for (int i = 0; i <= Math.min(n / 2, c11) && !found; i++) {
            for (int j = 0; j <= Math.min(n / 2, c10); j++) {
                if(i+j <= c11-i + c01 && i+j >= c11-i){
                    int rem01 = c01-(i+j-c11+i);
                    int rem10 = c10-j;
                    if(rem01+i+j <= n/2 && rem10+i+j <= n/2){
                        int cnt00 = n/2-rem01-i-j;
                        for (int k = 0; k < n; k++) {
                            if (type[k] == 0 && cnt00 > 0){
                                cnt00--;
                                out.print((k+1)+ " ");
                            } else if(type[k] == 1 && rem01 > 0){
                                rem01--;
                                out.print((k+1)+ " ");
                            } else if(type[k] == 11 && i > 0){
                                i--;
                                out.print((k+1)+ " ");
                            } else if(type[k] == 10 && j > 0){
                                j--;
                                out.print((k+1)+ " ");
                            }
                        }
                        found = true;
                        break;
                    }
                }

            }
        }
        if(!found)
            out.println(-1);
    }
}
