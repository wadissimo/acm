package codeforces.ecr49;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            st = new StringTokenizer(reader.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                Integer cnt = tm.get(a);
                if(cnt == null)
                    tm.put(a, 1);
                else
                    tm.put(a, cnt +1);
            }
            int prev = 0;
            double minval = Double.MAX_VALUE;
            int ai = 0, bi = 0;
            for (Integer p : tm.keySet()) {
                int pc = tm.get(p);
                if (pc<2) continue;
                if (pc>=4) {
                    ai = bi = p;
                    break;
                }
                if (prev > 0) {
                    double val = ((double)prev)/p + ((double)p)/prev;
                    if (val < minval) {
                        minval = val;
                        ai = prev;
                        bi = p;
                    }
                }
                prev = p;
            }

            System.out.println(ai + " " + ai + " "+ bi + " " + bi);

        }
    }
}
