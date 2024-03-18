package codejam.year2019.r1a;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni(), n = in.ni(), m = in.ni();
        int[] set = new int[]{18,17,13,11,7,5};
        int[][] rems = new int[m+1][6];
        for (int i = 1; i <=m; i++) {
            for (int j = 0; j < 6; j++) {
                rems[i][j] = i%set[j];
            }
        }
        for (int t = 0; t < T; t++) {
            int[] rem = new int[6];

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 18; j++) {
                    out.print(set[i] + " ");
                }
                out.println();
                out.flush();
                int sum = 0;
                for (int j = 0; j < 18; j++) {
                    sum+= in.ni();
                }
                rem[i] = sum%set[i];
            }
            int ans = 0;
            for (int i = 1; i <= m; i++) {
                boolean correct = true;
                for (int j = 0; j < 6; j++) {
                    if(rem[j] != rems[i][j]){
                        correct = false;
                        break;
                    }
                }
                if(correct){
                    ans = i;
                    break;
                }
            }
            out.println(ans);
            out.flush();
            int res = in.ni();
            if(res == -1)
                return;
        }
    }
}
