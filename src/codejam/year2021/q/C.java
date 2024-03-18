package codejam.year2021.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    void reverse(int[] a, int from, int to){
        int left = from, right = to;
        while(left < right){
            int tmp = a[right];
            a[right] = a[left];
            a[left] = tmp;
            left++;
            right--;
        }
    }

    int test(int[]aa){
        int cost = 0;
        int n = aa.length;
        int[]a = new int[n];
        System.arraycopy(aa, 0, a, 0, n);
        for (int i = 0; i < n-1; i++) {
            int min = a[i];
            int idx = i;
            for (int j = i+1; j < n; j++) {
                if(a[j] < min){
                    min = a[j];
                    idx = j;
                }
            }
            cost += idx-i+1;
            int left = i, right = idx;
            while(left < right){
                int tmp = a[right];
                a[right] = a[left];
                a[left] = tmp;
                left++;
                right--;
            }
        }
        return cost;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            int c = in.ni();
            int c_orig = c;
            if(c < n - 1 || c > (n*(n+1)/2 - 1)){
                out.printf("Case #%d: IMPOSSIBLE%n", t+1);
                continue;
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = i+1;
            }
            c-=n-1;
            int from = 0;
            int to = n-1;
            int left = n-1;
            int idx = 0;
            int j = 0;
            while(c > 0){
               if(c <= to-from){
                   reverse(a, from, from+c);
                   break;
               } else {
                   reverse(a, from, to);
                   c-=to-from;
                   if(j%2 == 0){
                       to--;
                   } else {
                       from++;
                   }
               }
               j++;
            }
            /*if(test(a) != c_orig){
                System.out.println("wrong answer");
                return;
            }*/
            out.printf("Case #%d:", t+1);
            for (int i = 0; i < n; i++) {
                out.print(" " + a[i]);
            }
            out.println();

        }

    }
}
