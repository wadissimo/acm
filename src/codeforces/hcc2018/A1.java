package codeforces.hcc2018;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A1 {
    int n;
    char[][] rotate(char[][] map){
        char[][] res = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n-i-1] = map[i][j];
            }
        }
        return res;
    }
    char[][] flip(char[][] map){
        char[][] res = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = map[i][j];
            }
        }
        return res;
    }
    boolean compare(char[][]map, char[][] target){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {

        n = in.ni();
        char[][] map = in.nm(n, n);
        char[][] target = in.nm(n, n);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if(compare(map, target)){
                    out.println("Yes");
                    return;
                }
                map = rotate(map);
            }
            map = flip(map);
        }
        out.println("No");

    }
}
