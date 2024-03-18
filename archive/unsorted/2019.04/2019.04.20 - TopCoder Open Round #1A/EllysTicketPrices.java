package main;

public class EllysTicketPrices {
    private long calc(int N, long init, int[] C){
        long sum = init;
        long cur = init;
        for (int i = 0; i < N-1; i++) {
            cur = cur + Math.round(cur*(double)C[i]/100.0);
            sum+= cur;
        }
        return sum;
    }
    public double getPrice(int N, int[] C, int target) {
        long from = 0, to = 1_000_000_000;
        long tgt = target*100*N;
        while(from < to){
            long mid = (from+to)/2;
            long sum = calc(N, mid, C);
            if(sum < tgt){
                from = mid+1;
            } else{
                to = mid;
            }
        }
        if(Math.abs(calc(N, from, C)-tgt) < Math.abs(calc(N, from-1, C)-tgt)){
            return from/100D;
        } else
            return (from-1)/100D;
    }
}
