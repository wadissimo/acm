package codeforces.r494;

import chelper.io.FastScanner;
import common.GraphUtil;

import java.io.PrintWriter;

public class TaskE {

    class Node extends GraphUtil.Node{
        int rem = 0;
        int h = 0;
        public Node(int id, int parent) {
            super(id, parent);
        }

        public Node(int id, int parent, int rem, int h) {
            super(id, parent);
            this.rem = rem;
            this.h = h;
        }
    }
    class WrongException extends Exception{ }

    void addNodes(Node parent){
        if(parent.h == 0 || n == 0)
            return;
        if(parent.children != null)
            for (GraphUtil.Node x : parent.children) {
                Node child = (Node)x;
                addNodes(child);
            }
        for (int i = 0; i < parent.rem && n > 0; i++) {
            n--;
            Node child = new Node(treeId++, parent.id, k-1, parent.h-1);
            res.append(parent.id+1).append(' ').append(child.id+1).append('\n');
            addNodes(child);
        }
        parent.rem = 0;
    }
    int n;
    int treeId = 1;
    int k;
    StringBuilder res = new StringBuilder();
    public void solve(int testNumber, FastScanner in, PrintWriter out) {

        n = in.ni();
        int d = in.ni();
        k = in.ni();
        int left = d/2;
        int right = d-left;
        Node root = new Node(0, 0, k, right);
        n--;
        Node parent = root;
        try {
            for (int i = 0; i < right; i++) {
                if(parent.rem == 0 || n == 0)
                    throw new WrongException();
                parent.rem--;
                Node child = new Node(treeId++, parent.id, k-1, parent.h-1);
                res.append(parent.id+1).append(' ').append(child.id+1).append('\n');
                parent.add(child);
                parent = child;
                n--;
            }
            parent = root;
            root.h = left;
            for (int i = 0; i < left; i++) {
                if(parent.rem == 0 || n == 0)
                    throw new WrongException();
                parent.rem--;
                Node child = new Node(treeId++, parent.id, k-1, parent.h-1);
                res.append(parent.id+1).append(' ').append(child.id+1).append('\n');
                parent.add(child);
                parent = child;
                n--;
            }
            addNodes(root);
            if(n != 0)
                out.println("NO");
            else {
                out.println("YES");
                out.println(res.toString());
            }
        }catch (WrongException e){
            out.println("NO");
        }
    }
}
