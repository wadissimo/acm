package codeforces.g1;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int q = in.ni();
        for (int i = 0; i < q; i++) {
            int n = in.ni();
            int msk = (1<<Integer.numberOfTrailingZeros(Integer.highestOneBit(n))+1)-1;
            if((msk&n) == msk){
                boolean found = false;
                for (int div = 2; div*div <= n; div++) {
                    if(n%div == 0){
                        out.println(n/div);
                        found = true;
                        break;
                    }
                }
                if(!found)
                    out.println(1);
            } else {
                out.println(msk);
            }
        }
    }
}
