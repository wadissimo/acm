package codeforces.vk2018r1;

import chelper.io.FastScanner;
import common.XorTrie;

import java.io.PrintWriter;

public class D {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int[] p = in.na(n);
        XorTrie trie = new XorTrie(30);
        for (int i = 0; i < n; i++) {
            trie.add(p[i]);
        }
        for (int i = 0; i < n; i++) {
            int o = trie.minXor(a[i]);
            out.print(o + " ");
            if(!trie.remove(o^a[i]))
                throw new RuntimeException("Not found");
        }
    }
}
