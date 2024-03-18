package codeforces.r244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 */
public class C {
    static int time;
    static List<Integer>[] graph;
    static int[] lowlink;
    static boolean[] used;
    static List<Integer> stack;
    static List<List<Integer>> components;

    static List<List<Integer>> scc(List<Integer>[] g) {
        graph = g;
        int n = graph.length;
        lowlink = new int[n];
        used = new boolean[n];
        stack = new ArrayList<Integer>();
        components = new ArrayList<List<Integer>>();

        for (int u = 0; u < n; u++)
            if (!used[u])
                dfs(u);

        return components;
    }

    static void dfs(int u) {
        lowlink[u] = time++;
        used[u] = true;
        stack.add(u);
        boolean isComponentRoot = true;

        for (int v : graph[u]) {
            if (!used[v])
                dfs(v);
            if (lowlink[u] > lowlink[v]) {
                lowlink[u] = lowlink[v];
                isComponentRoot = false;
            }
        }

        if (isComponentRoot) {
            List<Integer> component = new ArrayList<Integer>();
            while (true) {
                int k = stack.remove(stack.size() - 1);
                component.add(k);
                lowlink[k] = Integer.MAX_VALUE;
                if (k == u)
                    break;
            }
            components.add(component);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] price = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a - 1].add(b-1);
        }
        List<List<Integer>> components = scc(g);
        long sum = 0;
        long variants = 1;
        for (List<Integer> component : components) {
            long minP = Integer.MAX_VALUE;
            int variants1 = 0;
            for (Integer inter : component) {
                minP = Math.min(minP, price[inter]);
            }
            for (Integer inter : component) {
                if(price[inter] == minP) {
                    variants1 ++;
                }
            }
            variants = (variants*variants1)%1000000007 ;
            sum+= minP;
        }
        //System.out.println(components);
        System.out.println(sum + " " + variants);


    }
}
