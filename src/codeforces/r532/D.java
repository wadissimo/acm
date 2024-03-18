package codeforces.r532;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    int BOARD_SIZE = 9;
    int ROOKS_CNT = 6;
    private boolean move(FastScanner in, PrintWriter out, int xt, int yt){
        int moves = Math.max(Math.abs(sx-xt), Math.abs(sy-yt));
        int[] dx = new int[]{1, 1, -1, -1};
        int[] dy = new int[]{-1, 1, -1, 1};
        for (int i = 0; i < moves; i++) {
            boolean found = false;
            for (int j = 0; j < 4; j++) {
                if(sx+dx[j] >= 0 && sx+dx[j] < BOARD_SIZE && sy+dy[j] >= 0 && sy+dy[j] < BOARD_SIZE && map[sx+dx[j]][sy+dy[j]]){
                    sx += dx[j];
                    found = true;
                }
            }
            if(!found){
                if(sx < xt) sx++;
                if(sx > xt) sx--;
                if(sy < yt) sy++;
                if(sy > yt) sy--;
            }
            out.printf("%d %d%n", sx + 1, sy + 1);
            out.flush();
            int k = in.ni()-1, nx = in.ni()-1, ny = in.ni();
            if(k == -2)
                return true;
            map[rx[k]][ry[k]] = false;
            rx[k] = nx;
            ry[k] = ny;
            map[rx[k]][ry[k]] = true;
        }
        return false;
    }
    boolean [][] map;
    int sx;
    int sy;
    int[]rx;
    int[]ry;
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        map = new boolean[BOARD_SIZE][BOARD_SIZE];
        sx = in.ni()-1;
        sy = in.ni()-1;
        rx = new int[ROOKS_CNT];
        ry = new int[ROOKS_CNT];
        for (int i = 0; i < ROOKS_CNT; i++) {
            rx[i] = in.ni()-1;ry[i] = in.ni()-1;
            map[rx[i]][ry[i]] = true;
        }
        int cx = BOARD_SIZE/2;
        int cy = BOARD_SIZE/2;
        boolean res = move(in, out, cx, cy);
        if(res)
            return;
        int lu = 0, ru = 0, lb = 0, rb = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if(i < cx && j < cy && map[i][j]) lu++;
                if(i < cx && j > cy && map[i][j]) ru++;
                if(i > cx && j < cy && map[i][j]) lb++;
                if(i > cx && j > cy && map[i][j]) rb++;
            }
        }
        int[] qs = new int[]{ROOKS_CNT-rb, ROOKS_CNT-lb, ROOKS_CNT-ru, ROOKS_CNT-lu};
        int[]xt = new int[]{0, 0, BOARD_SIZE-1, BOARD_SIZE-1};
        int[]yt = new int[]{0, BOARD_SIZE-1, 0, BOARD_SIZE-1};
        int max = 0;
        int maxInd = 0;
        for (int i = 0; i < 4; i++) {
            if(qs[i] > max){
                max = qs[i];
                maxInd = i;
            }
        }
        move(in, out, xt[maxInd], yt[maxInd]);
    }
}

