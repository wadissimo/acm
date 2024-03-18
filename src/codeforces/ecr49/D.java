package codeforces.ecr49;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(reader.readLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m[] = new int[n];
        Set<Integer> loops = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if(m[i] == 0) {
                int cur = i;
                int mark = i+1;
                while(m[cur] == 0){
                    m[cur] = mark;
                    cur = a[cur]-1;
                }
                if (m[cur] == mark) {
                    loops.add(cur);
                }
            }
        }
        m = new int[n];
        long ans = 0;
        for (Integer loop : loops) {
            if(m[loop] == 0) {
                int cur = loop;
                int min = Integer.MAX_VALUE;
                while (m[cur] == 0) {
                    m[cur] = 1;
                    min = Math.min(min, c[cur]);
                    cur = a[cur]-1;
                }
                ans += min;
            }
        }
        System.out.println(ans);
    }
}
