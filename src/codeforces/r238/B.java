package codeforces.r238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());

        String s = reader.readLine();
        int li = -1;
        int ri = -1;
        int ans = 0;
        int[] stand = new int[n];

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'R'){
                for (int j = li+1; j < i; j++) {
                    ans++;
                }
                ri = i;
            }

            if(s.charAt(i) == 'L') {
                if (ri != -1) {
                    if ((i - ri) % 2 == 0) {
                        ans++;
                    }
                }
                li = i;
            }
        }

        if(li ==-1 && ri == -1) {
            System.out.println(n);
        } else if(li > ri) {
            System.out.println(ans + n-li-1);
        } else {
            System.out.println(ans);
        }


    }
}
