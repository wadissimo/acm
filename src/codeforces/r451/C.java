package codeforces.r451;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.ns();
            int cnt = in.ni();
            HashSet<String> list = map.computeIfAbsent(name, k -> new HashSet<>());
            for (int j = 0; j < cnt; j++) {
                list.add(in.ns());
            }
        }
        out.println(map.size());
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            out.print(entry.getKey() + " ");
            String[] nums = new String[entry.getValue().size()];
            int idx = 0;
            for (String num : entry.getValue()) {
                nums[idx++] = num;
            }
            int cnt = nums.length;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if(i!=j && nums[j] != null){
                        if(nums[j].endsWith(nums[i])){
                            nums[i] = null;
                            cnt--;
                            break;
                        }
                    }
                }
            }
            out.print(cnt + " ");
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != null)
                    out.print(nums[i] + " ");
            }
            out.println();
        }
    }
}
