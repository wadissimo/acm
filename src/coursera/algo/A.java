package coursera.algo;

import common.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(A.class.getResourceAsStream("IntegerArray.txt")));

        List<Integer> l = new ArrayList<Integer>();
        String s;
        while((s = reader.readLine()) != null) {
            l.add(Integer.parseInt(s));
        }
        int[] a = new int[l.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = l.get(i);
        }

        System.out.println(a.length);


        System.out.println(ArrayUtils.countInversions(a));


    }
}
