package atcoder.agc32;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        LinkedList<Integer> b = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            b.addLast(in.ni());
        }
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int ind = b.size();
            ListIterator<Integer> it = b.listIterator(ind);
            while(it.hasPrevious()){
                Integer num = it.previous();
                if(num == ind){
                    ans.addFirst(num);
                    it.remove();
                    break;
                }
                ind--;
            }
            if(ind == 0 && b.size() != 0){
                out.println(-1);
                return;
            }
        }
        for (Integer num : ans) {
            out.println(num);
        }

    }
}
