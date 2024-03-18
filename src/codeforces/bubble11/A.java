package codeforces.bubble11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class A {
    static class Pair implements Comparable<Pair>{
        int x,l;

        public Pair(int x, int l) {
            this.x = x;
            this.l = l;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(l, o.l);
        }
    }
    static class Robot implements Comparable<Robot>{
        int x,r,q;

        public Robot(int x, int r, int q) {
            this.x = x;
            this.r = r;
            this.q = q;
        }

        @Override
        public int compareTo(Robot o) {
            return Integer.compare(x, o.x);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x[]= new int[n];
        int r[]= new int[n];
        int q[]= new int[n];
        Robot sx[]=new Robot[n];
        /*int[] test = new int[]{1,2,2,2,4,4,4,5};
        Node root = null;
        for (int i = 0; i < test.length; i++) {
            root = insertb(root, new Node(test[i]));
        }
        System.out.println(search(root, 1));
        System.out.println(search(root, 2));
        System.out.println(search(root, 3));
        System.out.println(search(root, 4));
        System.out.println(search(root, 5));*/
        HashMap<Integer, ArrayList<Pair>> iqlm = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> iqxc = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            r[i] = Integer.parseInt(st.nextToken());
            q[i] = Integer.parseInt(st.nextToken());
            sx[i] = new Robot(x[i], r[i], q[i]);
            ArrayList<Pair> la = iqlm.computeIfAbsent(q[i], k1 -> new ArrayList<>());
            la.add(new Pair(x[i], x[i]-r[i]));
            HashMap<Integer, Integer> xm = iqxc.computeIfAbsent(q[i], k1 -> new HashMap<Integer, Integer>());
            xm.put(x[i], xm.getOrDefault(x[i], 0)+1);
        }
        HashMap<Integer, Pair[]> iql = new HashMap<>();
        HashMap<Integer, Node> iqx = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Pair>> entry : iqlm.entrySet()) {
            Pair[] a = new Pair[entry.getValue().size()];
            int i = 0;
            for (Pair node : entry.getValue()) {
                a[i++] = node;
            }
            Arrays.sort(a);
            iql.put(entry.getKey(), a);
        }
        HashMap<Integer, Integer> iqi = new HashMap<>(iql.size());
        for (Integer key : iql.keySet()) {
            iqi.put(key, 0);
        }
        Arrays.sort(sx);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int cx = sx[i].x;
            int rightBound = cx + sx[i].r;
            for (int iq = sx[i].q-k; iq <= sx[i].q+k; iq++) {
                Pair[] leftEnds = iql.get(iq);
                if(leftEnds == null)
                    continue;
                Node tree = iqx.get(iq);
                int lefti = iqi.get(iq);
                int prev_lefti = lefti;
                while(lefti < leftEnds.length && leftEnds[lefti].l <= cx) {
                    tree = insertb(tree, new Node(leftEnds[lefti].x));
                    lefti++;
                }

                if (lefti > prev_lefti){
                    iqi.put(iq, lefti);
                    iqx.put(iq, tree);
                }
                int xpos = search(tree, cx)+1;
                if (xpos < 0){
                    xpos = -xpos;
                }
                int rpos = search(tree, rightBound)+1;
                if (rpos < 0){
                    rpos = -rpos;
                }
                if (rpos - xpos > 0)
                    ans += rpos - xpos;
                HashMap<Integer, Integer> xc = iqxc.get(iq);
                if(xc != null){
                    Integer cnt = xc.get(cx);
                    if(cnt != null){
                        if(sx[i].q == iq){
                            cnt--;
                            xc.put(cx, cnt);
                        }
                        ans += cnt;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static Random gen = new Random();

    static public class Node
    {
        public long v; // value
        public long priority;
        public Node left, right, parent;

        public int count;

        public Node(long v)
        {
            this.v = v;
            priority = gen.nextLong();
            update(this);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Node [v=");
            builder.append(v);
            builder.append(", count=");
            builder.append(count);
            builder.append(", parent=");
            builder.append(parent != null ? parent.v : "null");
            builder.append("]");
            return builder.toString();
        }
    }

    public static Node update(Node a)
    {
        if(a == null)return null;
        a.count = 1;
        if(a.left != null)a.count += a.left.count;
        if(a.right != null)a.count += a.right.count;

        // TODO
        return a;
    }

    public static void propagate(Node x)
    {
        for(;x != null;x = x.parent)update(x);
    }

    public static Node disconnect(Node a)
    {
        if(a == null)return null;
        a.left = a.right = a.parent = null;
        return update(a);
    }

    public static Node root(Node x)
    {
        if(x == null)return null;
        while(x.parent != null)x = x.parent;
        return x;
    }

    public static int count(Node a)
    {
        return a == null ? 0 : a.count;
    }

    public static void setParent(Node a, Node par)
    {
        if(a != null)a.parent = par;
    }

    public static Node merge(Node a, Node b, Node... c)
    {
        Node x = merge(a, b);
        for(Node n : c)x = merge(x, n);
        return x;
    }

    public static Node merge(Node a, Node b)
    {
        if(b == null)return a;
        if(a == null)return b;
        if(a.priority > b.priority){
            setParent(a.right, null);
            setParent(b, null);
            a.right = merge(a.right, b);
            setParent(a.right, a);
            return update(a);
        }else{
            setParent(a, null);
            setParent(b.left, null);
            b.left = merge(a, b.left);
            setParent(b.left, b);
            return update(b);
        }
    }

    public static Node[] split(Node x)
    {
        if(x == null)return new Node[]{null, null};
        if(x.left != null)x.left.parent = null;
        Node[] sp = new Node[]{x.left, x};
        x.left = null;
        update(x);
        while(x.parent != null){
            Node p = x.parent;
            x.parent = null;
            if(x == p.left){
                p.left = sp[1];
                if(sp[1] != null)sp[1].parent = p;
                sp[1] = p;
            }else{
                p.right = sp[0];
                if(sp[0] != null)sp[0].parent = p;
                sp[0] = p;
            }
            update(p);
            x = p;
        }
        return sp;
    }

    public static Node[] split(Node a, int... ks)
    {
        int n = ks.length;
        if(n == 0)return new Node[]{a};
        for(int i = 0;i < n-1;i++){
            if(ks[i] > ks[i+1])throw new IllegalArgumentException(Arrays.toString(ks));
        }

        Node[] ns = new Node[n+1];
        Node cur = a;
        for(int i = n-1;i >= 0;i--){
            Node[] sp = split(cur, ks[i]);
            cur = sp[0];
            ns[i] = sp[0];
            ns[i+1] = sp[1];
        }
        return ns;
    }

    // [0,K),[K,N)
    public static Node[] split(Node a, int K)
    {
        if(a == null)return new Node[]{null, null};
        if(K <= count(a.left)){
            setParent(a.left, null);
            Node[] s = split(a.left, K);
            a.left = s[1];
            setParent(a.left, a);
            s[1] = update(a);
            return s;
        }else{
            setParent(a.right, null);
            Node[] s = split(a.right, K-count(a.left)-1);
            a.right = s[0];
            setParent(a.right, a);
            s[0] = update(a);
            return s;
        }
    }

    public static Node insertb(Node root, Node x)
    {
        int ind = lowerBound(root, x.v);
        return insert(root, ind, x);
    }

    public static Node insert(Node a, int K, Node b)
    {
        if(a == null)return b;
        if(b.priority < a.priority){
            if(K <= count(a.left)){
                a.left = insert(a.left, K, b);
                setParent(a.left, a);
            }else{
                a.right = insert(a.right, K-count(a.left)-1, b);
                setParent(a.right, a);
            }
            return update(a);
        }else{
            Node[] ch = split(a, K);
            b.left = ch[0]; b.right = ch[1];
            setParent(b.left, b);
            setParent(b.right, b);
            return update(b);
        }
    }

    // delete K-th
    public static Node erase(Node a, int K)
    {
        if(a == null)return null;
        if(K < count(a.left)){
            a.left = erase(a.left, K);
            setParent(a.left, a);
            return update(a);
        }else if(K == count(a.left)){
            setParent(a.left, null);
            setParent(a.right, null);
            Node aa = merge(a.left, a.right);
            disconnect(a);
            return aa;
        }else{
            a.right = erase(a.right, K-count(a.left)-1);
            setParent(a.right, a);
            return update(a);
        }
    }

    public static Node get(Node a, int K)
    {
        while(a != null){
            if(K < count(a.left)){
                a = a.left;
            }else if(K == count(a.left)){
                break;
            }else{
                K = K - count(a.left)-1;
                a = a.right;
            }
        }
        return a;
    }

    public static int index(Node a)
    {
        if(a == null)return -1;
        int ind = count(a.left);
        while(a != null){
            Node par = a.parent;
            if(par != null && par.right == a){
                ind += count(par.left) + 1;
            }
            a = par;
        }
        return ind;
    }

    public static Node mergeTechnically(Node x, Node y)
    {
        if(count(x) > count(y)){
            Node d = x; x = y; y = d;
        }
        // |x|<=|y|
        for(Node cur : nodesdfs(x))y = insertb(y, disconnect(cur));
        return y;
    }

    public static int lowerBound(Node a, long q)
    {
        int lcount = 0;
        while(a != null){
            if(a.v >= q){
                a = a.left;
            }else{
                lcount += count(a.left) + 1;
                a = a.right;
            }
        }
        return lcount;
    }

    public static int search(Node a, int q)
    {
        int lcount = 0;
        while(a != null){
            if(a.v == q){
                lcount += count(a.left);
                break;
            }
            if(q < a.v){
                a = a.left;
            }else{
                lcount += count(a.left) + 1;
                a = a.right;
            }
        }
        return a == null ? -(lcount+1) : lcount;
    }

    public static Node next(Node x)
    {
        if(x == null)return null;
        if(x.right != null){
            x = x.right;
            while(x.left != null)x = x.left;
            return x;
        }else{
            while(true){
                Node p = x.parent;
                if(p == null)return null;
                if(p.left == x)return p;
                x = p;
            }
        }
    }

    public static Node prev(Node x)
    {
        if(x == null)return null;
        if(x.left != null){
            x = x.left;
            while(x.right != null)x = x.right;
            return x;
        }else{
            while(true){
                Node p = x.parent;
                if(p == null)return null;
                if(p.right == x)return p;
                x = p;
            }
        }
    }

    public static Node build(int[] a, int l, int r)
    {
        if(l >= r)return null;

        int h = l+r>>1;
        Node root = new Node(a[h]);

        Node L = build(a, l, h);
        root.left = L;
        if(L != null)L.parent = root;

        Node R = build(a, h+1, r);
        root.right = R;
        if(R != null)R.parent = root;

        return update(root);
    }


    public static Node[] nodes(Node a) { return nodes(a, new Node[count(a)], 0, count(a)); }
    public static Node[] nodes(Node a, Node[] ns, int L, int R)
    {
        if(a == null)return ns;
        nodes(a.left, ns, L, L+count(a.left));
        ns[L+count(a.left)] = a;
        nodes(a.right, ns, R-count(a.right), R);
        return ns;
    }

    // faster than nodes but inconsistent
    public static Node[] nodesdfs(Node a) { return nodesdfs(a, new Node[a.count], new int[]{0}); }
    public static Node[] nodesdfs(Node a, Node[] ns, int[] pos)
    {
        if(a == null)return ns;
        ns[pos[0]++] = a;
        nodesdfs(a.left, ns, pos);
        nodesdfs(a.right, ns, pos);
        return ns;
    }

    public static String toString(Node a, String indent)
    {
        if(a == null)return "";
        StringBuilder sb = new StringBuilder();
        sb.append(toString(a.left, indent + "  "));
        sb.append(indent).append(a).append("\n");
        sb.append(toString(a.right, indent + "  "));
        return sb.toString();
    }


}
