package facebook.hackercup.year2017;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Vadimka on 08.01.2017.
 */
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("c:/DEV/acm/tests/facebook/year2017/progress_pie.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2017/progress_pie_out.txt"));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(r.readLine()); // number of cycles
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int p = Integer.parseInt(st.nextToken()); // progress bar
            double x = Integer.parseInt(st.nextToken());
            double y = Integer.parseInt(st.nextToken());
            //center
            x -= 50;
            y -= 50;
            if(x == 0 && y == 0) {
                if(p > 0) {
                    sb.append("Case #" + (i+1) + ": black").append("\n");
                } else {
                    sb.append("Case #" + (i+1) + ": white").append("\n");
                }
            } else {
                double a = 0;// angle for (x,y)
                double atan = Math.toDegrees(Math.atan(x / y));
                if (x >= 0 && y >= 0) { // 1
                    a = atan;
                } else if (y < 0) { // 3 & 4
                    a += 180 + atan;
                } else if (x < 0 && y >= 0) { // 4
                    a += 360 + atan;
                }

                if(a <= p / 100.0 * 360.0 && x*x + y*y <= 2500) {
                    sb.append("Case #" + (i+1) + ": black").append("\n");

                } else {
                    sb.append("Case #" + (i+1) + ": white").append("\n");
                }

            }
        }
        w.write(sb.toString());
        w.close();
    }
}
