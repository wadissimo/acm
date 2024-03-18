package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class HASHIT {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T=in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            String [] table = new String[101];
            for (int i = 0; i < n; i++) {
                String op = in.ns();
                String s = op.substring(4);
                long hash = 0;
                for (int j = 0; j < s.length(); j++) {
                    hash += s.charAt(j)*(j+1);
                }
                hash *= 19;
                hash %= 101;
                if(op.startsWith("ADD:")){
                    boolean found = false;
                    for (int j = 0; j < 20; j++) {
                        int pos = (int)(hash + j*j + 23*j)%101;
                        if(table[pos] != null && table[pos].equals(s)){
                            found = true;
                            break;
                        }
                    }
                    if(!found)
                        for (int j = 0; j < 20; j++) {
                            int pos = (int)(hash + j*j + 23*j)%101;
                            if(table[pos] == null){
                                table[pos] = s;
                                break;
                            }
                        }



                } else {
                    for (int j = 0; j < 20; j++) {
                        int pos = (int)(hash + j*j + 23*j)%101;
                        if(table[pos] != null && s.equals(table[pos])){
                            table[pos] = null;
                            break;
                        }
                    }
                }
            }
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 101; i++) {
                if(table[i] != null){
                    cnt++;
                    sb.append(i).append(':').append(table[i]).append('\n');
                }
            }
            out.println(cnt);
            out.println(sb.toString());
        }
    }
}
