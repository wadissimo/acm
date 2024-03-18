package codejam.year2019.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    private void repeatAppend(StringBuilder sb, char c, int nRep){
        for (int i = 0; i < nRep; i++) {
            sb.append(c);
        }
    }
    private void subSolve(StringBuilder ans, String s, int n, char theirFirst, char myFirst){
        int turn = 0;
        for (int i = 1; i < s.length() ; i++) {
            if(s.charAt(i) == myFirst){
                if(s.charAt(i-1) == myFirst){
                    break;
                }
                turn++;
            }
        }
        repeatAppend(ans, myFirst, turn);
        repeatAppend(ans, theirFirst, n-1);
        repeatAppend(ans, myFirst, n-1-turn);
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            String s = in.ns();
            StringBuilder ans = new StringBuilder();
            char first = s.charAt(0);
            char last = s.charAt(s.length()-1);
            if(first == 'E'){
                if(last == 'S'){
                    repeatAppend(ans, 'S', n-1);
                    repeatAppend(ans, 'E', n-1);
                }else{
                    subSolve(ans, s, n, 'E', 'S');
                }
            } else{
                if(last == 'E'){
                    repeatAppend(ans, 'E', n-1);
                    repeatAppend(ans, 'S', n-1);
                }else{
                    subSolve(ans, s, n, 'S', 'E');
                }

            }
            out.printf("Case #%d: %s%n", t+1, ans.toString());
        }
    }
}
