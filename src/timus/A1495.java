package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class A1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());

        if(n == 1 || n == 2) {
            System.out.println(n);
            return;
        }
        long[] drem= new long[30];
        drem[0] = 1;
        for (int i = 1; i < 30; i++) {
            drem[i] = (drem[i-1]*10)%n;
        }

        long[] drem2= new long[30];
        drem2[0] = 2;
        for (int i = 1; i < 30; i++) {
            drem2[i] = (drem2[i-1]*10)%n;
        }



        //System.out.println(Arrays.toString(drem));
        Set<Long> hash = new HashSet<Long>((int)(n/0.75));
        long[][] d= new long[16][1<<16];
        long[][] d2= new long[16][1<<16];
        d[0][0] = 0;
        d2[0][0] = 0;
        for (int l = 1; l < 16; l++) {
            for (int i = 0; i < 1<<(l-1); i++) {
                d[l][i] = (d[l-1][i] + drem[l-1])%n;
                d2[l][i] = (d2[l-1][i] + drem[14 + l])%n;
                if(d[l][i] == 0) {
                    System.out.print("1");
                    String binary = Integer.toBinaryString(i).replaceAll("1", "2").replaceAll("0", "1");
                    for (int j = 0; j < l-1 - binary.length(); j++) {
                        System.out.print("1");
                    }
                    System.out.println(binary);

                    return;
                } else if(l==15){
                    hash.add(d[l][i]);
                }
            }
            for (int i = 0; i < 1<<(l-1); i++) {
                int i2 = i + (1 << (l - 1));
                d[l][i2] = (d[l-1][i] + drem2[l-1])%n;
                d2[l][i2] = (d2[l-1][i] + drem2[14 + l])%n;
                if(d[l][i2] == 0) {
                    System.out.print("2");
                    String binary = Integer.toBinaryString(i).replaceAll("1", "2").replaceAll("0", "1");
                    for (int j = 0; j < l-1 - binary.length(); j++) {
                        System.out.print("1");
                    }
                    System.out.println(binary);

                    return;
                } else if(l==15){
                    hash.add(d[l][i2]);
                }
            }

            //System.out.println(Arrays.toString(d[l]));
        }


        for (int l = 1; l < 16; l++) {
            for (int i = 0; i < 1 << l; i++) {
                if(hash.contains(n-d2[l][i])) {

                    String binary = Integer.toBinaryString(i).replaceAll("1", "2").replaceAll("0", "1");
                    for (int m = 0; m < l - binary.length(); m++) {
                        System.out.print("1");
                    }
                    System.out.print(binary);

                    for (int k = 0; k < 1 << 15; k++) {
                        if(d[15][k] == n-d2[l][i]){
                            binary = Integer.toBinaryString(k).replaceAll("1", "2").replaceAll("0", "1");
                            for (int m = 0; m < 15 - binary.length(); m++) {
                                System.out.print("1");
                            }
                            System.out.println(binary);

                            return;
                        }
                    }

                }
            }
        }
        System.out.println("Impossible");

    }
}
