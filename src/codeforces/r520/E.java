package codeforces.r520;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E {
    class Node {
        int id;
        int parent;
        int d;
        List<Node> children = new LinkedList<>();

        public Node(int id, int parent) {
            this.id = id;
            this.parent = parent;
        }
    }
    int INF = 12345678;
    class SegmentValue{
        int tinMin = INF;
        int tinMin2 = INF;
        int toutMax = -1;
        int toutMax2 = -1;

        public SegmentValue() {
        }

        public SegmentValue(int tinMin, int tinMin2, int toutMax, int toutMax2) {
            this.tinMin = tinMin;
            this.tinMin2 = tinMin2;
            this.toutMax = toutMax;
            this.toutMax2 = toutMax2;
        }

        SegmentValue copy(){
            return new SegmentValue(tinMin, tinMin2, toutMax, toutMax2);
        }
        void merge(SegmentValue value1, SegmentValue value2){
            tinMin = Math.min(value1.tinMin, value2.tinMin);
            if(value1.tinMin != value2.tinMin){
                tinMin2 = Math.min(Math.max(value1.tinMin, value2.tinMin), Math.min(value1.tinMin2, value2.tinMin2));
            } else {
                tinMin2 = Math.min(value1.tinMin2, value2.tinMin2);
            }
            toutMax = Math.max(value1.toutMax, value2.toutMax);
            if(value1.toutMax != value2.toutMax){
                toutMax2 = Math.max(Math.min(value1.toutMax, value2.toutMax), Math.max(value1.toutMax2, value2.toutMax2));
            } else {
                toutMax2 = Math.max(value1.toutMax2, value2.toutMax2);
            }

        }
    }
    class SegmentNode{
        SegmentValue value = new SegmentValue();


    }
    public void build (SegmentNode[] t, int n) {
        build(t, 1, 0, n-1);
    }

    public void build (SegmentNode t [], int v, int tl, int tr) {
        if (tl == tr) {
            t[v].value.tinMin  = tins[tl];
            t[v].value.toutMax  = touts[tl];
        } else {
            int tm = (tl + tr) / 2;
            build (t, v*2, tl, tm);
            build (t, v*2+1, tm+1, tr);
            t[v].value.merge(t[v*2].value, t[v*2+1].value);
        }
    }

    public SegmentValue getVal (SegmentNode t[], int l, int r, int n) {
        return getVal(t, 1, 0, n-1, l, r);
    }

    public SegmentValue getVal (SegmentNode t[], int v, int tl, int tr, int l, int r) {
        if (l == tl && r == tr){
            return t[v].value.copy();
        }
        int tm = (tl + tr) / 2;
        if(r<=tm){
            return getVal (t, v*2, tl, tm, l, r);
        } else if (l > tm){
            return getVal (t, v*2+1, tm+1, tr, l, r);
        } else {
            SegmentValue val = new SegmentValue();
            val.merge(getVal (t, v*2, tl, tm, l, tm), getVal (t, v*2+1, tm+1, tr, tm+1, r));
            return val;
        }
    }


    int maxLog;
    int[][] jump;
    int[] tins;
    int[] touts;
    int[] tinToID;
    int[] toutToID;
    int timer = 0;
    Node[] nodes;

    void dfs(Node node){
        tinToID[timer] = node.id;
        tins[node.id] = timer++;
        if(node.children != null)
            for (Node child : node.children) {
                child.d = node.d + 1;
                dfs(child);
            }
        toutToID[timer] = node.id;
        touts[node.id] = timer++;
    }

    int jump(int v, int d){
        int cur = v;
        for (int i = 0; i <= maxLog && cur != -1; i++) {
            if((d&(1<<i)) > 0){
                cur = jump[cur][i];
            }
        }
        return cur;
    }

    int lca(Node v, Node u){
        //System.out.printf("1. v.id=%d v.d=%d u.id=%d u.d=%d%n", v.id, v.d, u.id, u.d);
        if(v.d > u.d){
            int id = jump(v.id, v.d-u.d);
            v = nodes[id];
        } else if(u.d > v.d){
            int id = jump(u.id, u.d-v.d);
            u = nodes[id];
        }
        //System.out.printf("2. v.id=%d v.d=%d u.id=%d u.d=%d%n", v.id, v.d, u.id, u.d);
        if(v.id == u.id)
            return v.id;
        int vid = v.id;
        int uid = u.id;
        for (int i = maxLog; i >= 0; i--) {
            int curv = jump(vid, i+1);
            int curu = jump(uid, i+1);
            if(curu != curv){
                uid = curu;
                vid = curv;
            }
        }
        if(jump[vid][0] == -1 || jump[vid][0] != jump[uid][0])
            throw new RuntimeException("lca faulty");
        return jump[vid][0];
    }


    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int q = in.ni();
        tins = new int[n];
        touts = new int[n];
        tinToID = new int[2*n];
        toutToID = new int[2*n];

        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i,-1);
        }
        for (int i = 1; i < n; i++) {
            int p = in.ni()-1;
            nodes[i].parent = p;
            nodes[p].children.add(nodes[i]);
        }
        dfs(nodes[0]);
        int maxD = 0;
        for (int i = 0; i < n; i++) {
            maxD = Math.max(nodes[i].d, maxD);
        }

        maxLog = Integer.numberOfTrailingZeros(Integer.highestOneBit(maxD))+1;

        jump = new int[n][maxLog+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(jump[i], -1);
            jump[i][0] = nodes[i].parent;
        }
        for (int d = 1; d <=maxLog; d++) {
            for (int i = 0; i < n; i++) {
                if(jump[i][d-1] != -1)
                    jump[i][d] = jump[jump[i][d-1]][d-1];
            }
        }

        SegmentNode[] t = new SegmentNode[4*n];
        for (int i = 0; i < 4 * n; i++) {
            t[i] = new SegmentNode();
        }
        build(t, n);
        for (int i = 0; i < q; i++) {
            int l = in.ni()-1;
            int r = in.ni()-1;
            SegmentValue val = getVal(t, l, r, n);
            //System.out.printf("l =%d r=%d %n", l+1, r+1);
            //System.out.printf("tinMin =%d toutMax=%d tinMin2=%d toutMax2=%d%n", tinToID[val.tinMin]+1, toutToID[val.toutMax]+1, tinToID[val.tinMin2]+1, toutToID[val.toutMax2]+1);
            if(tinToID[val.tinMin] == toutToID[val.toutMax]){
                int lca = lca(nodes[tinToID[val.tinMin2]], nodes[toutToID[val.toutMax2]]);
                int ans = nodes[lca].d;
                out.println((tinToID[val.tinMin]+1) + " " + ans);
            } else {
                int leftLCA = lca(nodes[tinToID[val.tinMin2]], nodes[toutToID[val.toutMax]]);
                //System.out.println("leftLCA = " + (leftLCA + 1));
                int leftRes = nodes[leftLCA].d;
                //System.out.println("leftRes = " + (leftRes+1));
                int rightLCA = lca(nodes[tinToID[val.tinMin]], nodes[toutToID[val.toutMax2]]);
                //System.out.println("rightLCA = " + (rightLCA + 1));
                int rightRes = nodes[rightLCA].d;
                //System.out.println("rightRes = " + (rightRes+1));
                if(leftRes > rightRes){
                    out.println((tinToID[val.tinMin]+1) + " " + leftRes);
                } else {
                    out.println((toutToID[val.toutMax]+1) + " " + rightRes);
                }
            }

        }


    }
}
