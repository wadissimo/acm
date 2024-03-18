package codeforces.r240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class E {
    static int[] a;
    static int[] s;
    static long[][] inv;
    static long[][] rev;

    static int[] count (int start, int end, int index, int q) {
        if(end - start == 2) {
            if(a[start] > a[end-1]) {
                inv[q][index] = 1;
                return new int[]{a[start], a[end-1], -1};
            } else if(a[start] < a[end-1]) {
                rev[q][index] = 1;
                return new int[]{a[end-1], a[start], -1};
            } else {
                return new int[]{a[start], a[end-1], -1};
            }
        } else {
            int mid = (start + end) / 2;
            int[] la = count(start, mid, index * 2, q + 1);
            int[] ra = count(mid + 1, end, index * 2 + 1, q + 1);
            int[] res = new int[end-start + 1];
            //merge
            int l = 0;
            int r = 0;
            for (int i = 0; i < end - start; i++) {
                if(la[l] > ra[r]) {
                    res[i] = la[l];
                    l++;
                    inv[q][index] += end - r;
                } else if(ra[r] > la[l]) {
                    res[i] = ra[r];
                    r++;
                    rev[q][index] += mid - l;
                } else {
                    res[i] = la[l];
                    l++;
                }
            }
            res[end-start] = -1;
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        a = new int[1<<n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }




        st = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            int q = Integer.parseInt(st.nextToken());
        }

    }
}
