package codeforces.ecr53;

import chelper.io.FastScanner;
import java.io.PrintWriter;

import static java.lang.Math.*;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int tx = in.ni();int ty = in.ni();
        int[] x = new int[n+1];
        int[] y = new int[n+1];
        int cx = 0;int cy = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch(c){
                case 'U':cy++;break;
                case 'D':cy--;break;
                case 'R':cx++;break;
                case 'L':cx--;break;
            }
            x[i+1] = cx;y[i+1]=cy;
        }
        int cr = abs(tx) + abs(ty);
        if(cr %2 != n%2 || cr > n){
            out.println(-1);
            return;
        }
        int dx = tx-cx;
        int dy = ty-cy;
        int left = 0;int right = n+1;
        int ans = -1;
        while(left < right){
            int mid = (left+right)/2;
            boolean found = false;
            for (int i = 0; i < n && i+mid <=n; i++) {
                int xdist = x[i+mid]+dx-x[i];
                int ydist = y[i+mid]+dy-y[i];
                if(abs(xdist)+ abs(ydist) <= mid){
                    found = true;
                    break;
                }
            }
            if(found){
                ans = mid;
                right = mid;
            } else {
                left = mid+1;
            }
        }
        out.println(ans);
    }
}
