package codeforces.r514;

import chelper.io.FastScanner;
import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskD {
    Point[] points;
        long MAX = 12345678;
        double DELTA = 1e-10;

        double minRad(double cx, double maxRad) {
            double minRad = 0;
            double limit = maxRad;
            maxRad *= 2.0;
            int cnt = 0;
            while (Math.abs(minRad - maxRad) > DELTA * Math.max(1, maxRad) && minRad < limit) {
                cnt++;
                double mid = (minRad + maxRad) / 2.0;
                double mid2 = mid * mid;
                boolean tooSmall = false;
                for (int i = 0; i < points.length; i++) {
                    if ((cx - points[i].x) * (cx - points[i].x) + (mid - points[i].y) * (mid - points[i].y) > mid2) {
                        tooSmall = true;
                        break;
                    }
                }
                if (tooSmall) {
                    minRad = mid + 1e-8;
                } else {
                    maxRad = mid;
                }
            }
            //System.out.println("cnt = " + cnt);
            return minRad;
        }

        double findRad(double cx) {
            double maxc = 0.0;
            for (int i = 0; i < points.length; i++) {
                double midx = (cx + points[i].x) / 2.0;
                double midy = (points[i].y) / 2.0;
                double px = midx + points[i].y - midy;
                double py = midy + midx - points[i].x;
                Line l = new Line(midx, midy, px, py);
                double c = (-l.a * cx - l.c) / l.b;
                maxc = Math.max(c, maxc);
            }
            return maxc;
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.ni();
            int cntNeg = 0;
            int cntPos = 0;
            int cnt0 = 0;
            long minX = MAX;
            long maxX = -MAX;

            points = new Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new Point(in.ni(), in.ni());
                minX = Math.min(points[i].x, minX);
                maxX = Math.max(points[i].x, maxX);
                if (points[i].y > 0)
                    cntPos++;
                else if (points[i].y < 0)
                    cntNeg++;
                else
                    cnt0++;
            }
            if (cnt0 > 1 || cntNeg > 0 && cntPos > 0) {
                out.println(-1);
                return;
            }
            if (cntNeg > 0) {
                for (int i = 0; i < n; i++) {
                    points[i].y *= -1;
                }
            }
            long minY = MAX;
            long maxY = -MAX;
            for (int i = 0; i < n; i++) {
                minY = Math.min(points[i].y, minY);
                maxY = Math.max(points[i].y, maxY);
            }
            double l = minX;
            double r = maxX;
            while (r - l > DELTA) {
                double m1 = l + (r - l) / 3.0;
                double m2 = r - (r - l) / 3.0;
                if (findRad(m1) > findRad(m2)) {
                    l = m1;
                } else {
                    r = m2;
                }
            }
            out.printf("%f%n", findRad(l));

        }

        class Point {
            long x;
            long y;

            public Point(long x, long y) {
                this.x = x;
                this.y = y;
            }

        }

        class Line {
            double a;
            double b;
            double c;

            public Line(double px, double py, double qx, double qy) {
                a = py - qy;
                b = qx - px;
                c = -a * px - b * py;
            }

        }

}
