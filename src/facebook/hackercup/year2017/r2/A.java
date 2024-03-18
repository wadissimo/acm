package facebook.hackercup.year2017.r2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Vadimka on 21.01.2017.
 */
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("c:/DEV/acm/tests/facebook/year2017/r2/subtle_sabotage.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2017/r2/subtle_sabotage_out.txt"));

        int t = Integer.parseInt(r.readLine()); // number of cycles
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int max =    k==1 ? k*5 : k*4;
            int min = k*2 + 3;
            if(n < m) {
                int tt = n;
                n = m;
                m = tt;
            }
            int ans = -1;
            if(n >= min && m > k) {
                ans = m/k;
                if(k*ans < m) ans++;
                if(ans > max) ans = max;
            }
            w.write("Case #" + (i+1) + ": " + ans + "\n");
        }

        w.close();
    }
}
