package codeforces.r515;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class TaskF {
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void addPoint(ArrayList<Integer>[] points, int idx, int coord){
        if(points[idx] == null)
            points[idx] = new ArrayList<>();
        points[idx].add(coord);
    }
    static long getDist(Point p1, Point p2){
        return abs(p1.x-p2.x)+abs(p1.y-p2.y);
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        Point[] points = new Point[n];
        TreeMap<Integer, Integer> coords = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.ni();int y = in.ni();
            coords.put(max(x,y), 0);
            points[i] = new Point(x, y);
        }
        int max_level = coords.size();
        int []levels = new int[max_level+1];
        int level = 1;
        for (Integer coord : coords.keySet()) {
            coords.put(coord, level);
            levels[level++] = coord;
        }
        ArrayList<Integer>[] ypoints = new ArrayList[max_level+1];
        ArrayList<Integer>[] xpoints = new ArrayList[max_level+1];
        for (int i = 0; i < max_level+1; i++) {
            ypoints[i] = new ArrayList<>();
            xpoints[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            Point p = points[i];
            if(p.x >= p.y){
                xpoints[coords.get(p.x)].add(p.y);
            } else {
                ypoints[coords.get(p.y)].add(p.x);
            }
        }
        for (int i = 0; i < max_level+1; i++) {
            if(!xpoints[i].isEmpty())
                Collections.sort(xpoints[i]);
            if(!ypoints[i].isEmpty())
                Collections.sort(ypoints[i]);
        }
        long[] levelDist = new long[max_level+1];
        Point[][] levelPoints = new Point[max_level+1][2];
        levelPoints[0][0] = levelPoints[0][1] = new Point(0,0);
        for (int i = 1; i < max_level+1; i++) {
            long dist = 0;
            if(!xpoints[i].isEmpty()){
                int maxy = xpoints[i].get(xpoints[i].size() - 1);
                dist = maxy - xpoints[i].get(0);
                levelPoints[i][0] = new Point(levels[i], xpoints[i].get(0)); //min point
                levelPoints[i][1] = new Point(levels[i], maxy);
            }
            if(!ypoints[i].isEmpty()){
                int maxx = ypoints[i].get(ypoints[i].size() - 1);
                dist += maxx - ypoints[i].get(0);
                if(xpoints[i].isEmpty()){
                    levelPoints[i][0] = new Point(maxx, levels[i]);
                    levelPoints[i][1] = new Point(ypoints[i].get(0), levels[i]);
                }else{
                    dist += getDist(levelPoints[i][1], new Point(ypoints[i].get(ypoints[i].size()-1), levels[i]));
                    levelPoints[i][1] = new Point(ypoints[i].get(0), levels[i]);
                }
            }
            levelDist[i] = dist;
        }
        long d[][] = new long[max_level+1][2];
        int prevLevel = 0;
        for (level = 1; level < max_level+1; level++) {
            assert levelPoints[level][0] != null;
            assert levelPoints[level][1] != null;
            assert levelPoints[prevLevel][0] != null;
            assert levelPoints[prevLevel][1] != null;
            d[level][0] += min(d[prevLevel][0] + getDist(levelPoints[level][1], levelPoints[prevLevel][0]), d[prevLevel][1] + getDist(levelPoints[level][1], levelPoints[prevLevel][1]))+levelDist[level];
            d[level][1] += min(d[prevLevel][0] + getDist(levelPoints[level][0], levelPoints[prevLevel][0]), d[prevLevel][1] + getDist(levelPoints[level][0], levelPoints[prevLevel][1]))+levelDist[level];
            prevLevel = level;
        }

        out.println(min(d[prevLevel][0], d[prevLevel][1]));
    }
}
