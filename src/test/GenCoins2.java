package test;

import java.util.Random;

public class GenCoins2 {
    public static void main(String[] args) {
        int[] q = new int[10000];
        Random rand = new Random();
        long sum = 0;
        long cnt = 0;
        for (int i = 0; i < 1000; i++) {
            cnt++;
            int qi = 0;
            while(true){
                q[qi] = rand.nextInt(2);
                if(qi > 0 && q[qi] == q[qi-1] && q[qi] == 1){
                    sum +=qi+1;
                    break;
                }
                qi++;
            }
        }
        System.out.println(sum/cnt);
    }
}
