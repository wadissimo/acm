package codeforces.r243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *
 */
public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int [] a = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        TreeSet<Integer>[] positions = new TreeSet[100000];
        int [] b = new int[m];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            if(positions[b[i]] == null) {
                positions[b[i]] = new TreeSet<Integer>();
            }
            positions[b[i]].add(i);
        }
        int maxMoney = (s-e)/e;
        int[][] d = new int[n+1][maxMoney+1];
        for (int i = 1; i < maxMoney + 1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(positions[a[j-1]] != null) {
                    Integer nextBi = positions[a[j-1]].ceiling(d[j - 1][i - 1]);
                    if (nextBi != null) {
                        d[j][i] = nextBi;
                    } else {
                        d[j][i] = d[j-1][i];
                    }
                } else {
                    d[j][i] = d[j-1][i];
                }
            }
        }
        System.out.println(printArray(d));


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
