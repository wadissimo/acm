package chelper.memsqlr2;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.readLine();
        int n = in.ni();
        int a[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c-'a']++;

        }
        int left = 0;
        int right = 1001;
        while(left < right) {
            int mid = (left + right) >>>1;
            int length = 0;
            for (int i = 0; i < 26; i++) {
                length += a[i]/mid;
                if(a[i]%mid != 0) {
                    length++;
                }
            }
            if(length > n) {
                left = mid+1;
            }else {
                right = mid;
            }
        }
        if(left == 1001) {
            System.out.println(-1);
        } else {

            out.println(left);
            StringBuilder sb = new StringBuilder();
            int length = 0;
            for (int i = 0; i < 26; i++) {
                int rep = a[i] / (left);
                if (a[i] % (left) != 0) {
                    rep++;
                }
                for (int j = 0; j < rep; j++) {
                    sb.append((char) (i + 'a'));
                    length++;
                }
            }
            for (int i = 0; i < n - length; i++) {
                sb.append(sb.charAt(0));
            }

            out.println(sb);
        }

    }
}
