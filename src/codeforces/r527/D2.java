package codeforces.r527;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D2 {
    int MAX = 1_000_000;
    class Item{
        int h, id, v;

        public Item(int h, int id) {
            this.h = h;
            this.id = id;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(a[i], i);
        }
        DSU dsu = new DSU(n);
        PriorityQueue<Item> pq = new PriorityQueue<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.h, o2.h);
            }
        });
        for (int i = 0; i < n; i++) {
            pq.offer(items[i]);
        }
        int[] vers = new int[n];
        int v = 1;
        while(!pq.isEmpty()){
            Item item = pq.poll();
            if(item.v < vers[dsu.find(item.id)])
                continue;
            int left = dsu.left[dsu.find(item.id)];
            int right = dsu.right[dsu.find(item.id)];
            if(left != -1 && (right == MAX || a[dsu.find(left)] <= a[dsu.find(right)])){
                vers[dsu.find(left)] = 0;
                vers[dsu.find(item.id)] = 0;
                if(a[dsu.find(left)] == item.h){
                    dsu.union(left, item.id);
                } else {
                    if(dsu.size[dsu.find(item.id)] %2 != 0){
                        out.println("NO");
                        return;
                    }
                    item.h = a[dsu.find(left)];
                    dsu.union(left, item.id);
                    a[dsu.find(item.id)] = item.h;
                }
                item.v = v++;
                vers[dsu.find(item.id)] = item.v;
                pq.offer(item);
            } else if(right != MAX) {
                vers[dsu.find(right)] = 0;
                vers[dsu.find(item.id)] = 0;
                if(a[dsu.find(right)] == item.h){
                    dsu.union(right, item.id);
                } else {
                    if(dsu.size[dsu.find(item.id)] %2 != 0){
                        out.println("NO");
                        return;
                    }
                    item.h = a[dsu.find(right)];
                    dsu.union(right, item.id);
                    a[dsu.find(item.id)] = item.h;
                }
                item.v = v++;
                vers[dsu.find(item.id)] = item.v;
                pq.offer(item);
            }
        }
        out.println("YES");
    }

    class DSU {
    int[] rank, parent;
    int[] left, right, size;
    int n;

    public DSU(int n) {
        rank = new int[n];
        parent = new int[n];
        left = new int[n];
        right = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 1; i < n; i++) {
            left[i] = i-1;
        }
        left[0] = -1;
        for (int i = 0; i < n - 1; i++) {
            right[i] = i+1;
        }
        right[n-1] = MAX;
        this.n = n;
        makeSet();
    }

    void makeSet() {
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x]!=x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot)
            return;
        int l = left[xRoot];
        int r = right[yRoot];
        if(yRoot < xRoot){
            l = left[yRoot];
            r = right[xRoot];
        }
        int sz = size[xRoot] + size[yRoot];
        int root = xRoot;
        if (rank[xRoot] < rank[yRoot]){
            parent[xRoot] = yRoot;
            root = yRoot;
        }else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
        size[root] = sz;
        left[root] = Math.min(left[xRoot], left[yRoot]);
        right[root] = Math.max(right[xRoot], right[yRoot]);
    }

}
}
