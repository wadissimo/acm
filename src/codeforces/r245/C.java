package codeforces.r245;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Vadim_2 on 11.05.2014.
 */
public class C {
    static class Node {
        int id;
        int parent;
        List<Integer> children = new ArrayList<Integer>();
        boolean visited;


        Node(int id, int parent) {
            this.id = id;
            this.parent = parent;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n];
        nodes[0] = new Node(0, -1);//root
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(nodes[a-1] != null) {
                nodes[b-1] = new Node(b-1, a-1);
                nodes[a-1].children.add(b-1);
            } else if(nodes[b-1] != null){
                nodes[a-1] = new Node(a-1, b-1);
                nodes[b-1].children.add(a-1);
            } else {
                throw new RuntimeException();
            }
        }
        st = new StringTokenizer(reader.readLine());
        int init[] = new int[n];
        for (int i = 0; i < n; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(reader.readLine());
        int goal[] = new int[n];
        boolean changed[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
            changed[i] = goal[i] != init[i];
        }
        Queue queue = new LinkedList();
        queue.add(nodes[0]);
        nodes[0].visited = true;
        int changes[] = new int[n];
        int ans = 0;
        List<Integer> ansNodes = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            Node node = (Node)queue.remove();
            if(node.parent != -1 && nodes[node.parent].parent != -1 && changes[nodes[node.parent].parent] == 1) {
                if(!changed[node.id]){
                    ans++;
                    ansNodes.add(node.id);
                }else{
                    changes[node.id]++;
                }
            }else {
                if (changed[node.id]) {
                    changes[node.id]++;
                    ansNodes.add(node.id);
                    ans++;
                }
            }

            for (Integer childId : node.children) {
                Node child=nodes[childId];
                if(!child.visited) {
                    child.visited=true;
                    queue.add(child);
                }
            }
        }
        System.out.println(ans);
        StringBuilder sb = new StringBuilder();
        for (Integer ansNode : ansNodes) {
            sb.append(ansNode+1).append("\n");
        }
        System.out.println(sb);

    }
}
