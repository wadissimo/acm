package codestrike.q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 11.05.2014.
 */
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pass = reader.readLine();
        boolean strong = true;
        if(pass.length()<5) {
            strong = false;
        } else if(pass.toLowerCase().equals(pass)){
            strong = false;
        } else if(pass.toUpperCase().equals(pass)){
            strong = false;
        } else {
            strong = false;
            for (int i = 0; i < pass.length(); i++) {
                if(pass.charAt(i) >= '0' && pass.charAt(i)<='9') {
                    strong = true;
                }
            }
        }
        if(strong) {
            System.out.println("Correct");
        } else {
            System.out.println("Too weak");
        }
    }
}
