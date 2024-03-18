package codeforces.icpc2018.qf;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskH {
    class Node{
        Node[] children = new Node[37];
        int count = 0;
        int file = -1;
    }
    int index(char c){
        if(c=='.')
            return 0;
        if(c <= '9')
            return c-'0'+1;
        return c-'a'+11;
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        String [] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ns();
        }

        Node root = new Node();
        for (int i = 0; i < n; i++) {
            String s = a[i];
            for (int j = 0; j < s.length() ; j++) {
                Node cur = root;
                for (int k = j; k < s.length(); k++) {
                    Node next = cur.children[index(s.charAt(k))];
                    if(next == null) {
                        next = new Node();
                        cur.children[index(s.charAt(k))] = next;
                    }
                    cur = next;
                    if(cur.file != i) {
                        cur.count++;
                        cur.file = i;
                    }
                }
            }
        }

        int q = in.ni();
        for (int i = 0; i < q; i++) {
            String query = in.ns();
            Node cur = root;
            for (int j = 0; j < query.length(); j++) {
                cur = cur.children[index(query.charAt(j))];
                if(cur == null)
                    break;
            }
            if(cur != null){
                out.println(cur.count + " " + a[cur.file]);
            } else {
                out.println("0 -");
            }

        }
    }
}
