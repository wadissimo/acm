package codeforces.r447;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    class Node{
        int id;
        Node[] children;
        Node parent;
        int distToParent;
        int[] dist;
        long[] allDist;
        long[] pref;

        public Node(int id) {
            children = new Node[2];
            dist = new int[2];
            this.id = id;
        }

        void merge(){
            if(children[0] == null && children[1] == null){
                allDist = new long[]{0};
                pref = new long[allDist.length+1];
                return;
            }

            if(children[0] == null || children[1] == null) {
                Node which = children[1];
                if (children[1] == null)
                    which = children[0];
                which.merge();

                allDist = new long[which.allDist.length + 1];
                for (int i = 0; i < which.allDist.length; i++) {
                    allDist[i + 1] = which.distToParent + which.allDist[i];
                }
                pref = new long[allDist.length+1];
                for (int i = 0; i < allDist.length; i++) {
                    pref[i+1] = pref[i] + allDist[i];
                }
                return;
            }

            for (int i = 0; i < 2; i++) {
                children[i].merge();
            }

            int li = 0;
            int ri = 0;
            long[] left = children[0].allDist;
            long[] right = children[1].allDist;

            allDist = new long[left.length + right.length+1];
            for (int i = 1; i < allDist.length; i++) {
                if(ri == right.length || li < left.length && left[li]+dist[0] < right[ri]+dist[1]){
                    allDist[i] = left[li++] + dist[0];
                } else {
                    allDist[i] = right[ri++] + dist[1];
                }
            }
            pref = new long[allDist.length+1];
            for (int i = 0; i < allDist.length; i++) {
                pref[i+1] = pref[i] + allDist[i];
            }

        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        Node[] nodes = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 2; i <=n ; i++) {
            int dist = in.ni();
            nodes[i/2].children[i%2] = nodes[i];
            nodes[i/2].dist[i%2] = dist;
            nodes[i].parent = nodes[i/2];
            nodes[i].distToParent = dist;
        }
        nodes[1].merge();// populate the arrays
        for (int q = 0; q < m; q++) {
            int a = in.ni(), h = in.ni();
            Node cur = nodes[a];
            long used = 0;
            long sum = 0;
//            System.out.print("a = " + a);
//            System.out.println("   Arrays.toString(nodes[1].allDist) = " + Arrays.toString(cur.allDist));
            int resIdx = ArrayUtils.binarySearch(cur.allDist, h);
//            System.out.println("resIdx = " + resIdx);
//            System.out.println("cur.pref[resIdx] = " + cur.pref[resIdx]);
            sum+= (long)resIdx*h - cur.pref[resIdx];
            used += cur.distToParent;
            Node prev = cur;
            cur = cur.parent;
            while(cur != null && used < h){
                sum+= h-used;
                for (int i = 0; i < 2; i++) {
                    if(cur.children[i] == prev)
                        continue;
                    if(cur.children[i] == null){
                        break;
                    }
                    if(used + cur.dist[i] < h) {
                        resIdx = ArrayUtils.binarySearch(cur.children[i].allDist, h-used - cur.dist[i]);
                        sum+= resIdx*(h-used-cur.dist[i]) - cur.children[i].pref[resIdx];
                    }
                }
                used += cur.distToParent;
                prev = cur;
                cur = cur.parent;
            }
            out.println(sum);
        }


    }
}
