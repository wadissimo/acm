package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class RAONE {
    static int[][] d;
    static int f(int k, int oddPrefix, int evenPrefix){ // k-dig length
        if(k == 0){
            if(evenPrefix-oddPrefix == 1)
                return 1;
            else
                return 0;
        }
        int res = 0;
        int keven = k/2;
        int kodd = k-keven;
        for (int i = 0; i < kodd*9+1; i++) {
            int odd = d[kodd-1][i];
            int evenSum = 1-evenPrefix+i+oddPrefix;
            if(keven == 0){
                if(evenSum == 0)
                    res += 1;
            } else if(evenSum >= 0)
                res += d[keven-1][evenSum]*odd;
        }
        return res;
    }
    static int calc(int n){
        String s = String.valueOf(n);
        int len = s.length();
        int oddPrefix = 0;
        int evenPrefix = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i)-'0';
            boolean even = (len-i)%2 == 0;
            for (int j = 0; j < x; j++) {
                if(even) {
                    res += f(len - i - 1, oddPrefix, evenPrefix+j);
                } else {
                    res += f(len - i - 1, oddPrefix+j, evenPrefix);
                }
            }
            if(even)
                evenPrefix+=x;
            else
                oddPrefix+=x;
        }
        return res;
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        d = new int[8][90];
        for (int i = 0; i < 10; i++) {
            d[0][i] = 1;
        }
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < i * 9 + 1; j++) {
                int cnt = d[i-1][j];
                for (int k = 0; k < 10; k++) {
                    d[i][j+k] += cnt;
                }
            }
        }
        int C = in.ni();
        for (int c = 0; c < C; c++) {
            int f = in.ni();
            int t = in.ni();
            if(f>t)
                out.println(0);
            else{
                if(f == 0)
                    f ++;
                out.println(calc(t+1)-calc(f));
            }
        }

    }
}
