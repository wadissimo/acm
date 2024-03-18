package codeforces.r238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int mid = 500000;
        int max = 1000000;
        int[] a = new int[mid+1];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x <= mid) {
                a[x-1]++;
            } else {
                a[max-x] += 2;
            }
        }
        int pair = 0;
        int m = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mid + 1; i++) {
            if(a[i] == 1) {
                sb.append((max-i)).append(" ");
                m++;

            } else if(a[i] == 2){
                sb.append((i+1)).append(" ");
                m++;
            } else if(a[i]==3){
                pair++;
            }
        }
        for (int i = 0; i < mid + 1 && pair>0; i++) {
            if(a[i] == 0) {
                sb.append((i+1)).append(" ").append(max-i).append(" ");
                m+=2;
                pair--;
            }
        }
        System.out.println(m);
        System.out.println(sb);
    }
}
