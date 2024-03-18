package atcoder.beginner.r121;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class C {
    class Store{
        long cnt, price;

        public Store(int price, int cnt) {
            this.cnt = cnt;
            this.price = price;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        Store[] stores = new Store[n];
        for (int i = 0; i < n; i++) {
            stores[i] = new Store(in.ni(), in.ni());
        }
        Arrays.sort(stores, Comparator.comparingLong(o -> o.price));
        long ans = 0;
        for (Store store : stores) {
            if(store.cnt < m){
                ans +=  store.cnt*store.price;
                m-=store.cnt;
            } else {
                ans+=m*store.price;
                m =0;
                break;
            }
        }
        if(m > 0)
            throw new RuntimeException("not enough minerals");
        out.println(ans);

    }
}
