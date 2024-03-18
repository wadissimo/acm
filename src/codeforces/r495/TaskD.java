package codeforces.r495;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskD {
    boolean check(int[] cnt, int w, int h, int r, int c){
        if(r>=h || c >= w || r < 0 || c < 0)
            return false;
        int [] check = new int[w+h+1];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int d = Math.abs(r-i) + Math.abs(c-j);
                check[d] ++;
            }
        }
        for (int i = 0; i < Math.min(w + h + 1, n+1); i++) {
            if(check[i] != cnt[i])
                return false;
        }
        return true;
    }
    int n;
    public void solve(int testNumber, FastScanner in, PrintWriter out) {

        n = in.ni();
        int[] cnt = new int[n+1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int a = in.ni();
            max = Math.max(max,a);
            cnt[a]++;
        }
        int minH = 0;
        for (int i = 1; i <= max; i++) {
            if(cnt[i] != i*4){
                break;
            }
            minH = i;
        }
        int r = -1, c = -1, w = -1, h = -1;
        boolean found = false;
        for (int div = 1; div*div <= n; div++) {
            if(n%div == 0){
                h = div;
                w = n/div;
                if(w < minH*2+1 || h < minH*2+1)
                    continue;
                if(max<=h){
                    c = minH;
                    r = max-c;
                    if(check(cnt, w,h,r,c)){
                        found = true;
                        break;
                    }
                    r = minH;
                    c = max-r;
                    if(check(cnt, w,h,r,c)){
                        found = true;
                        break;
                    }
                } else {
                    c = w-minH-1;
                    r = max-c;
                    if(check(cnt, w,h,r,c)){
                        found = true;
                        break;
                    }
                    r = h-minH-1;
                    c = max-r;
                    if(check(cnt, w,h,r,c)){
                        found = true;
                        break;
                    }
                }
            }
        }
        if(!found)
            out.println(-1);
        else{
            out.println(h + " " + w);
            out.println((r+1) + " " + (c+1));
        }
    }
}
