package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class UniqueStrings {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl();
        int MAX = 10;
        long[][][][] dp = new long[MAX+1][7][7][7];//cnt(a)-cnt(b)
        dp[0][3][3][3] = 1;
        for (int len = 0; len < MAX; len++) {
            for (int max = 3; max < 7; max++) {
                for (int min = 0; min <= 3; min++) {
                    if(max - min > 3)
                        continue;
                    for (int cur = min; cur <= max; cur++) {
                        if(dp[len][max][min][cur] == 0)
                            continue;
                        if(cur == max){
                            if(cur+1-min <= 3){
                                dp[len+1][max+1][min][max+1] += dp[len][max][min][cur];
                            }
                        } else {
                            dp[len+1][max][min][cur+1] += dp[len][max][min][cur];
                        }
                        if(cur == min){
                            if(max-cur+1 <= 3){
                                dp[len+1][max][min-1][min-1] += dp[len][max][min][cur];
                            }
                        } else {
                            dp[len+1][max][min][cur-1] += dp[len][max][min][cur];
                        }
                    }
                }
            }
        }
        long [] res = new long[MAX+1];
        for (int len = 0; len <=MAX; len++) {
            for (int max = 3; max < 7; max++) {
                for (int min = 0; min <= 3 ; min++) {
                    for (int cur = min; cur <= max; cur++) {
                        res[len] += dp[len][max][min][cur];
                    }
                }
            }
        }
        System.out.println("Arrays.toString(res) = " + Arrays.toString(res));
    }
}
