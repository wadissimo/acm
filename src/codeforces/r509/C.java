package codeforces.r509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        TreeMap<Integer, LinkedList<Integer>> tree = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            LinkedList<Integer> set = tree.computeIfAbsent(a, k -> new LinkedList<>());
            set.add(i);
        }
        int day = 0;
        int[] ans = new int[n];
        while(!tree.isEmpty()){
            Map.Entry<Integer, LinkedList<Integer>> entry = tree.firstEntry();
            while(!tree.isEmpty()){
                Integer ind = entry.getValue().removeLast();
                ans[ind] = day+1;
                if(entry.getValue().isEmpty()) {
                    tree.remove(entry.getKey());
                }
                entry = tree.ceilingEntry(entry.getKey()+d+1);
                if(entry == null){
                    day+=1;
                    break;
                }
            }
        }
        System.out.println(day);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}
