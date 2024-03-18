package yandex.qual;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String input = in.readLine();
        int n = in.ni();
        String [] dic = new String[n];
        for (int i = 0; i < n; i++) {
            dic[i] = in.ns();
        }
        for (StringTokenizer stringTokenizer = new StringTokenizer(input, " "); stringTokenizer.hasMoreTokens(); ) {
            String s = stringTokenizer.nextToken();
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if(dic[i].equals(s)) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                out.println("Misspell");
                return;
            }

        }
        out.println("Correct");


    }
}
