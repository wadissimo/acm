package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class NABILHACKER {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            String s = in.ns();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> it = list.listIterator(0);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '<'){
                    if(it.hasPrevious())
                        it.previous();
                } else if(c == '>'){
                    if(it.hasNext())
                        it.next();
                } else if(c == '-'){
                    if(it.hasPrevious()){
                        it.previous();
                        it.remove();
                    }
                } else {
                    it.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : list) {
                sb.append(c);
            }
            out.println(sb.toString());
        }
    }
}
