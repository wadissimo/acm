package codeforces.r245;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 11.05.2014.
 */
public class B {

    static int[] cut(int[] c, int pointer) {
        int left = pointer;
        int right = pointer;
        for (int i = pointer; i >=0 ; i--) {
            if(c[i] == c[pointer]) {
                left = i;
            } else {
                break;
            }
        }
        for (int i = pointer; i < c.length; i++) {
            if(c[i] == c[pointer]) {
                right = i;
            } else {
                break;
            }
        }

        if(right - left < 2) {
            return c;
        } else if(right-left+1 == c.length){
            return new int[0];
        }else{
            int w = right-left+1;
            int[]nc = new int[c.length - (w)];
            for (int i = 0; i < left; i++) {
                nc[i] = c[i];
            }
            for (int i = right+1; i < c.length; i++) {
                nc[i-w] = c[i];
            }
            int np = left;
            if(np == nc.length) {
                np--;
            }
            return cut(nc, np);

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int c[] = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        int min = n+1;
        for (int i = 0; i < n; i++) {
            if(c[i] == x){
                int[]nc = new int[n+1];
                for (int j = 0; j < i; j++) {
                    nc[j] = c[j];
                }
                nc[i] = x;
                for (int j = i+1; j < n + 1; j++) {
                    nc[j] = c[j-1];
                }

                int[] cut = cut(nc, i);
                if(cut.length < min) {
                    min = cut.length;
                }
            }
        }
        if(min == n+1) {
            System.out.println(0);
        }else {
            System.out.println(n-min);
        }




    }
}
