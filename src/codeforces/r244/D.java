package codeforces.r244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 */
public class D {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();

        long t1 = System.currentTimeMillis();

        String sum = "@" + s1 + "#" + s2;
        int ans = Integer.MAX_VALUE;
        int tz = 0;

        for (int i = 0; i < s1.length(); i++) {
            String search = s1.substring(i) + sum;
            long t11 = System.currentTimeMillis();
            int[] z = z(search);//calculate z function
            long t12 = System.currentTimeMillis();
            tz += t12-t11;
            int s1start = s1.length() - i + 1;
            int max1 = 0;
            for (int j = s1start; j < s1start + s1.length(); j++) {
                if(j-s1start != i){//exclude itself
                    max1 = Math.max(z[j], max1);
                }
            }
            max1 ++; //unique
            int s2start = 2*s1.length() - i + 2;
            int max2 = 0; //max length
            int max3 = 0; //previous max length
            for (int j = s2start; j < s2start + s2.length(); j++) {
                if(z[j] >= max1) {
                    if(z[j] > max2) {
                        max3 = max2;
                        max2 = z[j];
                    } else if(z[j] > max3) {//repetition
                        max3 = z[j];
                    }
                }
            }
            if(max2 != 0 && max2 != max3){ //found and unique
                if(max3 == 0) { //if found only once
                    max3 = max1 - 1;
                }
                ans = Math.min(ans, max3 + 1);//max3 + 1 is the smallest unique since only one string is longer (max2)
            }
        }
        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }



        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1) + " ms");
        System.out.println((tz) + " ms");


    }

    /**
     * Calculate z function - for each index equals to lcp length of the string and substring from imdex
     * @param s - string to search (usually substr#string)
     * @return z array
     */
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

    static String printArray(int[][] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sb.append(a[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();

    }
}
