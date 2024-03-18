package codeforces.ecr60;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    long dist;
    int xt;
    int yt;
    int n;String s;
    long x;
    long y;
    long getDist(long steps){
        dist = Math.abs(x-xt) + Math.abs(y-yt);
        if(dist <= steps)
            return steps;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c=='U')
                y++;
            else if(c=='D')
                y--;
            else if(c=='L')
                x--;
            else
                x++;
            dist = Math.abs(x-xt) + Math.abs(y-yt);
            if(dist <= i+1+steps)
                return i+1+steps;
        }
        return -1;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int xs = in.ni(), ys = in.ni();
        xt = in.ni();
        yt = in.ni();
        n = in.ni();
        s = in.ns();

        x = xs;
        y = ys;

        long res = getDist(0);
        if(res != -1){
            out.println(res);
        }else{
            long total = Math.abs(xt-xs) + Math.abs(yt-ys);
            if(dist-n >= total)
                out.println(-1);
            else{
                long deltax = x-xs, deltay = y-ys;
                long deltaDist = total - dist;
                //deltaDist*cnt + n*cnt>=total
                long left = 0;
                long right = 4_000_000_000L ;
                long ans = Long.MAX_VALUE;
                while(left < right){
                    long mid = (left+right)/2;
                    x = xs + deltax*mid;
                    y = ys + deltay*mid;
                    res = getDist(n*mid);
                    if(res == -1){
                        left = mid + 1;
                    } else{
                        ans = Math.min(ans, res);
                        right = mid;
                    }
                }
                if(ans == Long.MAX_VALUE)
                    out.println(-1);
                else
                    out.println(ans);
            }
        }
    }
}
