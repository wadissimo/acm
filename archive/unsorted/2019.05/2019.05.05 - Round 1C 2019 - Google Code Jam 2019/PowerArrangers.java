package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class PowerArrangers {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        int F = in.ni();
        for (int t = 0; t < T; t++) {
            boolean[] used = new boolean[5];
            int[][] nums = new int[119][5];
            int[] ans = new int[5];
            Arrays.fill(ans, -1);
            int[] cnt = new int[5];
            for (int len = 0; len < 4; len++) {
                for (int i = 0; i < 119; i++) {
                    boolean good = true;
                    for (int j = 0; j < len; j++) {
                        if(nums[i][j] != ans[j])
                            good = false;
                    }
                    if(!good)
                        continue;
                    out.println(i * 5 + len+1);
                    out.flush();
                    char c = in.ns().charAt(0);
                    if(c == 'N')
                        return;
                    nums[i][len] = c -'A';
                    cnt[nums[i][len]]++;
                }
                int min = 120;
                for (int i = 0; i < 5; i++) {
                    if(!used[i] && cnt[i] < min){
                        min = cnt[i];
                        ans[len] = i;
                    }
                }
                used[ans[len]] = true;
                Arrays.fill(cnt, 0);
            }
            for (int i = 0; i < 5; i++) {
                if(!used[i])
                    ans[4] = i;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                sb.append((char)('A'+ans[i]));
            }
            out.println(sb.toString());
            out.flush();
            char res = in.ns().charAt(0);
            if(res != 'Y')
                return;
        }
    }
}
