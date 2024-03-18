package codeforces.r237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class C {

    static class Node implements Comparable{
        int node;
        int dist;

        Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.dist, ((Node)o).dist);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int[] d = new int[n];
        PriorityQueue<Node> q = new PriorityQueue<Node>(n);

        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            q.add(new Node(i+1, d[i]));
        }
        int m = 0;
        StringBuilder sb = new StringBuilder();
        Node root = q.poll();
        if(root.dist != 0 || q.peek() != null && q.peek().dist == 0) {
            System.out.println(-1);
        } else {
            int lcount = 0;
            int lcur = 0;
            Deque<Integer> prevLayer = new LinkedList<Integer>();
            Deque<Integer> layer = new LinkedList<Integer>();
            layer.add(root.node);
            for (int i = 1; i < n; i++) {
                Node node = q.poll();

                if(node == null) {
                    break;
                }

                if(node.dist == lcur + 1) {
                    prevLayer = layer;
                    layer = new LinkedList<Integer>();
                    lcount = 0;
                    lcur++;
                }
                if(node.dist == lcur) {
                    layer.add(node.node);
                    lcount++;
                    if(lcur == 1 && lcount > k || lcur > 1 && lcount > k -1) {
                        lcount = 1;
                        prevLayer.removeFirst();
                        if(prevLayer.isEmpty()) {
                            System.out.println(-1);
                            return;
                        }
                    }
                    sb.append(prevLayer.getFirst()).append(" ").append(node.node).append("\n");
                    m++;
                } else {
                    System.out.println(-1);
                    return;
                }

            }
            System.out.println(m);
            System.out.println(sb);
        }

    }
}
