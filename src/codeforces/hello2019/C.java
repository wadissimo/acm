package codeforces.hello2019;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String [] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ns();
        }
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            String s = a[i];
            int sn = s.length();
            for (int j = 0; j < sn; j++) {
                if(s.charAt(j) == '(')
                    left[i]++;
                else
                    left[i]--;
                if(left[i] < 0){
                    break;
                }
            }
        }
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(left[i] >= 0){
                LinkedList<Integer> list = map.computeIfAbsent(left[i], k -> new LinkedList<>());
                list.add(i);
            }
        }
        int[] right = new int[n];
        boolean[] used = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String s = a[i];
            int sn = s.length();
            for (int j = sn-1; j >= 0; j--) {
                if(s.charAt(j) == '(')
                    right[i]--;
                else
                    right[i]++;
                if(right[i] < 0){
                    break;
                }
            }
            if (right[i] >= 0 && !used[i]){
                LinkedList<Integer> list = map.get(right[i]);
                if(list != null){
                    Iterator<Integer> it = list.iterator();
                    while (it.hasNext()) {
                        int id =  it.next();
                        if(used[id]){
                            it.remove();
                            continue;
                        }
                        if(id != i){
                            ans ++;
                            used[i] = true;
                            used[id] = true;
                            //System.out.printf("%d %d%n", i, id);
                            break;
                        }

                    }
                }
            }
        }
        out.println(ans);
    }
}
