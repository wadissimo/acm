package facebook.hackercup.y2020.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni();
            String is = in.ns();
            String os = in.ns();
            out.printf("Case #%d:%n", t+1);

            for (int i = 0; i < N; i++) {
                boolean[] res = new boolean[N];
                res[i] = true;
                for (int j = i+1; j < N; j++) {
                    if (is.charAt(j) == 'N' || os.charAt(j - 1) == 'N')
                        break;
                    res[j] = true;
                }
                for (int j = i-1; j >= 0; j--) {
                    if (is.charAt(j) == 'N' || os.charAt(j + 1) == 'N')
                        break;
                    res[j] = true;
                }
                for (int j = 0; j < N; j++) {
                    out.print(res[j]?'Y':'N');
                }
                out.println();
            }
        }
    }
}
