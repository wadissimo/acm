package coursera.algo;

import common.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 14.05.2014.
 */
public class ATest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> l = new ArrayList<Integer>();
        String s = reader.readLine();
        for (StringTokenizer st = new StringTokenizer(s); st.hasMoreTokens(); ) {
            l.add(Integer.parseInt(st.nextToken()));
        }

        int[] a = new int[l.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = l.get(i);
        }


        System.out.println(ArrayUtils.countInversions(a));


    }
}
