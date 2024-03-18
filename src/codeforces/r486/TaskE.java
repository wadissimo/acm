package codeforces.r486;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskE {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.ns();
        int ans = 0;
        if(s.endsWith("00") ||s.endsWith("25") ||s.endsWith("50")||s.endsWith("75")){
            ans = 0;
        }else{
            if(s.endsWith("0")){
                if(s.indexOf('0') != -1 && s.indexOf('0') != s.length()-1){//00
                    ans = 1;
                } else if(s.indexOf('5') != -1){
                    if(s.lastIndexOf('5') == 0 && s.charAt(1) == '0'){


                    }else{
                        ans = 1;
                    }
                }
            }
        }
    }
}
