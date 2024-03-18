package codeforces.codefest18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class E {
    static LinkedList<Pair>[] g;
    static int k;
    static boolean[] s;
    static int size;
    static int[] degree;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = new boolean[n];
        g = new LinkedList[n];
        degree = new int[n];
        int[][] f = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if (g[a] == null) {
                g[a] = new LinkedList<>();
            }
            if (g[b] == null) {
                g[b] = new LinkedList<>();
            }
            g[a].add(new Pair(b,i));
            g[b].add(new Pair(a,i));
            degree[a]++;degree[b]++;
            f[i][0] = a;
            f[i][1] = b;
        }
        for (int i = 0; i < n; i++) {
            if(degree[i]>0){
                if(degree[i]>=k){
                    s[i] = true;
                    size ++;
                }else{
                    q.add(i);
                }
            }
        }

        while (!q.isEmpty()){
            int v = q.poll();
            for (Pair u : g[v]) {
                if(s[u.a]) {
                    degree[u.a]--;
                    if (degree[u.a] < k) {
                        q.add(u.a);
                        s[u.a] = false;
                        size--;
                    }
                }
            }
        }
        int[] ans = new int[m];
        for (int i = m-1; i >=0; i--) {
            ans[i] = size;
            int a = f[i][0];
            int b = f[i][1];
            if(s[a] && s[b]) {
                degree[a]--;degree[b]--;
                if (degree[a] < k){
                    q.add(a);
                    s[a] = false;
                    size--;
                }
                if (degree[b] < k){
                    q.add(b);
                    s[b] = false;
                    size--;
                }
                while (!q.isEmpty()){
                    int v = q.poll();
                    for (Pair u : g[v]) {
                        if(u.b < i && s[u.a]) {
                            degree[u.a]--;
                            if (degree[u.a] < k) {
                                q.add(u.a);
                                s[u.a] = false;
                                size--;
                            }
                        }
                    }

                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }

    }
    static class Pair{
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
