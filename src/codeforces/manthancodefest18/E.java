package codeforces.manthancodefest18;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class E {
    static Set<Integer>[] g;
    static int k;
    static Set<Integer> s;
    static int[] degree;
    static void remove(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while (!q.isEmpty()){
            v = q.poll();
            for (int u : g[v]) {
                if (s.contains(u)) {
                    degree[u]--;
                    if (degree[u] < k) {
                        q.add(u);
                    }
                }
            }
            s.remove(v);
        }
    }
    static class Pair{
        int degree;
        int node;

        public Pair(int degree, int node) {
            this.degree = degree;
            this.node = node;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = new HashSet<>(2*m);
        g = new Set[n];
        degree = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        int[][] f = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            g[a].add(b);
            g[b].add(a);
            degree[a]++;
            degree[b]++;
            s.add(a);s.add(b);
            f[i][0] = a;
            f[i][1] = b;
        }
        SortedSet<Pair> ss = new TreeSet<>(Comparator.comparingInt(p -> p.degree));
        for (int i = 0; i < n; i++) {
            ss.add(new Pair(degree[i], i));
        }
        for (int i = 0; i < n; i++) {
            if(s.contains(i) && degree[i] < k) {
                remove(i);
            }
        }
        int[] ans = new int[m];
        for (int i = m-1; i >=0; i--) {
            ans[i] = s.size();
            int a = f[i][0];
            int b = f[i][1];
            if(s.contains(a) && s.contains(b)) {
                if(degree[a]-1<k) {
                    degree[a]--;
                    remove(a);
                } else {
                    degree[b]--;
                    if(degree[b]<k)
                        remove(b);
                    else
                        degree[a]--;
                }
            }

        }
        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }

    }
}
