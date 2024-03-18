package codeforces.r246;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Vadim_2 on 15.05.2014.
 */
public class TCGen {
    public static void main(String[] args) {
        int[] a = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            while(true) {
                int r = random.nextInt(100000);
                if(a[r] == 0) {
                    a[r] = i+1;
                    break;
                }
            }
        }
        for (int i = 0; i < 100000; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
