package facebook.hackercup.year2017.r1;

import java.io.*;
import java.util.*;

/**
 * Created by Vadimka on 15.01.2017.
 */
public class C {
    public static class Vertex implements Comparable<Vertex> {

        int id;
        int dist;
        boolean visited;
        List<Vertex> vertices;

        public Vertex(int id) {
            this.id = id;
            vertices = new ArrayList<>();
        }

        @Override
        public int compareTo(Vertex other) {
            if (dist == other.dist)
                return Integer.compare(id, other.id);
            return Integer.compare(dist, other.dist);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("c:/DEV/acm/tests/facebook/year2017/r1/manic_moving.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2017/r1/manic_moving_out.txt"));

        int t = Integer.parseInt(r.readLine()); // number of cycles
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] g = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    g[j][l] = Integer.MAX_VALUE;
                }
            }
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(r.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                if(weight < g[a-1][b-1]) {
                    g[a-1][b-1] = weight;
                    g[b-1][a-1] = weight;
                }
            }
            int[]s = new int[k];
            int[]d = new int[k];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(r.readLine());
                s[j] = Integer.parseInt(st.nextToken())-1;
                d[j] = Integer.parseInt(st.nextToken())-1;
            }
            Vertex[] graph = new Vertex[n];
            for (int j = 0; j < n; j++) {
                graph[j] = new Vertex(j);
            }
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if(g[j][l] != Integer.MAX_VALUE) {
                        graph[j].vertices.add(graph[l]);
                    }
                }
            }

            //solve
            //1. shortest paths
            int dist[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                //dijkstra
                PriorityQueue<Vertex> p = new PriorityQueue<>();
                for (Vertex v : graph) {
                    v.dist = Integer.MAX_VALUE;
                    v.visited = false;
                }
                graph[j].dist = 0;
                p.add(graph[j]);
                while(!p.isEmpty()) {
                    Vertex v = p.poll();
                    if(v.visited) continue;
                    v.visited = true;
                    for (Vertex vv : v.vertices) {
                        if(vv.dist > v.dist + g[vv.id][v.id]) {
                            vv.dist = v.dist + g[vv.id][v.id];
                            p.add(vv);
                        }
                    }
                }
                for (int l = 0; l < n; l++) {
                    dist[j][l] = graph[l].dist;
                }
            }
//            System.out.println("----------------");
//            System.out.println(i);
//            for (int j = 0; j < n; j++) {
//                for (int l = 0; l < n; l++) {
//                    if(g[j][l] == Integer.MAX_VALUE) {
//                        System.out.print("-1\t");
//                    } else {
//                        System.out.print(g[j][l] + "\t");
//                    }
//                }
//                System.out.println("");
//            }
//            System.out.println("");
//            for (int j = 0; j < n; j++) {
//                for (int l = 0; l < n; l++) {
//                    if(dist[j][l] == Integer.MAX_VALUE) {
//                        System.out.print("-1\t");
//                    } else {
//                        System.out.print(dist[j][l] + "\t");
//                    }
//                }
//                System.out.println("");
//            }
            int f[] = new int[k];
            int e[] = new int[k];
            f[0] = Integer.MAX_VALUE;
            e[0] = dist[0][s[0]];
            int ans = -1;
            if(e[0] != Integer.MAX_VALUE && dist[s[0]][d[0]] != Integer.MAX_VALUE) {
                if(k == 1) {
                    ans = e[0] + dist[s[0]][d[0]];
                }
                for (int j = 1; j < k; j++) {
                    if (dist[s[j - 1]][s[j]] == Integer.MAX_VALUE || dist[s[j - 1]][d[j]] == Integer.MAX_VALUE) {
                        break;
                    }
                    int fj1 = e[j - 1] + dist[s[j - 1]][s[j]];
                    int fj2 = Integer.MAX_VALUE;
                    if (j > 1) {
                        fj2 = f[j - 1] + dist[s[j - 1]][d[j - 2]] + dist[d[j - 2]][s[j]];
                    }
                    f[j] = Math.min(fj1, fj2);

                    int ej1 = e[j - 1] + dist[s[j - 1]][d[j - 1]] + dist[d[j - 1]][s[j]];
                    int ej2 = Integer.MAX_VALUE;
                    if (j > 1) {
                        ej2 = f[j - 1] + dist[s[j - 1]][d[j - 2]] + dist[d[j - 2]][d[j - 1]] + dist[d[j - 1]][s[j]];
                    }
                    e[j] = Math.min(ej1, ej2);
                    if(j == k-1) {
                        int ans1 = e[j] + dist[s[j]][d[j]];
                        int ans2 = f[j] + dist[s[j]][d[j-1]] + dist[d[j-1]][d[j]];
                        ans = Math.min(ans1, ans2);
                    }
                }


            }
            w.write("Case #" + (i+1) + ": " + ans + "\n");

        }
        w.close();
    }
}
