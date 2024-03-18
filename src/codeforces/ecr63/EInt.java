package codeforces.ecr63;

import chelper.io.FastScanner;
import net.egork.chelper.tester.Interactor;
import net.egork.chelper.tester.State;
import net.egork.chelper.tester.Verdict;
import net.egork.chelper.util.OutputWriter;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class EInt extends Interactor {
    long[] ans = new long[]{1000002, 0, 1, 0, 0, 0,0,0,0,0,0,0};
    long mod = 1000003;
    long calc (long x){
        long cur = ans[0];
        long curX = x;
        for (int i = 1; i < ans.length; i++) {
            cur = (cur+ans[i]*curX%mod)%mod;
            curX = x*curX%mod;
        }
        return cur;
    }
    @Override
    public Verdict interact(InputStream input, InputStream solIn, OutputStream solOut, State<Boolean> state) {
        FastScanner in = new FastScanner(solIn);
        PrintWriter out = new PrintWriter(solOut);
        int attempts = 50;
        while(attempts >= 0) {
            char c = in.ns().charAt(0);
            System.out.println("c = " + c);
            int x = in.ni();
            System.out.println("x = " + x);
            if(c == '?') {
                out.println(calc(x));
                out.flush();
            } else if(c== '!'){
                if(calc(x) == 0)
                    return Verdict.OK;
                else
                    return Verdict.WA;
            } else
                return Verdict.UNDECIDED;
            attempts--;
        }
        return Verdict.UNDECIDED;
    }
}
