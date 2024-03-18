import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author wadissimo
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        void reverse(int[] a, int from, int to) {
            int left = from, right = to;
            while (left < right) {
                int tmp = a[right];
                a[right] = a[left];
                a[left] = tmp;
                left++;
                right--;
            }
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int T = in.ni();
            for (int t = 0; t < T; t++) {
                int n = in.ni();
                int c = in.ni();
                int c_orig = c;
                if (c < n - 1 || c > (n * (n + 1) / 2 - 1)) {
                    out.printf("Case #%d: IMPOSSIBLE%n", t + 1);
                    continue;
                }
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = i + 1;
                }
                c -= n - 1;
                int from = 0;
                int to = n - 1;
                int left = n - 1;
                int idx = 0;
                int j = 0;
                while (c > 0) {
                    if (c <= to - from) {
                        reverse(a, from, from + c);
                        break;
                    } else {
                        reverse(a, from, to);
                        c -= to - from;
                        if (j % 2 == 0) {
                            to--;
                        } else {
                            from++;
                        }
                    }
                    j++;
                }
            /*if(test(a) != c_orig){
                System.out.println("wrong answer");
                return;
            }*/
                out.printf("Case #%d:", t + 1);
                for (int i = 0; i < n; i++) {
                    out.print(" " + a[i]);
                }
                out.println();

            }

        }

    }

    static class FastScanner {
        public BufferedReader in;
        public StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String ns() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int ni() {
            return Integer.parseInt(ns());
        }

    }
}

