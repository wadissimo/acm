package codeforces.bubble11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class A1 {
    static class Node implements Comparable<Node>{
        int x,l;

        public Node(int x, int l) {
            this.x = x;
            this.l = l;
        }

        @Override
        public int compareTo(Node o) {
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
    static class FenwickTree {
        int n;
        int[] t;
        public FenwickTree(int n) {
            this.n = n;
            t = new int[n];
        }
        public int get(int r) {
            int ans = 0;
            while (r >= 0) {
                ans += t[r];
                r = (r & (r + 1)) - 1;
            }
            return ans;
        }
        public void add(int pos, int val) {
            while (pos < n) {
                t[pos] += val;
                pos |= pos + 1;
            }
        }
    }
    static class SubTask{
        Node[] leftEnds;
        int xbound = 0;
        int lefti = 0;
        int sx[];
        HashMap<Integer,Integer> fenMap;
        FenwickTree tree;

        public SubTask(ArrayList<Node> list) {
            int size = list.size();
            leftEnds = new Node[size];
            sx = new int[size];
            int i = 0;
            for (Node node : list) {
                leftEnds[i] = node;
                sx[i++] = node.x;
            }
            Arrays.sort(leftEnds);
            Arrays.sort(sx);
            fenMap = new HashMap<>(size);
            fenMap.put(sx[0], 1);
            int fenSize = 2;
            for (int j = 1; j < size; j++) {
                if(sx[j] != sx[j-1])
                    fenMap.put(sx[j], fenSize++);
            }
            tree = new FenwickTree(fenSize+7);
        }
    }
    static int bisectRight(int [] arr, int val, int lo, int hi){
        int low = lo;
        int high = hi;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= val)
                low = mid+1;
            else
                high = mid;
        }
        return low;
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
        HashMap<Integer, ArrayList<Node>> iqlm = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> iqxc = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            r[i] = Integer.parseInt(st.nextToken());
            q[i] = Integer.parseInt(st.nextToken());
            sx[i] = new Robot(x[i], r[i], q[i]);
            ArrayList<Node> la = iqlm.computeIfAbsent(q[i], k1 -> new ArrayList<>());
            la.add(new Node(x[i], x[i]-r[i]));
            HashMap<Integer, Integer> xm = iqxc.computeIfAbsent(q[i], k1 -> new HashMap<Integer, Integer>());
            xm.put(x[i], xm.getOrDefault(x[i], 0)+1);
        }
        HashMap<Integer, SubTask> subTasks = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Node>> entry : iqlm.entrySet()) {
            subTasks.put(entry.getKey(), new SubTask(entry.getValue()));
        }
        Arrays.sort(sx);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int cx = sx[i].x;
            int rightBound = cx + sx[i].r;
            for (int iq = sx[i].q-k; iq <= sx[i].q+k; iq++) {
                SubTask subTask = subTasks.get(iq);
                if(subTask == null)
                    continue;

                Node[] leftEnds = subTask.leftEnds;
                HashMap<Integer, Integer> fenMap = subTask.fenMap;
                FenwickTree tree = subTask.tree;
                while(subTask.lefti < leftEnds.length && leftEnds[subTask.lefti].l <= cx) {
                    int fenx = fenMap.get(leftEnds[subTask.lefti].x);
                    tree.add(fenx, 1);
                    subTask.lefti++;
                }

                int size = subTask.sx.length;

                if(subTask.xbound < size) {
                    if(subTask.sx[subTask.xbound] <= cx)
                        subTask.xbound = bisectRight(subTask.sx, cx, 0, size);
                    if(subTask.xbound < size) {
                        int fromSum = tree.get(fenMap.get(subTask.sx[subTask.xbound]) - 1);
                        int rbound = bisectRight(subTask.sx, rightBound, subTask.xbound, size);
                        if (rbound > 0) {
                            int toSum = tree.get(fenMap.get(subTask.sx[rbound - 1]));
                            if (toSum - fromSum > 0)
                                ans += toSum - fromSum;
                        }
                    }
                }

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
}