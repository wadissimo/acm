package codeforces.ecr50;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Math.*;

/**
 *
 */
public class E {
    public static final double EPS = 1e-15;
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
    private static class Segment{
        int x1,y1,x2,y2;
        double a,b,c;

        public Segment(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            a = y1-y2;
            b = x2-x1;
            c = -a*x1 - b*y1;
            //norm();
        }
        void norm() {
            double z = sqrt (a*a + b*b);
            if (abs(z) > EPS) {
                a /= z; b /= z; c /= z;
            }
        }
    }
    private static class Point{
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    private static class IPoint{
        int x,y;

        public IPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IPoint iPoint = (IPoint) o;

            if (x != iPoint.x) return false;
            return y == iPoint.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
    private static int vec(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y){
        double s = (p2x-p1x)*(p3y-p1y) - (p2y-p1y)*(p3x-p1x);
        return abs(s) < EPS ? 0: s > 0 ? 1 : -1;
    }
    private static boolean intersect1d(int xb1,int xe1, int xb2, int xe2){
        return max(min(xb1,xe1), min(xb2, xe2)) <= min(max(xb1, xe1), max(xb2, xe2));
    }
    private static double det (double a, double b, double c, double d) {
        return a * d - b * c;
    }

    private static boolean betw (double l, double r, double x) {
        return min(l,r) <= x + EPS && x <= max(l,r) + EPS;
    }
    private static Point calcIntersect(Segment s1, Segment s2){
        if (!intersect1d(s1.x1, s1.x2, s2.x1, s2.x2) ||
                !intersect1d(s1.y1, s1.y2, s2.y1, s2.y2)){
            return null;
        }
        double zn = det(s1.a, s1.b, s2.a, s2.b);
        if (abs(zn) < EPS) return null;
        double ix = -det(s1.c, s1.b, s2.c, s2.b)/zn;
        double iy = -det(s1.a, s1.c, s2.a, s2.c)/zn;
        if (betw(s1.x1, s1.x2, ix) && betw(s1.y1, s1.y2, iy) &&
                betw(s2.x1, s2.x2, ix) && betw(s2.y1, s2.y2, iy)){
            return new Point(ix, iy);
        }
        return null;
    }
    private static boolean intersect2d(int[] seg1, int[] seg2){
        return intersect1d(seg1[0], seg1[2], seg2[0], seg2[2]) &&
                intersect1d(seg1[1], seg1[3], seg2[1], seg2[3]) &&
                vec(seg1[0], seg1[1], seg1[2], seg1[3], seg2[0], seg2[1]) *
                        vec(seg1[0], seg1[1], seg1[2], seg1[3], seg2[1], seg2[2]) <= 0 &&
                vec(seg2[0], seg2[1], seg2[2], seg2[3], seg1[0], seg1[1]) *
                        vec(seg2[0], seg2[1], seg2[2], seg2[3], seg1[2], seg1[3]) <=0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        Segment[] seg = new Segment[n];
        HashSet<IPoint> intersects[] = new HashSet[n];
        for (int i = 0; i < n; i++) {
            intersects[i] = new HashSet<>();
        }
        int[] np = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            seg[i] = new Segment(x1, y1, x2, y2);
            np[i] = gcd(abs(x2-x1),abs(y2-y1))+1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                Point p = calcIntersect(seg[i], seg[j]);
                if(p != null && abs(p.x-round(p.x)) < EPS && abs(p.y-round(p.y)) < EPS){
                    IPoint ip = new IPoint((int)round(p.x), (int)round(p.y));
                    if(!intersects[i].contains(ip)) {
                        ans += 1;
                        intersects[i].add(ip);
                    }
                    intersects[j].add(ip);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ans += np[i] - intersects[i].size();
        }
        System.out.println(ans);
    }
}
