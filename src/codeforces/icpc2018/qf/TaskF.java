package codeforces.icpc2018.qf;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class TaskF {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int input[][] = new int[n][2];
        int c11 = 0;
        int c10 = 0;
        int c01 = 0;
        int c00 = 0;
        for (int i = 0; i < n; i++) {
            input[i][0] = in.ni();
            input[i][1] = in.ni();
            if(input[i][0] == 0)
                c00++;
            else if(input[i][0] == 10)
                c10++;
            else if(input[i][0] == 1)
                c01++;
            else if(input[i][0] == 11)
                c11++;
        }
        int[] a11 = new int[c11];
        int[] a10 = new int[c10];
        int[] a01 = new int[c01];
        int[] a00 = new int[c00];
        c11=c10=c01=c00= 0;
        for (int i = 0; i < n; i++) {
            if(input[i][0] == 0)
                a00[c00++] = input[i][1];
            else if(input[i][0] == 10)
                a10[c10++] = input[i][1];
            else if(input[i][0] == 1)
                a01[c01++] = input[i][1];
            else if(input[i][0] == 11)
                a11[c11++] = input[i][1];
        }
        long ans = 0;
        int cnt = 0;
        for (int i = 0; i < a11.length; i++) {
            cnt++;
            ans += a11[i];
        }
        if(a10.length > a01.length){
            int[] t = a10;
            a10 = a01;
            a01 = t;
        }
        Arrays.sort(a01);
        for (int i = 0; i < a10.length; i++) {
            ans += a10[i];
            ans += a01[a01.length-i-1];
        }
        int[] sorted = new int[a00.length+a01.length-a10.length];
        int si = 0;
        for (int i = 0; i < a01.length - a10.length; i++) {
            sorted[si++] = a01[i];
        }
        for (int i = 0; i < a00.length; i++) {
            sorted[si++] = a00[i];
        }
        Arrays.sort(sorted);
        for (int i = 0; i < cnt && i<sorted.length; i++) {
            ans += sorted[sorted.length-i-1];
        }
        out.println(ans);
    }
}
