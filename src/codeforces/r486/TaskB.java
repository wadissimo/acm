package codeforces.r486;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        boolean ans = true;
        TreeMap<Integer, String> map = new TreeMap<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = in.ns();
            int len = s.length();
            String t = map.get(len);
            if(t==null) {
                cnt.put(len, 1);
                map.put(len, s);
            }else{
                cnt.put(len,cnt.get(len)+1);
                if(!t.equals(s)){
                    ans = false;
                }
            }
        }
        if(ans) {
            String prev = null;
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                for (int i = 0; i < cnt.get(entry.getKey()); i++) {
                    if(prev!=null && !entry.getValue().contains(prev)){
                        ans = false;
                        break;
                    }
                    sb.append(entry.getValue()).append('\n');
                    prev = entry.getValue();
                }
            }
            if(ans) {
                out.println("YES");
                out.println(sb.toString());
            } else {
                out.println("NO");
            }

        }else
            out.println("NO");
    }
}
