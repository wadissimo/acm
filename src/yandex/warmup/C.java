package yandex.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 16.05.2014.
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        Map<BigDecimal, Integer> freq = new HashMap<BigDecimal, Integer>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            double p = (a + b + c)*0.5;

            BigDecimal r = new BigDecimal((p-a)*(p-b)*(p-c));
            r = r.divide(new BigDecimal(p), 100, BigDecimal.ROUND_HALF_UP);

            Integer fr = freq.get(r);
            if(fr == null) {
                freq.put(r, 1);
            } else {
                freq.put(r, fr+1);
            }
        }

        int max = -1;
        for (Integer value : freq.values()) {
            if(value > max) {
                max = value;
            }

        }


        System.out.println(max);

    }
}
