package facebook.hackercup.y2020.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D2 {
    private static final long INF = Long.MAX_VALUE;
    class Fenwick {
        int N;
        long[] tree;
        public Fenwick(int n) {
            N = n;
            tree = new long[N];
            Arrays.fill(tree, INF);
        }

        long getMin(int r) {
            long ans = INF;
            while (r >= 0) {
                ans = Math.min(ans, tree[r]);
                r = (r & (r + 1)) - 1;
            }
            return ans;
        }

        void update(int pos, long val){
            while (pos < N) {
                tree[pos] = Math.min(tree[pos], val);
                pos |= pos + 1;
            }
        }

    }
    class Node {
        int id;
        int p;
        long c;
        boolean path;
        List<Node> nodes;
        Node parent;
        int dist;
        int distIdx;
        long cost;

        public Node(int id) {
            this.id = id;
            nodes = new LinkedList();
            cost = INF;
        }
    }
    int A,B,N,M;
    boolean[] visited;
    Node[] nodes;
    Node[] tree;

    void buildTree(int v) {
        for (Node node : nodes[v].nodes) {
            if(!visited[node.id]) {
                visited[node.id] = true;
                if(node.id != B)
                    buildTree(node.id);
                if(node.id == B){
                    tree[node.id].path = true;
                }
                if(tree[node.id].path){
                    tree[v].path = true;
                }
                tree[node.id].c = node.c;
                tree[node.id].parent = tree[v];
                if(v != A || tree[v].path) // remove all other branches from starting point
                    tree[v].nodes.add(tree[node.id]);
            }
        }
    }
    List<Node>[] distBuckets;
    int[] nodesByDist;
    int[] distEnd;
    void calcDist(int v){
        for (Node node : tree[v].nodes) {
            node.dist = tree[v].dist+1;
            distBuckets[node.dist].add(node);
            calcDist(node.id);
        }
    }
    Fenwick fenwick;

    void dfs(int v, int baseDist){
        for (Node node : tree[v].nodes) {
            if(!node.path) {
                if(node.c != 0) {
                    int dist = baseDist - (node.dist - baseDist) + M;
                    if (dist > N - 1) {
                        dist = N - 1;
                    }
                    if(dist < baseDist)
                        dist = baseDist;
                    long minCost = fenwick.getMin(distEnd[dist]-1);
                    if (minCost != INF) {
                        node.cost = minCost + node.c;
                        fenwick.update(node.distIdx, node.cost);
                    }
                }
                dfs(node.id, baseDist);
            }
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            N = in.ni();
            M = in.ni();
            A = in.ni()-1;
            B = in.ni()-1;

            nodes = new Node[N];
            tree = new Node[N];
            for (int i = 0; i < N; i++) {
                nodes[i] = new Node(i);
                tree[i] = new Node(i);
            }
            for (int i = 0; i < N; i++) {
                int p = in.ni();
                nodes[i].c = in.ni();
                if(p != 0) {
                    nodes[i].nodes.add(nodes[p - 1]);
                    nodes[p-1].nodes.add(nodes[i]);
                }
            }
            visited = new boolean[N];
            visited[A] = true;
            buildTree(A);
            distBuckets = new List[N];
            for (int i = 0; i < N; i++) {
                distBuckets[i] = new LinkedList<>();
            }
            calcDist(A);
            nodesByDist = new int[N];
            distEnd = new int[N];
            int idx = 0;
            for (int i = 1; i < N; i++) {
                for (Node node : distBuckets[i]) {
                    node.distIdx = idx;
                    nodesByDist[idx++] = node.id;
                }
                distEnd[i] = idx;
            }

            fenwick = new Fenwick(distEnd[N-1]);
            fenwick.update(tree[B].distIdx, 0);
            tree[B].cost = 0;
            int current = tree[B].parent.id;

            while(current != A){
                if(tree[current].c != 0) {
                    int dist = tree[current].dist + M;
                    if (dist > N-1) {
                        dist = N-1;
                    }

                    long minCost = fenwick.getMin(distEnd[dist]-1);
                    if(minCost != INF) {
                        tree[current].cost = minCost + tree[current].c;
                        fenwick.update(tree[current].distIdx, tree[current].cost);
                    }
                }
                dfs(current, tree[current].dist);

                current = tree[current].parent.id;
            }
            int dist = M;
            if (dist > N-1) {
                dist = N-1;
            }
            long ans = fenwick.getMin(distEnd[dist]-1);
            out.printf("Case #%d: ", t+1);
            if(ans != INF){
                out.println(ans);
            } else {
                out.println(-1);
            }
        }
    }
}
