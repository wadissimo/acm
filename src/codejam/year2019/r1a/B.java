package codejam.year2019.r1a;

import chelper.io.FastScanner;
import common.Trie;


import java.io.PrintWriter;

import java.util.Map;

public class B {

    private int dfs(Trie.Node node){
        if(node.total < 2){
            return 0;
        }

        int ans = 0;
        for (Map.Entry<Character, Trie.Node> e : node.children.entrySet()) {
            int res = dfs(e.getValue());
            ans += res;
        }
        if(node.c != (char)0 && node.total-ans >= 2)
            ans += 2;
        return ans;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();

            Trie trie = new Trie();
            for (int i = 0; i < n; i++) {
                trie.addString(new StringBuilder().append(in.ns()).reverse().toString());
            }
            int res = dfs(trie.root);
            out.printf("Case #%d: %d%n", t+1, res);
        }
    }
}
