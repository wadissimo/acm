package codeforces.vkr3;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class TaskC {

    private long gcd (long a, long b) {
        while (b != 0) {
            a %= b;
            long t = a;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm (long a, long b) {
        return a / gcd(a, b) * b;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int[] df = new int[n];

        for (int i = 0; i < n; i++) {
            df[i] = in.ni() - 1;
        }
        int [] cycles = new int[n];
        int [] routes = new int[n];
        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            int[] flag = new int[n];
            int x = i;
            int k = 0;
            while(flag[x] == 0) {
                flag[x] = 1;
                x = df[x];
                k++;
            }
            if(x == i) {
                cycles[i] = k;
            } else {
                routes [i] = x;
                length [i] = k;
            }
        }
        for (int i = 0; i < n; i++) {
            if(cycles[i] == 0) {
                length [i] = length [i] - cycles[routes[i]];
            }
        }

        TreeSet<Integer> numbers = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            if(cycles[i] != 0) {
                numbers.add(cycles[i]);
            }
        }
        long lcm = 1;
        for (Integer number : numbers) {
            lcm = lcm(lcm, number);
        }
        long res = lcm;
        for (int i = 0; i < n; i++) {
            if(length[i] != 0) {
                if(length[i] > res) {
                    long l = (length[i]/lcm)*lcm;
                    if(l < length[i]) {
                        l += lcm;
                    }
                    res = Math.max(l, res);
                }
            }
        }
        out.println(res);
    }
}
