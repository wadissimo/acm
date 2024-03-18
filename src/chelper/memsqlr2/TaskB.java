package chelper.memsqlr2;

import chelper.io.InputReader;
import common.StringUtil;

import java.io.PrintWriter;
import java.util.LinkedList;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.readLine();
        String rs = new StringBuilder(s).reverse().toString();
        if(s.length()<=2600) {
            int n = s.length();

            int[][]dp = new int[n+1][n+1];
            int[][] path = new int[n+1][n+1];

            for (int i = n-1; i > 0; i--) {
                dp[i][i] = 1;
                for (int j = i+1; j <= n; j++) {
                    if(s.charAt(i-1) == s.charAt(j-1)) {
                        dp[i][j] = dp[i+1][j-1] + 2;
                        path[i][j] = 2;
                    } else {
                        if(dp[i][j-1]>dp[i+1][j]) {
                            dp[i][j] = dp[i][j-1];
                            path[i][j] = -1;
                        }else{
                            dp[i][j] = dp[i+1][j];
                            path[i][j] = 1;
                        }

                    }
                }
            }
            int i = 1;
            int j = n;
            StringBuilder sb = new StringBuilder();
            char mid = 0;
            while(i<j) {
                if(path[i][j] == 2) {
                    char c = s.charAt(i - 1);
                    sb.append(c);
                    i++;j--;
                } else if(path[i][j] == 1) {
                    i++;
                } else {
                    j--;
                }

            }
            if(i==j) {
                mid = s.charAt(i - 1);
            }
            if(sb.length() >= 50) {
                sb = new StringBuilder(sb.substring(0,50));
                mid=0;
            }
            StringBuilder reverse = new StringBuilder(sb.toString()).reverse();
            if(mid != 0) {
                sb.append(mid);
            }
            sb.append(reverse);


            out.println(sb);
        } else {
            int[] a = new int[26];
            for (int i = 0; i < s.length(); i++) {
                a[s.charAt(i)-'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if(a[i]>=100) {
                    char c = (char)('a'+i);
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < 100; j++) {
                        sb.append(c);
                    }
                    out.println(sb);
                    break;
                }
            }
        }
    }
}
