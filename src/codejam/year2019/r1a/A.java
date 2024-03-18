package codejam.year2019.r1a;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class A {
    int r;
    int c;
    boolean[][] grid;
    class Pair{
        int a,b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    LinkedList<Pair> res;
    boolean go(int x, int y, int k, int sx, int sy){
        grid[x][y] = true;
        if(k == r*c) {
            res.addFirst(new Pair(sx +x, sy+y));
            return true;
        }
        for (int i = 0; i < r; i++) {
            if(i == x)
                continue;
            for (int j = 0; j < c; j++) {
                if(grid[i][j] || j == y || Math.abs(i-x) == Math.abs(j-y))
                    continue;

                if(go(i,j, k+1, sx, sy)) {
                    res.addFirst(new Pair(sx+x, sy+y));
                    return true;
                }
            }
        }
        grid[x][y] = false;
        return false;
    }
    List<Integer> breakDown(int what, int by){
        List<Integer> res = new LinkedList<>();
        if(what%by != 0){
            res.add(by+what%by);
            what -= what%by;
        }
        for (int i = 0; i < what / by; i++) {
            res.add(by);
        }
        return res;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            r = in.ni();
            c = in.ni();
            boolean ans = true;
            boolean swap = false;
            if(r == 1 || c == 1 || r ==2 && c < 5 || c ==2 && r < 5 || c ==3 && r ==3)
                ans = false;
            else{
                res = new LinkedList<>();
                if(r <=5 && c<=5){
                    grid = new boolean[r][c];
                    go(0, 0, 1, 0, 0);
                } else {
                    if (r > c) {
                        swap = true;
                        int tmp = r;
                        r = c;
                        c = tmp;
                    }
                    int row = 0;
                    if(r%2 == 1){
                        for (int i = 0; i < c; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (j % 2 == 0) {
                                    res.add(new Pair(j, i));
                                } else {
                                    res.add(new Pair(j, (i + 2) % c));
                                }
                            }
                        }
                        row+= 3;
                    }
                    for (; row < r; row+=2) {
                        for (int i = 0; i < c; i++) {
                            for (int j = 0; j < 2; j++) {
                                if (j % 2 == 0) {
                                    res.add(new Pair(row + j, i));
                                } else {
                                    res.add(new Pair(row + j, (i + 3) % c));
                                }
                            }
                        }
                    }
                }
            }

            out.printf("Case #%d: %s%n", t+1, ans?"POSSIBLE":"IMPOSSIBLE");
            if(ans){
                for (Pair re : res) {
                    if(swap)
                        out.printf("%d %d%n", re.b+1, re.a+1);
                    else
                        out.printf("%d %d%n", re.a+1, re.b+1);
                }
            }
        }
//        for (int i = 2; i <= 2; i++) {
//            for (int j = 4; j <=10; j++) {
//                r = i;
//                c = j;
//                grid = new boolean[i][j];
//                System.out.print("i = " + i);
//                System.out.print(", j = " + j);
//                res = new LinkedList<>();
//                if(go(0,0,1)){
//                    System.out.println(", YES");
//                    for (Pair re : res) {
//                        System.out.println(re.a + " " + re.b);
//                    }
//
//                } else
//                    System.out.println(", NO");
//            }
//        }
    }
}
