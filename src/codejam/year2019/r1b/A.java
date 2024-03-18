package codejam.year2019.r1b;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class A {
    class Person{
        int x, y;
        char dir;

        public Person(int x, int y, char dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            ArrayList<Person> N = new ArrayList<>();
            ArrayList<Person> S = new ArrayList<>();
            ArrayList<Person> E = new ArrayList<>();
            ArrayList<Person> W = new ArrayList<>();
            int p = in.ni(), q = in.ni();
            int[] n = new int[q+1];
            int[] s = new int[q+1];
            int[] e = new int[q+1];
            int[] w = new int[q+1];
            for (int i = 0; i < p; i++) {
                int x = in.ni(), y = in.ni();
                char c = in.ns().charAt(0);
                if(c == 'N') {
                    if(y < q)
                        n[y+1]++;
                    N.add(new Person(x, y, c));
                }else if(c == 'S') {
                    if(y > 0)
                        s[y-1]++;
                    S.add(new Person(x, y, c));
                }else if(c == 'E') {
                    if(x < q)
                        e[x+1]++;
                    E.add(new Person(x, y, c));
                }else if(c == 'W')
                    if(x > 0)
                        w[x-1]++;
                    W.add(new Person(x,y,c));
            }
            int[] vCnt = new int[q+1];
            int[] hCnt = new int[q+1];
            for (int i = 1; i <=q; i++) {
                vCnt[i] = vCnt[i-1]+n[i];
            }
            int cur = 0;
            for(int i = q-1; i >= 0; i--){
                cur += s[i];
                vCnt[i] += cur;
            }
            for (int i = 1; i <=q; i++) {
                hCnt[i] = hCnt[i-1]+e[i];
            }
            cur = 0;
            for(int i = q-1; i >= 0; i--){
                cur += w[i];
                hCnt[i] += cur;
            }
            int maxV = 0;
            int vInd = 0;
            for (int i = 0; i <=q; i++) {
                if(vCnt[i] > maxV){
                    maxV = vCnt[i];
                    vInd = i;
                }
            }
            int maxH = 0;
            int hInd = 0;
            for (int i = 0; i <=q; i++) {
                if(hCnt[i] > maxH){
                    maxH = hCnt[i];
                    hInd = i;
                }
            }
            out.printf("Case #%d: %d %d%n", t+1, hInd, vInd);
        }

    }
}
