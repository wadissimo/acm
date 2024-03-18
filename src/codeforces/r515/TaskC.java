package codeforces.r515;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int q = in.ni();
        int[] l = new int[q];
        int[] r = new int[q];
        boolean [] put_left = new boolean[q];
        HashMap<Integer,Integer> index = new HashMap<>(q);
        for (int i = 0; i < q; i++) {
            String s = in.ns();
            int id = in.ni();
            if(i>0) {
                l[i] += l[i - 1];
                r[i] += r[i - 1];
            }
            if("L".equals(s)){
                l[i] += 1;
                index.put(id, i);
                put_left[i] = true;
            } else if("R".equals(s)){
                r[i] += 1;
                index.put(id, i);
            }else{
                int pos = index.get(id);
                int pl = 0; int pr = 0;
                if(put_left[pos]){
                    pr = l[pos]+r[pos]-1;
                }else{
                    pl = l[pos]+r[pos]-1;
                }
                pr+=r[i]-r[pos];
                pl +=l[i]-l[pos];
                out.println(Math.min(pr,pl));
            }

        }
    }
}
