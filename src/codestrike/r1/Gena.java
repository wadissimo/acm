package codestrike.r1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Vadim_2 on 23.04.2014.
 */
public class Gena {
    private static class Friend implements Comparable{
        public long x;
        public long k;
        public int t;

        private Friend(long x, long k) {
            this.x = x;
            this.k = k;

        }

        @Override
        public int compareTo(Object o) {
            return Long.compare(this.k, ((Friend)o).k);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());


        int n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken());

        long b = Integer.parseInt(st.nextToken());

        List<Friend> friends = new ArrayList<Friend>(n);


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            long xi = Integer.parseInt(st.nextToken());
            long ki = Integer.parseInt(st.nextToken());
            int mi = Integer.parseInt(st.nextToken());
            Friend friend = new Friend(xi, ki);
            friends.add(friend);

            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < mi; j++) {
                int ntask = Integer.parseInt(st.nextToken());
                friend.t |= 1<<(ntask - 1);
            }
        }
        Collections.sort(friends);

        long[] d = new long[1<<m];
        long[] dp = new long[1<<m];

        Arrays.fill(d, Long.MAX_VALUE);
        Arrays.fill(dp, Long.MAX_VALUE);
        d[0] = 0;
        dp[0] = 0;
        long minp = Long.MAX_VALUE;

        for (Friend friend : friends) {
            for (int i = 0; i < 1 << m; i++) {
                if(d[i] != Long.MAX_VALUE && i != (i|friend.t)) {
                    long np = d[i] +  friend.x;
                    if (np < d[i | friend.t]) {
                        d[i | friend.t] = np;
                    }
                }
            }
            if(d[(1<<m)-1] != Long.MAX_VALUE) {
                minp = Math.min(minp, d[(1<<m)-1] + friend.k*b);
            }
            
        }
//        System.out.println(Arrays.toString(d));
//        System.out.println(Arrays.toString(dp));
        if(minp < Long.MAX_VALUE) {
            System.out.println(minp);
        } else {
            System.out.println(-1);
        }
    }
}
