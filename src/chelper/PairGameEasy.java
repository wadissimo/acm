package chelper;

public class PairGameEasy {
    public String able(int a, int b, int c, int d) {
        int[][] dp = new int[c+1][d+1];
        if(a > c || b > d) {
            return "Not able to generate";
        }
        dp[a][b] = 1;
        for (int i = a; i <= c; i++) {
            for (int j = b; j <= d; j++) {
                if(i > j && dp[i-j][j] == 1) {
                    dp[i][j] = 1;
                } else if(i<j && dp[i][j-i] == 1) {
                    dp[i][j] = 1;
                }
            }
        }
        if(dp[c][d] == 1) {
            return "Able to generate";
        } else {
            return "Not able to generate";
        }


    }
}
