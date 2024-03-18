package codeforces.r545;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.*;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        final int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.ni();
            }
        }

        int[][] rows = new int[n][m];
        int[] rowMax = new int[n];
        for (int i = 0; i < n; i++) {
            Integer[] idx = new Integer[m];
            for (int j = 0; j < m; j++) {
                idx[j] = j;
            }
            final int[] row = map[i];
            Arrays.sort(idx, Comparator.comparingInt(o -> row[o]));
            int id = 0;
            rows[i][idx[0]] = id;
            for (int j = 1; j < m; j++) {
                if(map[i][idx[j]] > map[i][idx[j-1]]){
                    rows[i][idx[j]] = ++id;
                } else
                    rows[i][idx[j]] = id;
            }
            rowMax[i] = id;
        }

        int[][] cols = new int[n][m];
        int[] colMax = new int[m];
        for (int i = 0; i < m; i++) {
            Integer[] idx = new Integer[n];
            for (int j = 0; j < n; j++) {
                idx[j] = j;
            }
            final int cur = i;
            Arrays.sort(idx, Comparator.comparingInt(o -> map[o][cur]));
            int id = 0;
            cols[idx[0]][i] = id;
            for (int j = 1; j < n; j++) {
                if(map[idx[j]][i] > map[idx[j-1]][i]){
                    cols[idx[j]][i] = ++id;
                } else
                    cols[idx[j]][i] = id;
            }
            colMax[i] = id;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int lessc = cols[i][j];
                int lessr = rows[i][j];
                int mid = Math.max(lessc, lessr)+1;
                out.print((mid + Math.max(colMax[j]-lessc, rowMax[i]-lessr)) + " ");
            }
            out.println();
        }

    }
}
