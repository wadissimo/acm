package codeforces.all;

import chelper.io.FastScanner;
import common.StringUtil;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class r30E {
    class Pair{
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int n = s.length();

        String sp = s + new StringBuilder().append(s).reverse();
        int logN = 0;
        int spn = 2*n;
//        System.out.println("spn = " + spn);
        while ((1<<logN) < spn) {
            logN++;
        }
//        System.out.println("logN = " + logN);
        String ps = new StringBuilder().append(s).reverse() + s;
        int[] z = StringUtil.z(ps);
        int[] best = new int[n];
        int[] bestIdx = new int[n];
        Arrays.fill(bestIdx, -1);
        Deque<Pair> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while(!dq.isEmpty() && dq.peekLast().a + dq.peekLast().b - 1 < i){
                dq.pollLast();
            }
            if(z[i+n] != 0){
                dq.addFirst(new Pair(i, z[i+n]));
            }
            if(!dq.isEmpty() && (i ==0 || i - dq.peekLast().a+1 > best[i-1])){
                best[i] = i - dq.peekLast().a+1;
                bestIdx[i] = dq.peekLast().a;
            }else if(i != 0){
                best[i] = best[i-1];
                bestIdx[i] = bestIdx[i-1];
            }

        }
        int[] p = new int[spn];
        int[][] c = StringUtil.lcpArray(sp, logN, p);
        int bestAns = 0;
        int bestMidFrom = 0;
        int bestMidLen = 0;
        int rightLen = -1;
        int leftStart = -1;
        for (int i = 0; i < n; i++) {
            int len = StringUtil.lcp(i, 2 * n - i - 1, logN, 2*n, c);

            int left = i - len+1;
            int right = i + len-1;
            if(left <= 0 || right >= n-1 || best[left-1] == 0){
                len = Math.min(len, i+1);
                len = Math.min(len, n-i);
                left = i-len+1;
                len = len*2-1;
                if(len > bestAns){
//                    System.out.println("i = " + i);
//                    System.out.println("len = " + len);
                    bestAns = len;
                    bestMidFrom = left; bestMidLen = len;
                    rightLen = leftStart = -1;
                }
            } else {
                int leftLen = best[left-1];
                leftLen = Math.min(leftLen, n-1-right);
                if(leftLen*2 + 2*len-1 > bestAns){
                    bestAns = leftLen*2 + 2*len-1;
                    bestMidFrom = left; bestMidLen = len*2 - 1;
                    rightLen = leftLen;
                    leftStart = bestIdx[left-1];
                }
            }

        }
        if(rightLen == -1){
            out.println(1);
            out.println((bestMidFrom+1) + " " + bestMidLen);
        } else {
            out.println(3);
            out.println((leftStart+1) + " " + rightLen);
            out.println((bestMidFrom+1) + " " + bestMidLen);
            out.println((n-rightLen+1) + " " + rightLen);
        }
    }
}
