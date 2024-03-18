package codeforces.r522;

import chelper.io.FastScanner;
import java.io.PrintWriter;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class D {
    class Point {
        double x,y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        double dist(Point p){
            return Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
        }
    }
    double DELTA = 1e-10;
    class Segment{
        Point from, to;

        public Segment(Point from, Point to) {
            this.from = from;
            this.to = to;
        }

        Point intersect(double a, double b, double c){
            if(abs(from.x - to.x) < DELTA){ // vertical
                double y = (-a*from.x - c)/b;
                if(max(from.y, to.y)-y > -DELTA && y-min(from.y, to.y) > -DELTA){
                    return new Point(from.x, y);
                }
            } else if(abs(from.y - to.y) < DELTA){
                double x = (-b*from.y - c)/a;
                if(max(from.x, to.x)-x > -DELTA && x-min(from.x, to.x) > -DELTA){
                    return new Point(x, from.y);
                }
            }
            return null;
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int a = in.ni(); int b = in.ni(); int c = in.ni();
        Point from = new Point(in.ni(), in.ni());
        Point to = new Point(in.ni(), in.ni());
        if(from.x == to.x || from.y == to.y){
            out.println(abs(from.x - to.x)+ abs(from.y-to.y));
            return;
        }
        if(from.x > to.x){ // from ----> to
            Point t = from;from = to;to = t;
        }
        // ****h2***B
        // *        *
        // v1       v2
        // *        *
        // A***h1****
        Point v1 = new Segment(from, new Point(from.x, to.y)).intersect(a, b, c);
        Point h1 = new Segment(from, new Point(to.x, from.y)).intersect(a, b, c);
        Point v2 = new Segment(new Point(to.x, from.y), to).intersect(a, b, c);
        Point h2 = new Segment(new Point(from.x, to.y), to).intersect(a, b, c);
        double ans = abs(to.x-from.x)+abs(to.y-from.y);
        if(v1 != null){
            if(h2 != null){
                ans = abs(v1.y-from.y) + abs(to.x-h2.x) + v1.dist(h2);
            } else if(v2 != null && abs(to.y-v2.y) < abs(to.y-v1.y)){
                ans = abs(v1.y-from.y) + abs(v2.y-to.y) + v1.dist(v2);
            }
        } else if(h1 != null){
            if(v2 != null){
                ans = abs(h1.x-from.x) + abs(to.y-v2.y) + h1.dist(v2);
            } else if(h2 != null && abs(to.x-h2.x) < abs(to.x-h1.x)){
                ans = abs(h1.x-from.x) + abs(h2.x-to.x) + h1.dist(h2);
            }
        }
        out.println(ans);
    }
}
