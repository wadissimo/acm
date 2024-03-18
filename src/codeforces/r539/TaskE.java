package codeforces.r539;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.min;

public class TaskE {
    class Node{
        long min;
        int t;
        boolean on;
        Integer last;
        Integer first;
        long ls;
        long delta;
        Double ans;
        public Node(){

        }
        public Node(int t) {
            this.t = t;
            this.on = false;
        }
        void on(long s){
            this.on = true;
            first = last = t;
            min = 0;
            ls = s;
        }
        void off(){
            this.on = false;
            first = last = null;
            min = Long.MAX_VALUE;
        }
        void copyTo(Node node){
            node.first = this.first;
            node.last = this.last;
            node.delta = this.delta;
            node.ls = this.ls;
            node.min = this.min;
        }
        Result getResult(){
            return new Result(delta, last, ls);
        }
    }
    public void build (Node[] tree, int[] t, int v, int tl, int tr) {
        if (tl == tr)
            tree[v] = new Node(t[tl]);
        else {
            int tm = (tl + tr) / 2;
            build(tree, t, v*2, tl, tm);
            build(tree, t, v*2+1, tm+1, tr);
            tree[v] = new Node();
        }
    }
    public void on (Node[] tree, int v, int tl, int tr, int t, int s) {
        if (tl == tr)
            tree[v].on(s);
        else {
            int tm = (tl + tr) / 2;
            if (t <= tm)
                on(tree, v*2, tl, tm, t, s);
            else
                on(tree, v*2+1, tm+1, tr, t, s);
            Node left = tree[v * 2];
            Node right = tree[v * 2 + 1];
            if(right.first == null) {
                left.copyTo(tree[v]);
            } else if(left.first == null){
                right.copyTo(tree[v]);
            } else {
                tree[v].first = left.first;
                tree[v].last = right.last;
                long gap = (right.first - left.last) * left.ls;
                tree[v].delta = left.delta + right.delta + gap;
                tree[v].ls = right.ls;
                tree[v].min = Math.min(left.min, right.min + gap);
            }
        }
    }
    public void off (Node[] tree, int v, int tl, int tr, int t) {
        if (tl == tr)
            tree[v].off();
        else {
            int tm = (tl + tr) / 2;
            if (t <= tm)
                off(tree, v*2, tl, tm, t);
            else
                off(tree, v*2+1, tm+1, tr, t);
            Node left = tree[v * 2];
            Node right = tree[v * 2 + 1];
            if(right.first == null) {
                left.copyTo(tree[v]);
            } else if(left.first == null){
                right.copyTo(tree[v]);
            } else {
                tree[v].first = left.first;
                tree[v].last = right.last;
                long gap = (right.first - left.last) * left.ls;
                tree[v].delta = left.delta + right.delta + gap;
                tree[v].ls = right.ls;
                tree[v].min = Math.min(left.min, right.min + gap);
            }
        }
    }

    class Result {
        long delta;
        Integer last;
        long s;
        Double ans;

        public Result(long delta, Integer last, long s) {
            this.delta = delta;
            this.last = last;
            this.s = s;
        }
    }

    public Result find(Node[] tree, int v, int tl, int tr, int l, int r, Integer last, long delta, long s){
        int tm = (tl + tr) / 2;
        if(l == tl && r == tr) {
            if(tree[v].first == null){
                return new Result(delta, last, s);
            }
            long prevGap = delta;
            if(last != null){
                prevGap = (tree[v].first - last)*s;
                if (prevGap <= 0) {
                    Result res = new Result(delta, last, s);
                    res.ans = last - (double)delta/s;
                    return res;
                }
            }
            if(tree[v].min > -prevGap)
                return new Result(prevGap + tree[v].delta, tree[v].last, tree[v].ls);

            Node left = tree[v * 2];
            if (left.min <= -prevGap) {
                return find(tree, v * 2, tl, tm, tl, tm, last, delta, s);
            } else {
                if(left.last == null)
                    return find(tree, v*2+1, tm+1, tr, tm+1, tr, last, delta, s);
                else {
                    return find(tree, v*2+1, tm+1, tr, tm+1, tr, left.last, prevGap + left.delta, left.ls);
                }
            }
        }
        if(r <= tm){
            return find(tree, v*2, tl, tm, l, r, last, delta, s);
        } else if(l > tm){
            return find(tree, v*2 + 1, tm+1, tr, l, r, last, delta, s);
        } else {
            Result left = find(tree, v*2, tl, tm, l, tm, last, delta, s);
            if(left.ans != null)
                return left;
            if(left.last == null){
                return find(tree, v*2+1, tm+1, tr, tm+1, r, last, delta, s);
            } else {
                return find(tree, v*2+1, tm+1, tr, tm+1, r, left.last, left.delta, left.s);
            }
        }
    }
    int[] t;


    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int q = in.ni();
        int[][] query = new int[q][4];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < q; i++) {
            query[i][0] = in.ni();
            if(query[i][0] == 1){
                query[i][1] = in.ni();
                query[i][2] = in.ni();
                map.put(query[i][1], i);
            } else if(query[i][0] == 2){
                query[i][1] = in.ni();
            } else {
                query[i][1] = in.ni();
                query[i][2] = in.ni();
                query[i][3] = in.ni();
            }
        }
        int n = map.size();

        t = new int[n];
        int ix = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            t[ix] = entry.getKey();
            entry.setValue(ix);
            ix++;
        }
        Node[] tree = new Node[4*n];
        if(n > 0)
            build(tree, t, 1, 0, n-1);
        for (int i = 0; i < q; i++) {
            if(query[i][0] == 1){
                Integer ind = map.get(query[i][1]);
                on(tree, 1, 0, n-1, ind, query[i][2]);
            } else if(query[i][0] == 2){
                Integer ind = map.get(query[i][1]);
                off(tree, 1, 0, n-1, ind);
            } else {
                if(query[i][3] == 0){
                    out.println(query[i][1]);
                    continue;
                }
                Map.Entry<Integer, Integer> leftEntry = map.ceilingEntry(query[i][1]);
                Map.Entry<Integer, Integer> rightEntry = map.floorEntry(query[i][2]);
                if(n == 0 || leftEntry == null || rightEntry == null || leftEntry.getKey() > rightEntry.getKey()){
                    out.println(-1);
                } else {
                    if(leftEntry.getValue() > rightEntry.getValue())
                        throw new RuntimeException("wrong interval value");
                    if(leftEntry.getKey() < query[i][1] || leftEntry.getKey() > query[i][2])
                        throw new RuntimeException("wrong left");
                    if(rightEntry.getKey() > query[i][2] || rightEntry.getKey() < query[i][1])
                        throw new RuntimeException("wrong right");
                    Result res = find(tree, 1, 0, n - 1, leftEntry.getValue(), rightEntry.getValue(), null, query[i][3], 0);
                    if(res.ans != null){
                        out.printf("%f%n", res.ans);
                    } else {
                        if(res.last != null){
                            if(res.delta + (query[i][2]-res.last)*res.s <= 0){
                                out.printf("%f%n", res.last - (double)res.delta/res.s);
                            } else
                                out.println(-1);
                        } else
                            out.println(-1);
                    }
                }

            }
        }




    }
}
