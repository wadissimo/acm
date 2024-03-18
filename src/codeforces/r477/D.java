package codeforces.r477;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class D {
    private int search(Node[] c, int lim){
        int left = 0;
        int right = c.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(c[mid].c  < lim){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        if(c[left].c <lim)
            left++;
        return left;
    }
    class Node{
        int c;
        int id;

        public Node(int c, int id) {
            this.c = c;
            this.id = id;
        }
    }
    private int[] subsolve(Node[] c, int x1, int x2){
        int n = c.length;
        int k1 = 1;
        for (; k1 < n; k1++) {
            int lim1 = x1/k1 + (x1%k1 == 0?0:1);
            int res = search(c, lim1);
            res = n-res;
            if(res >= k1){
                break;
            }
        }
        if(k1 == n)
            return null;
        for (int k2 = 1; k2 < n; k2++) {
            int lim2 = x2/k2 + (x2%k2 == 0?0:1);
            int res = search(c, lim2);
            res = n-res;
            if(res >= k1+k2){
                return new int[]{k1, k2};
            }
        }
        return null;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), x1 = in.ni(), x2 = in.ni();
        Node[] c = new Node[n];
        for (int i = 0; i < n; i++) {
            c[i] = new Node(in.ni(), i+1);
        }
        Random rand = new Random();
        if(n > 1000){
            for (int i = 0; i < n/2; i++) {
                int x = rand.nextInt(n);
                int y = rand.nextInt(n-1);
                if(y>=x)
                    y++;
                Node t = c[x];c[x]= c[y]; c[y] = t;
            }
        }

        Arrays.sort(c, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.c, o2.c);
            }
        });
        int[] res = subsolve(c, x1, x2);
        if(res == null){
            res = subsolve(c, x2, x1);
            if(res == null){
                out.println("No");
            } else {
                out.println("Yes");
                int k1 = res[0], k2 = res[1];
                out.println(k2 + " " + k1);
                for (int i = n-k2-k1; i < n-k1 ; i++) {
                    out.print(c[i].id + " ");
                }
                out.println();
                for (int i = n-k1; i < n; i++) {
                    out.print(c[i].id + " ");
                }
                out.println();
            }
        } else {
            out.println("Yes");
            int k1 = res[0], k2 = res[1];
            out.println(k1 + " " + k2);
            for (int i = n-k1; i < n; i++) {
                out.print(c[i].id + " ");
            }
            out.println();
            for (int i = n-k2-k1; i < n-k1 ; i++) {
                out.print(c[i].id + " ");
            }
            out.println();
        }

    }
}
