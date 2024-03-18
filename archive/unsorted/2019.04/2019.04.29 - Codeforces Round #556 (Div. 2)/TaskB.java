package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        char[][] map = in.nm(n, n);
        for (int i = 0; i < n-2; i++) {
            for (int j = 1; j < n-1; j++) {
                if(map[i][j] == '.'){
                    if(map[i+1][j] == '.' && map[i+1][j-1] == '.' && map[i+1][j+1] == '.' && map[i+2][j] == '.'){
                        map[i][j] = map[i+1][j] = map[i+1][j-1] = map[i+1][j+1] = map[i+2][j] = '#';
                    }
                }
            }
        }
        boolean check = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == '.')
                    check = false;
            }
        }
        if(check){
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}
