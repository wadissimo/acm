package codeforces.r499;

import chelper.io.InputReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;

import static java.lang.Math.*;

public class TaskE {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int xm = in.ni();
        int ym = in.ni();
        int zm = in.ni();
        int n = in.ni();
        int m = in.ni();
        int k = in.ni();
        int[][] open = new int[n][3];
        for (int i = 0; i < n; i++) {
            open[i][0]= in.ni();
            open[i][1]= in.ni();
            open[i][2]= in.ni();
        }
        int[][] closed = new int[m][3];
        for (int i = 0; i < m; i++) {
            closed[i][0]= in.ni();
            closed[i][1]= in.ni();
            closed[i][2]= in.ni();
        }
        int[][] req = new int[k][3];
        for (int i = 0; i < k; i++) {
            req[i][0]= in.ni();
            req[i][1]= in.ni();
            req[i][2]= in.ni();
        }
        int xmax = 0;
        int xmin=1000000;
        int ymax=0;
        int ymin=1000000;
        int zmax=0;
        int zmin=1000000;
        for (int i = 0; i < n; i++) {
            xmax= max(xmax, open[i][0]);
            xmin= min(xmin, open[i][0]);
            ymax= max(ymax, open[i][1]);
            ymin= min(ymin, open[i][1]);
            zmax= max(zmax, open[i][2]);
            zmin= min(zmin, open[i][2]);
        }
        int cxmax = 0;
        int cxmin=1000000;
        int cymax=0;
        int cymin=1000000;
        int czmax=0;
        int czmin=1000000;
        boolean invalid = false;
        for (int i = 0; i < m; i++) {
            if (closed[i][0]<=xmax && closed[i][0]>=xmin && closed[i][1]<=ymax && closed[i][1]>=ymin &&
                    closed[i][2]<=zmax && closed[i][2]>=zmin) {
                invalid = true;
                break;
            }

        }

    }
}
