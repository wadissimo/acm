package codeforces.r542;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class C {
    class Cell{
        int r,c;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    int n;
    boolean[][] visited;
    char[][] map;
    List<Cell> process(int r, int c){
        List<Cell> res = new LinkedList<>();
        LinkedList<Cell> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new Cell(r, c));
        int[] dx = new int[]{1,-1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while(!q.isEmpty()){
            Cell cur = q.poll();
            res.add(cur);
            int x = cur.r;
            int y = cur.c;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if(map[nx][ny] == '0' && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new Cell(nx, ny));
                    }
                }
            }
        }
        return res;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {

        n = in.ni();
        int rs = in.ni()-1, cs = in.ni()-1;
        int rt = in.ni()-1, ct = in.ni()-1;
        map = in.nm(n,n);
        visited = new boolean[n][n];
        List<Cell> from = process(rs, cs);
        if(visited[rt][ct]){
            out.println(0);
        } else {
            List<Cell> to = process(rt, ct);
            int min = Integer.MAX_VALUE;
            for(Cell a: from){
                for(Cell b: to){
                    min = Math.min(min, (b.r-a.r)*(b.r-a.r) + (b.c-a.c)*(b.c-a.c));
                }
            }
            out.println(min);
        }
    }
}
