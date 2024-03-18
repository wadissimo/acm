package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Stack;

public class r534B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        Stack<Character> st = new Stack<>();
        int turns = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek() == c){
                st.pop();
                turns++;
            } else
                st.push(c);
        }
        if(turns %2 == 0)
            out.println("No");
        else
            out.println("Yes");
    }
}
