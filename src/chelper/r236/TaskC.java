package chelper.r236;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int t = in.ni();
        for (int i = 0; i < t; i++) {
            int n = in.ni();
            int p = in.ni();
            int edges = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < n; j++) {
                int k = j+1;
                for (int l = 0; l < j; l++) {
                    if(edges < 2*k + p) {
                        edges++;
                        sb.append((l+1) + " " + k).append("\n");
                    } else {
                        break;
                    }
                }
            }
            out.println(sb);
        }
    }
}
