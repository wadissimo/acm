package codeforces.r301;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskC {
    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a[][]= new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == 'X') {
                    a[i][j] = 1;
                }
            }
        }

        st = new StringTokenizer(in.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        if(r1 == r2 && c1 == c2) {
            int free = 0;
            if(r1 + 1 <= n && a[r1][c1-1] != 1) {
                free++;
            }
            if(r1 - 1 > 0 && a[r1 - 2][c1-1] != 1) {
                free++;
            }

            if(c1 + 1 <= m && a[r1 - 1][c1] != 1) {
                free++;
            }
            if(c1 - 1 > 0 && a[r1 - 1][c1-2] != 1) {
                free++;
            }
            if(a[r1-1][c1-1] == 1 && free > 0 || a[r1-1][c1-1] == 0 && free > 1) {
                out.println("YES");

            } else {
                out.println("NO");
            }
            return;

        }
        boolean finalFull = (a[r2-1][c2-1] == 0);
        a[r2-1][c2-1] = 0;
        int mark[][]= new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(r1,c1));
        mark[r1-1][c1-1] = 1;
        while(!q.isEmpty()) {
            Pair e = q.poll();
            if(e.r == r2 && e.c == c2) {
                if(!finalFull) {
                    out.println("YES");

                } else {
                    int free = 0;
                    if(e.r + 1 <= n && a[e.r][e.c -1] != 1) {
                        free++;
                    }
                    if(e.r - 1 > 0 && a[e.r - 2][e.c -1] != 1) {
                        free++;
                    }

                    if(e.c + 1 <= m && a[e.r - 1][e.c] != 1) {
                        free++;
                    }
                    if(e.c - 1 > 0 && a[e.r - 1][e.c -2] != 1) {
                        free++;
                    }
                    boolean adj = false;
                    if(r1 == r2 && Math.abs(c1-c2)==1) {
                        adj = true;
                    }
                    if(c1 == c2 && Math.abs(r1-r2) == 1) {
                        adj = true;
                    }

                    if(free > 1 || free == 1 && adj) {
                        out.println("YES");
                    } else {
                        out.println("NO");
                    }

                }
                return;
            }
            if(e.r + 1 <= n && a[e.r][e.c -1] != 1 && mark[e.r][e.c -1] != 1) {
                q.add(new Pair(e.r + 1, e.c));
                mark[e.r][e.c -1] = 1;
            }
            if(e.r - 1 > 0 && a[e.r - 2][e.c -1] != 1 && mark[e.r - 2][e.c -1] != 1) {
                q.add(new Pair(e.r - 1, e.c));
                mark[e.r - 2][e.c -1] = 1;
            }

            if(e.c + 1 <= m && a[e.r - 1][e.c] != 1 && mark[e.r - 1][e.c] != 1) {
                q.add(new Pair(e.r, e.c + 1));
                mark[e.r - 1][e.c] = 1;
            }
            if(e.c - 1 > 0 && a[e.r - 1][e.c -2] != 1 && mark[e.r - 1][e.c -2] != 1) {
                q.add(new Pair(e.r, e.c - 1));
                mark[e.r - 1][e.c -2] = 1;
            }

        }
        out.println("NO");

    }
}
