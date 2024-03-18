package codeforces.r555;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int first = 0;
        int last = n-1;
        StringBuilder ans = new StringBuilder();
        int prev = -1;
        while(first <= last) {
            if(a[first] > prev && (a[last] <= prev || a[first] < a[last])){
                prev = a[first];
                ans.append('L');
                first++;
            } else if(a[last] > prev && (a[first] <= prev || a[first] > a[last])){
                prev = a[last];
                ans.append('R');
                last--;
            } else if(a[first] > prev && a[first] == a[last]){
                int left = 1;
                for (int i = first+1; i < last ; i++) {
                    if(a[i] <= a[i-1])
                        break;
                    left++;
                }
                int right = 1;
                for (int i = last-1; i > first; i--){
                    if(a[i] <= a[i+1])
                        break;
                    right++;
                }
                if(left > right){
                    while(left > 0){
                        ans.append('L');
                        left--;
                    }
                } else {
                    while(right > 0){
                        ans.append('R');
                        right--;
                    }
                }
                break;
            } else
                break;
        }
        out.println(ans.length());
        out.println(ans.toString());
    }
}
