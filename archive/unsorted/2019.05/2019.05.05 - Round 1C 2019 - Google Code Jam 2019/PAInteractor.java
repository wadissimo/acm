package main;

import chelper.io.FastScanner;
import net.egork.chelper.tester.Interactor;
import net.egork.chelper.tester.Verdict;
import net.egork.chelper.tester.State;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class PAInteractor extends Interactor {
    class Permutation {
        char[] p;

        public Permutation(char[] pp) {
            p = Arrays.copyOf(pp, pp.length);
        }
    }
    int idx = 0;
    Permutation [] ps;
    void generate(int k, char[] a){
        if(k == 1){
            ps[idx++] = new Permutation(a);
        } else {
            generate(k-1, a);
            for (int i = 0; i < k - 1; i++) {
                if(k%2 == 0){
                    char t = a[i];a[i] = a[k-1];a[k-1] = t;
                } else {
                    char t = a[0]; a[0] = a[k-1]; a[k-1] = t;
                }
                generate(k-1, a);
            }
        }
    }

    public Verdict interact(InputStream input, InputStream solutionOutput, OutputStream solutionInput, State<Boolean> state) {
        FastScanner in = new FastScanner(solutionOutput);
        PrintWriter out = new PrintWriter(solutionInput);
        ps = new Permutation[120];
        char[] p = new char[]{'A', 'B', 'C', 'D', 'E'};
        generate(5, p);
        Random rand = new Random();
        for (int i = 0; i < 120; i++) {
            int x = rand.nextInt(120);
            Permutation tmp = ps[i];
            ps[i] = ps[x];
            ps[x] = tmp;
        }
        System.out.println("ps[199] = " + new String(ps[119].p));
        out.println("1 150");
        out.flush();
        for (int f = 0; f < 150; f++) {
            String s = in.ns();
            if(s.charAt(0) >= 'A'){
                boolean correct = true;
                for (int i = 0; i < 5; i++) {
                    if(s.charAt(i) != ps[119].p[i])
                        correct = false;
                }
                if(correct) {
                    out.println("Y");
                    out.flush();
                    return Verdict.OK;
                }else {
                    out.println("N");
                    out.flush();
                    return Verdict.WA;
                }
            } else {
                int n = Integer.parseInt(s);
                char res = ps[n/5].p[n%5];
                out.println(res);
                out.flush();
            }
        }

        return Verdict.UNDECIDED;
    }
}
