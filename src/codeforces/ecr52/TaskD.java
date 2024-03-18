package codeforces.ecr52;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskD {
    public static final int MAX_PATH = 1000000;
    public static final int K = 0;
    public static final int B = 1;
    public static final int R = 2;
    class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    class Pair{
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
     int getBDist(int r, int c, int ra, int ca){
        if(r==ra && c==ca)
            return 0;
        if((r+c)%2 != (ra+ca)%2)
            return MAX_PATH;
        if(r-ra==c-ca || r-ra == ca-c)
            return 1;
        return 2;
    }

     int getRDist(int r, int c, int ra, int ca){
         if(r==ra && c==ca)
             return 0;
        if(r==ra || c == ca)
            return 1;
        return 2;
    }
     Point[] coords;
     int [][]d;
    int [] di = new int[]{2, 2, 1, -1, -2, -2, 1, -1};
    int [] dj = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
    int n;
     Pair dist(int from, int to, int start, int end){
        Point p = coords[from];
        Point q = coords[to];
        if(start == end){
            if(start == K)
                return new Pair(d[from][to],0);
            else if(start == B) {
                return new Pair(getBDist(p.r, p.c, q.r, q.c), 0);//todo:
            }else
                return new Pair(getRDist(p.r,p.c,q.r,q.c),0);
        } else{
            if(start == R && end == B || start == B && end == R){
                if(getBDist(p.r, p.c, q.r, q.c) == 1)
                    return new Pair(2, 1);
                if(getRDist(p.r, p.c, q.r, q.c) == 1)
                    return new Pair(2,1);
                return new Pair(3,1);
            }
            if(start == K && end == B || start == B && end == K){
                if(end == K){
                    Point t = p;
                    p = q;
                    q = t;
                }
                int min = getBDist(p.r, p.c, q.r, q.c);
                for (int i = 0; i < 8; i++) {
                    int ni = p.r+di[i];
                    int nj = p.c+dj[i];
                    if(0<=ni && ni < n && 0<= nj && nj < n){
                        min = Math.min(1+getBDist(ni, nj, q.r, q.c), min);
                    }
                }
                return new Pair(min+1, 1);
            }
            if(start == K && end == R|| start == R && end == K){
                if(end == K){
                    Point t = p;
                    p = q;
                    q = t;
                }
                int min = getRDist(p.r, p.c, q.r, q.c);
                for (int i = 0; i < 8; i++) {
                    int ni = p.r+di[i];
                    int nj = p.c+dj[i];
                    if(0<=ni && ni < n && 0<= nj && nj < n){
                        min = Math.min(1+getRDist(ni, nj, q.r, q.c), min);
                    }
                }
                return new Pair(min+1, 1);
            }
        }
        throw new RuntimeException();

    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.ni();
        int [][] a= new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.ni()-1;
            }
        }
        int n2 = n*n;

        d = new int[n2][n2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n2; j++) {
                if(i==j)
                    d[i][i] = 0;
                else
                    d[i][j] = MAX_PATH;
            }
        }


        coords = new Point[n2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coords[a[i][j]] = new Point(i,j);
                for (int k = 0; k < 8; k++) {
                    int ni = i+di[k];
                    int nj = j+dj[k];
                    if(0<=ni && ni < n && 0<= nj && nj < n){
                        d[a[i][j]][a[ni][nj]] = 1;
                    }
                }

            }
        }
        for (int k = 0; k < n2; k++) {
            for (int i = 0; i < n2; i++) {
                for (int j = 0; j < n2; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
                }
            }
        }
        int ans[][] = new int[n2][3];
        int swaps[][] = new int[n2][3];
        for (int i = 0; i < n2-1; i++) {
            for (int j = 0; j < 3; j++) {
                int minDist = MAX_PATH;
                int minSwap = n2;
                for (int k = 0; k < 3; k++) {
                    Pair pair = dist(i, i + 1, k, j);
                    int dist = ans[i][k]+pair.x;
                    int swap = swaps[i][k]+pair.y;
                    if(dist < minDist || dist == minDist && swap < minSwap){
                        minDist = dist;
                        minSwap = swap;
                    }
                }
                ans[i+1][j] += minDist;
                swaps[i+1][j] = minSwap;
            }
        }
        int minDist = MAX_PATH;
        int minSwap = n2;
        for (int k = 0; k < 3; k++) {
            int dist = ans[n2-1][k];
            int swap = swaps[n2-1][k];
            if(dist < minDist || dist == minDist && swap < minSwap){
                minDist = dist;
                minSwap = swap;
            }
        }

        out.println(minDist +" " + minSwap);

    }
}
