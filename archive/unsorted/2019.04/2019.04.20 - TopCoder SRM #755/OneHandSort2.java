package main;

import java.util.TreeSet;

public class OneHandSort2 {
    public int minMoves(int N, int[] targetPrefix, int a, int b) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            set.add(i);
        }
        int l = targetPrefix.length;
        int[] target = new int[N];
        for (int i = 0; i < l; i++) {
            target[i] = targetPrefix[i];
            set.remove(target[i]);
        }
        for (int i = l; i < N; i++) {
            //tmp = ( target[i-1] * a + b ) modulo N
//            x = the smallest number in the range [tmp,N-1] that does not appear in the set { target[0], ..., target[i-1] }
//            if such an x does not exist:
//            x = the smallest number in the range [0,N-1] that does not appear in the set { target[0], ..., target[i-1] }
//            target[i] = x
            int tmp = (int)(((long)target[i-1]*a + b)%N);
            Integer next = set.ceiling(tmp);
            if(next == null){
                next = set.pollFirst();
            } else {
                set.remove(next);
            }
            target[i] = next;
        }
        boolean[] used = new boolean[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(!used[i]){
                used[i] = true;
                int cycleLen = 1;
                int cur = target[i];
                while(cur != i){
                    used[cur] = true;
                    cur = target[cur];
                    cycleLen ++;
                }
                if(cycleLen > 1){
                    ans+=cycleLen+1;
                }
            }
        }
        return ans;
    }
}
