package codeforces.r454;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    int from(int x){
        int res = x;
        if(x > 2)
            res--;
        if(x > 6)
            res--;
        return res;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        char[][] map = new char[9][9];
        int k = 0;
        for (int i = 0; i < 11; i++) {
            if(i == 3 || i == 7) {
                String s = in.readLine();
                //System.out.println("s = " + s);
            }else{
                String s = in.readLine();
                int l = 0;
                for (int j = 0; j < 11; j++) {
                    if(s.charAt(j) == ' ')
                        continue;
                    map[k][l++] = s.charAt(j);
                }
                k++;
            }
        }
        int r = in.ni()-1, c = in.ni()-1;
        //int x = from(r); int y = from(c);
        int bx = (r%3)*3, by = (c%3)*3;
        boolean free = false;
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if(map[bx+i][by+j] == '.')
                    free = true;
            }
        }
        if(free){
            for (int i = 0 ; i < 3 ; i++) {
                for (int j = 0; j < 3; j++) {
                    if(map[bx+i][by+j] == '.')
                        map[bx+i][by+j] = '!';
                }
            }
        } else {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(map[i][j] == '.')
                        map[i][j] = '!';
                }
            }
        }
        k = 0;
        for (int i = 0; i < 11; i++) {
            if(i == 3 || i == 7) {
                out.println();
                continue;
            }
            int l = 0;
            for (int j = 0; j < 11; j++) {
                if(j == 3 || j == 7)
                    out.print(' ');
                else
                    out.print(map[k][l++]);
            }
            out.println();
            k++;
        }


    }
}
