package codeforces.aimtech5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {
    static class Point{
        long x,y;
        Point(long x, long y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    static final double PRECISION = 0.0000000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int q = Integer.parseInt(st.nextToken());
        HashMap<Long, Set<Point>> d = new HashMap<>();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(reader.readLine());
            int t = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            if (t==1){
                long r = x*x+y*y;
                Set<Point> points = d.computeIfAbsent(r, k -> new HashSet<>());
                points.add(new Point(x,y));
            } else if (t == 2){
                long r = x*x+y*y;
                d.get(r).remove(new Point(x,y));
            } else {
                int ans = 0;
                double bx = x;
                double by = y;
                double rb = bx*bx + by*by;
                for (Set<Point> points : d.values()) {
                    for (Point p : points) {
                        double ax = p.x;
                        double ay = p.y;
                        double ps = 2.0*(ax*bx+ay*by)/rb;
                        double rx = ps*bx-ax;
                        double ry = ps*by-ay;
                        if (Math.abs(rx-Math.floor(rx)) > PRECISION ||
                                Math.abs(ry-Math.floor(ry)) > PRECISION ){
                            ans ++;
                        } else {
                            long rxi = Math.round(rx);
                            long ryi = Math.round(ry);
                            if ((rxi != ax || ryi != ay) && !points.contains(new Point(rxi,ryi))) {
                                ans ++;
                            }
                        }
                    }
                }
                System.out.println(ans);
            }
        }
    }
}
