package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

public class ADarkerAndDarker {
    class Pos {
        int r,c,d;

        public Pos(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int H = in.ni(), W = in.ni();
        char[][] grid = new char[H][];
        for (int i = 0; i < H; i++) {
            grid[i] = in.ns().toCharArray();
        }
        Deque<Pos> dq = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(grid[i][j] == '#'){
                    dq.offer(new Pos(i,j,0));
                }
            }
        }
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        int ans = 0;
        while(!dq.isEmpty()){
            Pos pos = dq.poll();
            for (int i = 0; i < 4; i++) {
                int rr = pos.r + dx[i];
                int cc = pos.c + dy[i];
                if(rr >= 0 && rr < H && cc >= 0 && cc < W && grid[rr][cc] == '.'){
                    grid[rr][cc] = '#';
                    dq.offer(new Pos(rr, cc, pos.d+1));
                }
            }
            ans = pos.d;
        }
        out.println(ans);


    }
}
