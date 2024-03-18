package codestrike.r2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 10.05.2014.
 */
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] =Integer.parseInt(st.nextToken());
            }
        }
        int[] chatMessages = new int[m];
        int[] sent = new int[n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sent[x-1]++;
            chatMessages[y-1]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if(a[i][j] == 1) {
                    sum += chatMessages[j];
                }
            }
            sum -= sent[i];
            sb.append(sum);
            if(i != n-1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
