package codeforces.ecr46;

import chelper.io.FastScanner;
import common.G;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static common.GraphUtil.*;

public class TaskE {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
            int m = in.ni();
            List<Edge>[] adj = in.readEdgesGraph(n, m, true);
            G g = new G(adj);

            List<Edge> bridges = g.getBridges();
            if (bridges.size() == 0) {
                out.println(0);
                return;
            }
            boolean[] isBridge = new boolean[m];
            for (Edge bridge : bridges) {
                isBridge[bridge.id] = true;
            }
            int[] st = new int[n + m];
            int sti = 0;
            int[] remap = new int[n];
            Arrays.fill(remap, -1);
            int treeSize = 0;
            for (Edge bridge : bridges) {
                if (remap[bridge.from] == -1) {
                    remap[bridge.from] = treeSize++;
                    st[sti++] = bridge.from;
                }
                if (remap[bridge.to] == -1) {
                    remap[bridge.to] = treeSize++;
                    st[sti++] = bridge.to;
                }
                while (sti > 0) {
                    int v = st[--sti];
                    for (Edge e : adj[v]) {
                        int u = e.to;
                        if (remap[u] != -1 || isBridge[e.id])
                            continue;
                        st[sti++] = u;
                        remap[u] = remap[v];
                    }
                }
            }

            List<Integer>[] bg = new List[treeSize];
            for (int i = 0; i < treeSize; i++) {
                bg[i] = new LinkedList<>();
            }
            for (Edge bridge : bridges) {
                bridge.from = remap[bridge.from];
                bridge.to = remap[bridge.to];
                bg[bridge.from].add(bridge.to);
                bg[bridge.to].add(bridge.from);
            }

            Node[] nodes = new Node[treeSize];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node(i, -1);
            }
            st[sti++] = 0;
            nodes[0].parent = 0;
            while (sti > 0) {
                int v = st[--sti];
                for (int u : bg[v]) {
                    if (nodes[u].parent == -1) {
                        nodes[u].parent = v;
                        nodes[v].add(nodes[u]);
                        st[sti++] = u;
                    }
                }
            }

            //if(n==30000)
            /*for (int i = 0; i < nodes.length; i++) {
                System.out.println(nodes[i].id + " " + nodes[i].parent);
            }*/
            Node tree = nodes[0];
            out.println(diameter(tree, nodes.length));
    }
}
