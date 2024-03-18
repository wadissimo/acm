package facebook.hackercup.year2017;

import java.io.*;
import java.util.TreeSet;

/**
 * Created by Vadimka on 08.01.2017.
 */
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("c:/DEV/acm/tests/facebook/year2017/lazy_loading.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2017/lazy_loading_out.txt"));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(r.readLine()); // number of cycles
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(r.readLine());
            TreeSet<Double> items = new TreeSet<>();
            for (int j = 0; j < n; j++) {
                items.add(Integer.parseInt(r.readLine()) + 0.00001 * j); //avoid dups
            }
            int ans = 0;
            while(!items.isEmpty()) {
                ans++;
                int top = items.pollLast().intValue();
                //find how many we need under it
                for (int j = 1; j*top < 50; j++) {
                    if(items.pollFirst() == null) {
                        ans --;
                        break;
                    }
                }
            }
            sb.append("Case #").append(i + 1).append(": ").append(ans).append("\n");
        }
        w.write(sb.toString());
        w.close();
    }
}
