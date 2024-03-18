package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 09.05.2014.
 */
public class A1018 {
    static List<Integer>[] tree;
    static boolean[] used;
    static int[][] branches;
    static int[] counts;

    static int[] getMax(int node, int count){
        used[node] = true;
        Integer aNode = null;
        Integer bNode = null;
        int aCount = 0;
        int bCount = 0;
        //find leaves
        for (Integer childBranch : tree[node]) {
            int childNode = branches[childBranch][0];
            if(childNode == node) {
                childNode = branches[childBranch][1];
            }
            if(!used[childNode]) {
                if(aNode == null) {
                    aNode = childNode;
                    aCount = counts[childBranch];
                }else{
                    bNode = childNode;
                    bCount = counts[childBranch];
                }
            }
        }
        if(bNode == null) {
            if(aNode == null) {
                //end point
                return null;
            } else {
                //one node
                int[] aMax = getMax(aNode, aCount);

            }
        }
        return null;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        tree = new List[n];
        counts = new int[n];
        used = new boolean[n];
        branches = new int[n][2];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<Integer>(3);
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            branches[i][0] = a;
            branches[i][1] = b;
            counts[i] = count;
            tree[a-1].add(i);
            tree[b-1].add(i);
        }


    }
}
