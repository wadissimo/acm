package codeforces.r510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D {
    static class Node{
        int ind;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        long prefix[] = new long[n];
        TreeMap<Long, Integer> map = new TreeMap<>();
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if(i==0)
                prefix[0]=a[0];
            else
                prefix[i]+=a[i]+prefix[i-1];
            map.merge(prefix[i], 1, (a1, b) -> a1 + b);
        }
        long sorted[] = Arrays.copyOf(prefix, n);

        Arrays.sort(sorted);

        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            map.put(sorted[i], count);
        }
        long dif = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {

            Map.Entry<Long, Integer> entry = map.floorEntry(t-1 + dif);
            if(entry != null)
                ans += entry.getValue();
            dif += a[i];
        }
        System.out.println(ans);

    }
}
