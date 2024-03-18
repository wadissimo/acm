package codeforces.r528;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class C {
    class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        Point[] ps = new Point[3];
        for (int i = 0; i < 3; i++) {
            ps[i] = new Point(in.ni(), in.ni());
        }
        Arrays.sort(ps, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });
        Point a = ps[0];
        Point b = ps[1];
        Point c = ps[2];
        if(b.x == c.x){
            if(Math.abs(b.y-a.y) > Math.abs(c.y-a.y)){
                Point t = b;
                b = c;
                c = t;
            }
        }

        LinkedList<Point> ans = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            ans.add(ps[i]);
        }
        if(a.x < b.x){
            for (int x = a.x+1; x < b.x ; x++) {
                ans.add(new Point(x, a.y));
            }
            if(a.y != b.y){
                ans.add(new Point(b.x, a.y));
            }
        }
        if(a.y != b.y){
            int d = (b.y > a.y) ? 1:-1;
            for (int y = a.y+d; y != b.y; y+=d) {
                ans.add(new Point(b.x, y));
            }
        }
        if(c.x > b.x){
            for (int x = b.x+1; x < c.x ; x++) {
                ans.add(new Point(x, c.y));
            }
        }
        if(c.y > Math.max(a.y, b.y)){
            for (int y = Math.max(a.y, b.y) + 1; y < c.y ; y++) {
                ans.add(new Point(b.x, y));
            }
            if(c.x != b.x)
                ans.add(new Point(b.x, c.y));
        } else if(c.y < Math.min(a.y, b.y)){
            for (int y = c.y + 1; y < Math.min(a.y, b.y); y++) {
                ans.add(new Point(b.x, y));
            }
            if(c.x != b.x)
                ans.add(new Point(b.x, c.y));
        }
        out.println(ans.size());
        for (Point point : ans) {
            out.printf("%d %d%n", point.x, point.y);
        }

    }
}
