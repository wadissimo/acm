package codeforces.ecr47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    public static int gcd(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(i).append(" ").append(i+1).append('\n');
            ans++;
        }
        if (ans < m) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = i + 2; j < n + 1; j++) {
                    if (i == 1 || gcd(i, j) == 1) {
                        sb.append(i).append(" ").append(j).append('\n');
                        ans++;
                        if (ans == m)
                            break;
                    }
                }
                if (ans == m)
                    break;
            }
        }
        if(ans != m)
            System.out.println("Impossible");
        else{
            System.out.println("Possible");
            System.out.println(sb.toString());
        }
    }
}
