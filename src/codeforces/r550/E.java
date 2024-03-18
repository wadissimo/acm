package codeforces.r550;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class E {
    String add(String a, String b){
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = a.length()-1; i >= 0 ; i--) {
            int ad = a.charAt(i)- 'a';
            int bd = b.charAt(i)- 'a';
            int cd = ad+bd+carry;
            carry = cd/26;
            cd %=26;
            result.append((char)(cd+'a'));
        }
        if(carry != 0){
            result.append((char)(carry+'a'));
        }
        return result.reverse().toString();
    }
    String div2(String a){
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < a.length(); i++) {
            int ad = a.charAt(i)- 'a';
            ad += carry*26;
            carry = ad%2;
            int c = ad/2;
            if(c != 0 || i > 0)
                res.append((char)(c + 'a'));
        }
        return res.toString();
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        String t = in.ns();
        int from = 0;
        for (int i = 0; i < n; i++, from ++) {
            if(s.charAt(i) != t.charAt(i)){
                break;
            }
        }
        String same = "";
        if(from != 0){
            same = s.substring(0, from);
            s = s.substring(from, n);
            t = t.substring(from, n);
        }
        String c = add(s, t);
        out.println(same+div2(c));

    }
}
