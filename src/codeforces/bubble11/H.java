package codeforces.bubble11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Long, Integer> counts = new HashMap<>();
        HashMap<Long, Integer> lens = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            char[] sc = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                sc[j]=s.charAt(j);
            }
            Arrays.sort(sc);
            int counter = 1;
            long key = 0;
            int len = 0;
            for (int j = 1; j < s.length(); j++) {
                if(sc[j]==sc[j-1])
                    counter++;
                else{
                    if(counter%2 == 1) {
                        key |= 1 << (sc[j - 1] - 'a');
                        len++;
                    }
                    counter = 1;
                }
            }
            if(counter%2 == 1) {
                key |= 1 << (sc[s.length() - 1] - 'a');
                len++;
            }
            lens.put(key, len);
            counts.put(key, counts.getOrDefault(key, 0) +1);
        }
        long ans = 0;
        for (Map.Entry<Long, Integer> entry : counts.entrySet()) {
            long key = entry.getKey();
            long cnt = entry.getValue();
            ans += cnt*(cnt-1)/2;
            for (int i = 0; i < 28; i++) {
                int mask = 1 << i;
                if((key&mask) != 0){
                    long pair = key&(~mask);
                    Integer pc = counts.get(pair);
                    if(pc != null) {
                        ans += cnt*pc;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
