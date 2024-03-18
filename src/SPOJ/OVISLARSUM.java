package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class OVISLARSUM {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long mod7 = 1000000007L;
        long l = in.nl()%mod7;
        long r = in.nl()%mod7;
        long mod = in.nl()%mod7;
        long ans = 0;
        if (r - l >= mod) {
            long c = (r - l) / mod;
            ans = (((mod-1)*mod/2)%mod7)*c;
            ans %= mod7;
            r -= c * mod;
        }
        long lr = l % mod;
        long rr = r % mod;
        if (rr >= lr) {
            ans += (lr+rr)*(rr-lr+1)/2;
        } else{
            ans += (lr+mod-1)*(mod-lr)/2;
            ans %= mod7;
            ans += (rr+1)*rr/2;
        }
        out.println(ans%mod7);

    }
}
