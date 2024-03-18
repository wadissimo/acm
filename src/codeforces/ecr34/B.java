package codeforces.ecr34;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int h1 = in.ni(), a1 = in.ni(), c1 = in.ni();
        int h2 = in.ni(), a2 = in.ni();
        int n = (h2+a1-1)/a1;

        LinkedList<Integer> list = new LinkedList<>();
        while(h2 > 0){
            if(a1 >= h2){
                list.add(1);
                break;
            }
            while(h1 <= a2){
                list.add(0);
                h1 += c1-a2;
            }
            h2-=a1;
            list.add(1);
            h1-=a2;
        }
        out.println(list.size());
        for (Integer id : list) {
            if(id == 0){
                out.println("HEAL");
            }else{
                out.println("STRIKE");
            }
        }
    }
}
