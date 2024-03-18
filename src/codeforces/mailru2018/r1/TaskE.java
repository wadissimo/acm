package codeforces.mailru2018.r1;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskE {
    class Move{
        int x,y,xa,ya;

        public Move(int x, int y, int xa, int ya) {
            this.x = x;
            this.y = y;
            this.xa = xa;
            this.ya = ya;
        }
    }
    class Cell{
        int x,y;
        LinkedList<Integer> chips;

        public Cell(int x, int y, String s) {
            chips = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0'){
                    chips.add(0);
                }else{
                    chips.add(1);
                }
            }
            this.x = x;
            this.y = y;
        }
    }
    class Pos{
        int x,y,k;

        public Pos(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
    void move(LinkedList<Move> ans,Cell [][] a, int x, int y, int xt, int yt){
        ans.add(new Move(x,y,xt,yt));
        Integer chip = a[x][y].chips.pop();
        a[xt][yt].chips.addFirst(chip);
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int m = in.ni();
        Cell[] cells = new Cell[n*m];
        Cell [][] a = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String ns = in.ns();
                cells[i*m+j]= a[i][j] = new Cell(i,j,ns);
            }
        }
        String [][] b = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = in.ns();
            }
        }
        LinkedList<Move> ans = new LinkedList<>();
        //0,0 -> 0-s
        //1,1 -> 1-s
        while(a[0][0].chips.size() > 0){
            move(ans, a, 0,0, 0, 1);
        }
        while(a[1][1].chips.size() > 0){
            move(ans, a, 1,1, 1, 0);
        }
        for (int i = 1; i < m; i++) {
            while(a[0][i].chips.size() > 0){
                if(a[0][i].chips.peek() == 0)
                    move(ans, a, 0, i, 0, 0);
                else
                    move(ans, a, 0,i, 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if(i==1) continue;
            while(a[1][i].chips.size() > 0){
                if(a[1][i].chips.peek() == 0)
                    move(ans, a, 1, i, 0, i);
                else
                    move(ans, a, 1,i, 1, 1);
            }
        }
        for (int i = 1; i < m; i++) {
            while(a[0][i].chips.size() > 0){
                if(a[0][i].chips.peek() == 0)
                    move(ans, a, 0, i, 0, 0);
                else
                    throw new RuntimeException();
            }
        }

        //todo:
        while(a[0][1].chips.size() > 0){
            if(a[0][1].chips.peek() == 0)
                move(ans, a, 0,1, 0, 0);
            else
                move(ans, a, 0,1, 1, 1);
        }

        while(a[1][0].chips.size() > 0){
            if(a[1][0].chips.peek() == 0)
                move(ans, a, 1,0, 0, 0);
            else
                move(ans, a, 1,0, 1, 1);
        }

    }
}
