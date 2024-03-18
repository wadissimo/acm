package codeforces.alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class C {
    public static final String stars = "**************************************************************************"+
            "**************************************************************************"+
            "**************************************************************************"+
            "**************************************************************************"
            ;
    public static final String spaces = "                                                                          "+
            "                                                                          "+
            "                                                                          "+
            "                                                                          ";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append(spaces.substring(0, n-1-j)).append(stars.substring(0, j*2+1)).append("\n");
            }

        }
        System.out.println(sb);
    }
}
