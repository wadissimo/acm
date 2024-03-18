package codeforces.r239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 */
public class C {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Math.max(a,b);
        List<Pair> al = new ArrayList<Pair>();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                double r = Math.sqrt(i * i + j * j);
                if(Math.abs(r - a) < 0.0000001) {
                    al.add(new Pair(i,j));
                }
            }
        }
        boolean found = false;
        for (Pair ac : al) {
            double bx = (ac.y*b*1.0)/a;
            double by = (ac.x*b*1.0)/a;
            if(Math.abs(Math.round(bx) - bx) < 0.0000001 && Math.abs(Math.round(by) - by) < 0.0000001) {
                if(Math.round(by)!= ac.y) {
                    found = true;
                    System.out.println("YES");
                    System.out.println("0 0");
                    System.out.println(ac.x + " " + ac.y);
                    System.out.println("-" + Math.round(bx) + " " + Math.round(by));
                    break;
                }
            }
        }
        if(!found) {
            System.out.println("NO");
        }
    }
}
