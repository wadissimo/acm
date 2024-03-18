package facebook.hackercup.year2017.r1;

import java.io.*;
import java.util.*;

/**
 * Created by Vadimka on 14.01.2017.
 */
public class B {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("c:/DEV/acm/tests/facebook/year2017/r1/fighting_the_zombies.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2017/r1/fighting_the_zombies_out.txt"));

        int t = Integer.parseInt(r.readLine()); // number of cycles
        long t1 = System.currentTimeMillis();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            Point[] points = new Point[n];
            TreeMap<Integer, Integer> xs = new TreeMap<>();
            TreeMap<Integer, Integer> ys = new TreeMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(r.readLine());
                int xi = Integer.parseInt(st.nextToken());
                int yi = Integer.parseInt(st.nextToken());
                points[j] = new Point(xi,yi);
                xs.put(xi, 0);
                ys.put(yi, 0);
            }
            int xx[] = new int[xs.size()];
            int yy[] = new int[ys.size()];
            int ii = 0;
            for (Map.Entry<Integer, Integer> e : xs.entrySet()){
                xx[ii] = e.getKey();
                e.setValue(ii);
                ii++;
            }
            ii = 0;
            for (Map.Entry<Integer, Integer> e : ys.entrySet()){
                yy[ii] = e.getKey();
                e.setValue(ii);
                ii++;
            }

            int ans = 0;
            for (int ali = 0; ali < xx.length; ali++) {
                for (int abi = 0; abi < yy.length; abi++) { //iterate all squares
                    int ale = xx[ali];//leftEdge
                    int are = ale + R;//rightEdge
                    //Integer ari = xs.floorEntry(are).getValue();
                    int abe = yy[abi];
                    int ate = abe + R;
                    //Integer ati = ys.floorEntry(ate).getValue();
                    ArrayList<Point> pointsOut = new ArrayList<>(n);
                    for (int j = 0; j < n; j++) {//take points which are out of a-square
                        Point p = points[j];
                        if(p.x < ale || p.x > are || p.y < abe || p.y > ate) {
                            pointsOut.add(p);
                        }
                    }
                    int countA = n - pointsOut.size(); //how many in a-square
                    //now search for the best move
                    int maxMovePoints = 0;
                    for (int bli = 0; bli < xx.length; bli++) {
                        int ble = xx[bli];//leftEdge
                        int bre = ble + R;//rightEdge
                        ArrayList<Point> pointsX = new ArrayList<>(n);
                        for (Point p : pointsOut) {
                            if(p.x >= ble && p.x <= bre) {
                                pointsX.add(p);
                            }
                        }
                        if(pointsX.size() >= maxMovePoints) {
                            for (int bbi = 0; bbi < yy.length; bbi++) {

                                int bbe = yy[bbi];
                                int bte = bbe + R;
                                //check how many is in
                                int countB = 0;
                                for (Point p : pointsX) {
                                    if (p.y >= bbe && p.y <= bte) {
                                        countB++;
                                    }
                                }
                                if (countB > maxMovePoints) {
                                    maxMovePoints = countB;
                                }
                            }
                        }
                    }
                    if(countA + maxMovePoints > ans) {
                        ans = countA + maxMovePoints;
                    }
                }
            }

            w.write("Case #" + (i+1) + ": " + ans + "\n");
//            System.out.println(ans);
            System.out.println(i);

        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        w.close();
    }
}
