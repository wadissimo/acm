package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Vadim_2 on 05.05.2014.
 */
public class A1495a {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        if(n == 1 || n == 2) {
            System.out.println(n);
            return;
        }
        int[] drem= new int[30];
        drem[0] = 1;
        for (int i = 1; i < 30; i++) {
            drem[i] = (drem[i-1]*10)%n;
        }

        Map<Integer, Integer>[] remainders = new Map[30];
        remainders[0] = new HashMap<Integer, Integer>();
        remainders[0].put(1,1);
        remainders[0].put(2,2);

        for (int i = 1; i < 30; i++) {
            int r1 = drem[i];
            int r2 = (drem[i]*2)%n;
            if(remainders[i-1].containsKey(n-r1) || remainders[i-1].containsKey(n-r2)) {
                int rem;
                if(remainders[i-1].containsKey(n-r1)) {
                    System.out.print("1");
                    rem = n-r1;
                } else {
                    System.out.print("2");
                    rem = n-r2;
                }
                for (int j = i-1; j >=0; j--) {
                    Integer curRem = remainders[j].get(rem);
                    System.out.print(curRem);
                    rem = (rem - (curRem*drem[j])%n + n)%n;
                }

                System.out.println("");
                return;
            }
            remainders[i] = new HashMap<Integer, Integer>();
            for (Integer remainder : remainders[i - 1].keySet()) {
                int i1 = (remainder + r1) % n;
                int i2 = (remainder + r2) % n;
                remainders[i].put(i1, 1);
                if(!remainders[i].containsKey(i2)) {
                    remainders[i].put(i2, 2);
                }
            }

        }
        System.out.println("Impossible");
    }
}
