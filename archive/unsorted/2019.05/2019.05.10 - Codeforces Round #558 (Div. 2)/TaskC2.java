package main;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class TaskC2 {
    class Line{
        int a, b;
        long y0;
        long k;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int p = 1_000_003;
        double mult = 1_000_000d;
        long[] invs = IntegerUtils.invs(p, p);
        int n = in.ni();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            y[i] = in.ni();
        }
        LinkedList<Line>[] lines = new LinkedList[p+1];
        for (int i = 0; i <= p; i++) {
            lines[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                Line line = new Line();
                line.a = x[j]-x[i];
                line.b = y[j]-y[i];
                if(line.a < 0) {
                    line.b *= -1;
                    line.a *= -1;
                }
                if(line.b == 0){
                    lines[p].add(line);
                    line.y0 = y[i];
                } else {
                    line.k = Math.round((double)line.a/line.b*mult);
                    line.y0 = Math.round((x[i] - (double)y[i]*line.a/line.b)*mult);
                    lines[(int)(line.a*invs[Math.abs(line.b)]%p)].add(line);
                }
            }
        }
        LinkedList<Integer> ans = new LinkedList<>();
        LinkedList<Line> rest = new LinkedList<>();
        int total = 0;
        for (int i = 0; i <= p; i++) {
            while(!lines[i].isEmpty()){
                Line first = lines[i].pollFirst();
                if(lines[i].isEmpty()){
                    ans.add(1);
                    total += 1;
                    break;
                }

                TreeSet<Long> set = new TreeSet<>();
                set.add(first.y0);
                while(!lines[i].isEmpty()){
                    Line line = lines[i].pollFirst();
                    if(line.k != first.k){
                        rest.add(line);
                    } else {
                        set.add(line.y0);
                    }
                }
                ans.add(set.size());
                total += set.size();
                if(!rest.isEmpty()){
                    LinkedList<Line> tmp = rest;
                    rest = lines[i];
                    lines[i] = tmp;
                }
            }
        }
        long res = 0;
        for (Integer num : ans) {
            res += num*(total-num);
        }
        out.println(res/2);

    }
}
