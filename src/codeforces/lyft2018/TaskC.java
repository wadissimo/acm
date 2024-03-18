package codeforces.lyft2018;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int []a = in.na(n);
        HashMap<Integer,Integer> posMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            posMap.put(a[i], i);
        }
        int ans[] = new int[n];
        ans[posMap.get(n)] = 1;//Bob
        for (int i = n-1; i > 0; i--) {
            int pos = posMap.get(i);
            boolean found = false;
            for (int j = pos-i; j >= 0 ; j-=i) {
                if(a[j] > i && ans[j] == 1){
                    found = true;
                    break;
                }
            }
            if(!found)
                for (int j = pos+i; j < n ; j+=i) {
                    if(a[j] > i && ans[j] == 1){
                        found = true;
                        break;
                    }
                }
            if(found)
                ans[pos] = -1;
            else
                ans[pos] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((ans[i] == 1)?'B':'A');
        }
        out.println(sb.toString());
    }
}
