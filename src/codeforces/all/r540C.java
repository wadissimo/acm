package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class r540C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n * n);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n * n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        int[][] m = new int[n][n];
        if (n % 2 == 1) {
            for (Integer num : map.keySet()) {
                Integer cnt = map.get(num);
                if (cnt % 2 == 1) {
                    m[n / 2][n / 2] = num;
                    map.put(num, cnt - 1);
                    break;
                }
            }
            for (Integer num : map.keySet()) {
                Integer cnt = map.get(num);
                if (cnt % 4 == 2) {
                    for (int i = 0; i < n; i++) {
                        if (m[i][n / 2] == 0) {
                            m[n - i - 1][n / 2] = m[i][n / 2] = num;
                            map.put(num, cnt - 2);
                            break;
                        }
                        if (m[n / 2][i] == 0) {
                            m[n / 2][i] = m[n / 2][n - i - 1] = num;
                            map.put(num, cnt - 2);
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (m[i][n / 2] == 0) {
                    for (Integer num : map.keySet()) {
                        Integer cnt = map.get(num);
                        if (cnt != 0 && cnt % 2 == 0) {
                            m[n - i - 1][n / 2] = m[i][n / 2] = num;
                            map.put(num, cnt - 2);
                            break;
                        }
                    }
                }
                if (m[n / 2][i] == 0) {
                    for (Integer num : map.keySet()) {
                        Integer cnt = map.get(num);
                        if (cnt != 0 && cnt % 2 == 0) {
                            m[n / 2][i] = m[n / 2][n - i - 1] = num;
                            map.put(num, cnt - 2);
                            break;
                        }
                    }
                }
            }

        }
        for (Integer num : map.keySet()) {
            Integer cnt = map.get(num);
            if (cnt == 0)
                continue;
            if (cnt % 4 != 0) {
                out.println("NO");
                return;
            }
            for (int i = 0; i < cnt; i += 4) {
                boolean found = false;
                for (int j = 0; j < n && !found; j++) {
                    for (int k = 0; k < n; k++) {
                        if (m[j][k] == 0) {
                            m[n - j - 1][n - k - 1] = m[j][n - k - 1] = m[n - j - 1][k] = m[j][k] = num;
                            found = true;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 0) {
                    out.println("NO");
                    return;
                }
            }
        }
        out.println("YES");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(m[i][j] + " ");
            }
            out.println();
        }
    }
}
