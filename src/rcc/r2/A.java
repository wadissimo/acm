//package rcc.r2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 18.05.2014.
 */
public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if(p<q) {
                int tmp = p;
                p = q;
                q = tmp;
                tmp = n;
                n = m;
                m = tmp;
            }
            int ans = 0;
            int pTasks = t/p;
            int pPpl = n/pTasks;
            int pRem = n%pTasks;
            int remTime = t - pRem*p;
            ans=pPpl+1;
            if(pRem == 0) {
                ans--;
                remTime = t%p;
            }


            if (remTime >= q) {
                m -= (remTime / q);
            }

            if(m>0) {
                int qTasks = t/q;
                int qPpl = m/qTasks;
                ans += qPpl;
                int qRem = m%qTasks;
                if(qRem > 0) {
                    ans++;
                }
            }
            System.out.println(ans);
        }





    }


}
