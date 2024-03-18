package codeforces.r246;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 15.05.2014.
 */
public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = s.length();
        int[] z = z(s);
        int[]sl = new int[n+1];
        for (int i = 0; i < n; i++) {
            sl[z[i]]++;
        }
        int[] ssl = new int[n+1];
        ssl[n] = sl[n];
        for (int i = n-1; i >0; i--) {
            ssl[i] = ssl[i+1]+sl[i];
        }


        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = n-1; i >= 0; i--) {
            if(z[i]==n-i) {
                int c = ssl[n-i];
                sb.append(n-i).append(" ").append(c).append("\n");
                ans++;
            }

        }
        System.out.println(ans);
        System.out.println(sb);


    }

    static int[] z(String s) {
        int[] z = new int[s.length()];
        int l = 0, r = 0;
        int j;
        z[0] = s.length();
        for (int i = 1; i < s.length(); i++)
            if (i > r){
                for (j = 0; ((j + i) < s.length()) && (s.charAt(i + j) == s.charAt(j)) ; j++);
                z[i] = j;
                l = i;
                r = i + j - 1;
            }
            else
            if (z[i - l] < r - i + 1)
                z[i] = z[i - l];
            else{
                for (j = 1; ((j + r) < s.length())&& (s.charAt(r + j) == s.charAt(r - i + j)); j++);
                z[i] = r - i + j;
                l = i;
                r = r + j - 1;
            }
        return z;
    }
}
