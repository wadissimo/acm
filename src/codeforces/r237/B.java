package codeforces.r237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        double a = Double.parseDouble(st.nextToken());
        double d = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            double nd = d * ((i + 1) * 1.0);
            double rem = nd - Math.floor(nd /(4.0*a))*4.0*a;
            if(rem >= 3.0*a) {
                System.out.println(0.0 + " "+ (4.0*a - rem));
            } else if( rem >=2.0*a){
                System.out.println((3.0*a-rem)+" "+a);
            } else if(rem >= a){
                System.out.println(a+" " +(rem - a));
            } else {
                System.out.println(rem + " " + 0.0);
            }

        }

    }
}
