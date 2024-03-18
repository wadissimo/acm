package codeforces.r541;

import chelper.io.FastScanner;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class F {
    int[] a;
    int[] b;
    List<Edge>[] g;
    boolean[] used;

    class Edge{
        int from, to;
        int time;

        public Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
    class Node{
        int v, time;

        public Node(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        a = new int[n-1];
        b = new int[n-1];
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < n-1; i++) {
            a[i] = in.ni()-1;b[i] = in.ni()-1;
            g[a[i]].add(new Edge(a[i], b[i], i));
            g[b[i]].add(new Edge(b[i], a[i], i));
        }
        used = new boolean[n];
        used[a[0]] = true;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.time, o2.time);
            }
        });
        pq.offer(new Node(a[0], 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            out.print((node.v+1)+ " ");
            for (Edge edge : g[node.v]) {
                if(!used[edge.to]){
                    used[edge.to] = true;
                    pq.offer(new Node(edge.to, edge.time));
                }
            }
        }
    }
}

