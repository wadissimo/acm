package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        List<Integer> ans = new LinkedList<>();
        for (int sum = 1; sum <= 9*9; sum++) {
            int num = n-sum;
            if(num > 0){
                int digSum = 0;
                while(num > 0){
                    digSum += num%10;
                    num /= 10;
                }
                if(digSum == sum)
                    ans.add(n-sum);
            }
        }
        out.println(ans.size());
        if(ans.size() > 0){
            for (Integer num : ans) {
                out.println(num);
            }
        }
    }
}
