package codeforces.r550;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        Arrays.sort(a);
        Stack<Integer> odd = new Stack<>();
        Stack<Integer> even = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(a[i] % 2 == 0)
                even.push(a[i]);
            else
                odd.push(a[i]);
        }
        int rem = n;
        boolean takeOdd= false;
        if(odd.size() > even.size())
            takeOdd = true;
        while(rem > 0){
            if(takeOdd){
                if(odd.isEmpty())
                    break;
                odd.pop();
                takeOdd = false;
            } else{
                if(even.isEmpty())
                    break;
                even.pop();
                takeOdd = true;
            }
            rem--;
        }
        long sum = 0;
        for (Integer num : even) {
            sum+=num;
        }
        for (Integer num : odd) {
            sum+=num;
        }
        out.println(sum);
    }
}
