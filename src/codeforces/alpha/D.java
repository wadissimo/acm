package codeforces.alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class D {
    static String decompress (String s) {


        //get number
        StringBuilder num = new StringBuilder();
        int strStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c<='9') {
                num.append(c);
            } else {
                strStart = i;
                break;
            }
        }
        int rep = 0;
        if(num.length() > 0){
            rep = Integer.parseInt(num.toString());
        }

        StringBuilder sb = new StringBuilder();

        int n = 0;
        StringBuilder substr = new StringBuilder();
        for (int i = strStart; i < s.length(); i++) {
            char c = s.charAt(i);
            if(n == 0 && c != '(' && c != ')') {
                sb.append(c);
            } else if(n == 0 && c == '(') {
                n++;
            } else if( n == 1 && c == ')') {
                n--;
                sb.append(decompress(substr.toString()));
                substr = new StringBuilder();
            } else {
                substr.append(c);
                if(c == '(') {
                    n++;
                } else if (c==')'){
                    n--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(sb);
        for (int i = 1; i < rep; i++) {
            result.append(sb);
        }
        return result.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        System.out.println(decompress(s));
    }
}
