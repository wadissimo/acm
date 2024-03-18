package codeforces.r543;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class D {
    boolean check(int left, int right, int n, int m, int k){
        int before = left/k;
        right = Math.max(right, before*k + k-1);
        int after = (m-1-right)/k;
        if(before + after +1 >= n)
            return true;
        else return false;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int m = in.ni(), k = in.ni(), n = in.ni(), s = in.ni();
        int[] a = in.na(m);
        int[] b = in.na(s);
        int[] need = new int[500_007];
        for (int i = 0; i < s; i++) {
            need[b[i]]++;
        }
        int needCnt = 0;
        for (int i = 0; i < need.length; i++) {
            if(need[i] != 0)
                needCnt++;
        }
        int left = 0, right = -1;
        int miss = needCnt;
        int[] cnt = new int[500_007];
        boolean found = false;
        while(left < m){
            if(miss == 0 && left == m-1){
                break;
            }
            while(miss == 0 && left < m){
                if(need[a[left]] > 0){
                    cnt[a[left]]--;
                    if(cnt[a[left]] < need[a[left]]) {
                        miss++;
                    }
                }
                left++;
                if(miss == 0 && check(left, right, n, m, k)){
                    break;
                }
            }
            if(miss == 0 && check(left, right, n, m, k)){
                found = true;
                break;
            }
            while(miss > 0 && right < m-1){
                right++;
                if(need[a[right]] > 0){
                    cnt[a[right]]++;
                    if(cnt[a[right]] == need[a[right]])
                        miss--;
                }

            }
            if(miss > 0 && right == m-1)
                break;
            if(miss == 0 && check(left, right, n, m, k)){
                found = true;
                break;
            }
        }
        if(found){
            int ans = 0;
            List<Integer> res = new LinkedList<>();
            int start = left/k*k;
            int remove = right-start+1-k;
            for (int i = start; i <= right && remove > 0; i++) {
                if (need[a[i]] == 0 || cnt[a[i]] > need[a[i]]) {
                    ans++;
                    res.add(i + 1);
                    if(need[a[i]] > 0)
                        cnt[a[i]]--;
                    remove--;
                }
            }
            out.println(ans);
            for(int id: res){
                out.print(id + " ");
            }
        } else {
            out.println(-1);
        }
    }
}
