package yandex.warmup;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 16.05.2014.
 */
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String af = reader.readLine();
        String bf = reader.readLine();
        List<String> as = new ArrayList<String>();
        StringBuilder ab = new StringBuilder();
        for (int i = 0; i <af.length(); i++) {
            char c = af.charAt(i);
            if(c >='A' && c<='Z' || c >='a' && c <='z') {
                ab.append(c);
            } else {
                if(ab.length() > 0) {
                    as.add(ab.toString().toLowerCase());
                    ab = new StringBuilder();
                }
            }
        }
        if(ab.length() > 0) {
            as.add(ab.toString().toLowerCase());
        }
        List<String> bs = new ArrayList<String>();
        StringBuilder bb = new StringBuilder();
        for (int i = 0; i <bf.length(); i++) {
            char c = bf.charAt(i);
            if(c >='A' && c<='Z' || c >='a' && c <='z') {
                bb.append(c);
            }else {
                if(bb.length() > 0) {
                    bs.add(bb.toString().toLowerCase());
                    bb = new StringBuilder();
                }
            }
        }
        if(bb.length() > 0) {
            bs.add(bb.toString().toLowerCase());
        }


        String s = reader.readLine();

        StringTokenizer st = new StringTokenizer(reader.readLine());
        BigInteger k = new BigInteger(st.nextToken());
        int an = 0;
        for (String a : as) {
            if(a.equals(s)) an++;
        }
        int bn = 0;
        for (String b : bs) {
            if(b.equals(s)) bn++;
        }


        BigInteger tn2 = BigInteger.valueOf(an);
        if(k.compareTo(tn2)<=0) {
            if(k.compareTo(tn2)==0) {
                System.out.println(0);
            }else {
                System.out.println("Impossible");
            }
            return;
        }

        BigInteger tn1 = BigInteger.valueOf(bn);
        if(k.compareTo(tn1)<=0) {
            if(k.compareTo(tn1)==0) {
                System.out.println(1);
            }else {
                System.out.println("Impossible");
            }
            return;
        }


        BigInteger fr = tn2.add(tn1);
        if(fr.compareTo(BigInteger.ZERO) == 0) {
            System.out.println("Impossible");
            return;
        }
        BigInteger i = BigInteger.valueOf(2);
        while(true){
            fr = tn2.add(tn1);
            if(k.compareTo(fr)<=0) {
                if(k.compareTo(fr) == 0) {
                    System.out.println(i);
                }else {
                    System.out.println("Impossible");
                }
                return;
            }
            tn2 = tn1;
            tn1 = fr;
            i = i.add(BigInteger.ONE);
        }
    }
}
