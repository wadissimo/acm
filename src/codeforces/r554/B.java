package codeforces.r554;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int x = in.ni();
        int n = Integer.numberOfTrailingZeros(Integer.highestOneBit(x));
        int target = (1<<n+1)-1;
        int t = 0;
        LinkedList<Integer> ans = new LinkedList<>();
        while(x != target){
            for (int i = n; i >= 0 ; i--) {
                if((x&(1<<i)) == 0){
                    ans.add(i+1);
                    x ^= (1<<i+1)-1;
                    break;
                }
            }
           // System.out.println("Integer.toBinaryString(x) = " + Integer.toBinaryString(x));
            t++;
            if(x == target)
                break;
            x++;
            t++;
        }
        out.println(t);
        for (Integer num : ans) {
            out.print(num + " ");
        }

    }
}
