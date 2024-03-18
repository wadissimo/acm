package main;

public class EllysAndXor {
    public int getMax(int[] numbers) {
        int n = numbers.length;
        int max = 0;
        for (int mask = 0; mask < (1 << (n - 1)); mask++) {
            int res = numbers[0];
            for (int i = 0; i < n - 1; i++) {
                if((mask&(1<<i)) == 0){
                    res = res^numbers[i+1];
                } else
                    res = res&numbers[i+1];
            }
            max = Math.max(res, max);
        }
        return max;
    }
}
