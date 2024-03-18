package chelper.r236;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int k = in.ni();
        int a = in.ni();
        int b = in.ni();
        int v = in.ni();
        int maxBoxes = b/(k-1);
        int rem = b % (k-1);
        int nutsPerMaxBox = v*k;
        if(maxBoxes*nutsPerMaxBox >= a) {
            int ans = a/nutsPerMaxBox;
            if(a % nutsPerMaxBox > 0) {
                ans++;
            }
            out.println(ans);
        } else {
            a-= maxBoxes*nutsPerMaxBox;
            int ans = maxBoxes;
            if(rem > 0) {
                ans ++;
                if(a < v*(rem+1)) {
                    out.println(ans);
                    return;
                } else {
                    a-= v*(rem+1);
                }
            }
            ans +=  a/v;
            if(a%v > 0) {
                ans++;
            }
            out.println(ans);
        }
    }
}
