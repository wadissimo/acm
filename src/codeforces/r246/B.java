package codeforces.r246;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 15.05.2014.
 */
public class B {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[]x = new int[n];
        int[]y = new int[n];
        int[] colors = new int[100010];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            colors[x[i]]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int g = colors[y[i]];

            int home = (n-1)+g;
            int guest = 2*(n-1)-home;
            sb.append(home).append(" ").append(guest).append("\n");
        }
        System.out.println(sb);
    }
}
