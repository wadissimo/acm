package yandex.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Vadim_2 on 17.05.2014.
 */
public class D {
    static class Road {
        int dest;
        int cost;

        Road(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    static class Node {
        int a;
        Map<Integer, Road> children;

        Node(int a) {
            this.a = a;
            children = new HashMap<Integer, Road>();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Node node = nodes[a-1];
            if(node == null) {
                node = new Node(a-1);
                nodes[a-1] = node;
            }
            Road road = node.children.get(b - 1);
            if(road == null) {
                node.children.put(b-1, new Road(b-1, c));
            } else {
                if(c<road.cost) {
                    road.cost = c;
                }
            }

        }

        final long[] mincost = new long[n];
        Arrays.fill(mincost, Long.MAX_VALUE);
        int[] path = new int[n];
        int [] visited = new int[n];

        PriorityQueue<Node> queue = new PriorityQueue<Node>(1, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(mincost[o1.a], mincost[o2.a]);
            }
        });
        mincost[0] = 0;
        queue.add(nodes[0]);



        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for (Road road : node.children.values()) {
                long dist = mincost[node.a] + road.cost;
                if(dist < mincost[road.dest] || dist == mincost[road.dest] && visited[node.a] + 1 > visited[road.dest]) {
                    Node dest = nodes[road.dest];
                    queue.remove(dest);
                    mincost[road.dest] = dist;
                    visited[road.dest] = visited[node.a] + 1;
                    path[road.dest] = node.a;
                    if(dest != null) {
                        queue.add(dest);
                    }
                }
            }
        }
        LinkedList<Integer> endPath = new LinkedList<Integer>();
        for (int i = n-1; i > 0; i = path[i]) {
            endPath.addFirst(i);
        }
        System.out.println(mincost[n-1]+ " " + endPath.size());

    }
}
