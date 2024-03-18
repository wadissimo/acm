package facebook.hackercup.year2016.r1;

import common.SegmentTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Vadimka on 13.01.2017.
 */
public class A {

    public static int solve(int a[], int n) {
        Arrays.sort(a);
        LinkedList<Integer> s = new LinkedList<Integer>();
        for (int x : a) {
            s.add(x);
        }
        while(s.size() > 0) {

        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("c:/DEV/acm/tests/facebook/year2016/r1/coding_contest_creation_example_input.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2016/r1/coding_contest_creation_example_out.txt"));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(r.readLine()); // number of cycles
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(r.readLine());
            StringTokenizer st = new StringTokenizer(r.readLine());
            int a[] = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println("Case #" +(i+1)+": " + solve(a, n));
        }

    }
}
