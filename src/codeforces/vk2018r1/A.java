package codeforces.vk2018r1;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int r = in.ni(), c = in.ni();
        char[][] map = in.nm(r, c);
        int[]dx = new int[]{1, -1, 0, 0};
        int[]dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == 'W'){
                    for (int k = 0; k < 4; k++) {
                        int ni = i+dy[k];
                        int nj = j+dx[k];
                        if(ni>=0 && ni < r && nj >= 0 && nj < c){
                            if(map[ni][nj] == 'S'){
                                out.println("No");
                                return;
                            }
                            if(map[ni][nj] == '.'){
                                map[ni][nj] = 'D';
                            }
                        }
                    }
                }
            }
        }
        out.println("Yes");
        for (int i = 0; i < r; i++) {
            out.println(String.valueOf(map[i]));
        }
    }
}
