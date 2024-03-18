package codeforces.r237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class D {
    static class State {
        long zero;
        long leftBomb;
        long rightBomb;
        long bomb;
        long two;

        @Override
        public String toString() {
            return "State{" +
                    "zero=" + zero +
                    ", leftBomb=" + leftBomb +
                    ", rightBomb=" + rightBomb +
                    ", bomb=" + bomb +
                    ", two=" + two +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        long mod = 1000000007;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = s.length();
        State [] d = new State[n];
        for (int i = 0; i < n; i++) {
            d[i] = new State();
        }
        switch (s.charAt(0)) {
            case '0': d[0].zero = 1;break;
            case '1': d[0].rightBomb = 1;break;
            case '*': d[0].bomb = 1;break;
            case '?':
                d[0].zero = 1;
                d[0].rightBomb = 1;
                d[0].bomb = 1;
        }
        for (int i = 1; i < n; i++) {
            switch (s.charAt(i)){
                case '0':
                    d[i].zero = (d[i-1].zero + d[i-1].leftBomb)%mod;
                    break;
                case '1':
                    if(i != n-1) {
                        d[i].rightBomb = (d[i - 1].zero + d[i - 1].leftBomb)%mod;
                    }
                    d[i].leftBomb = d[i-1].bomb;
                    break;
                case '*':
                    d[i].bomb = ((d[i - 1].two + d[i - 1].rightBomb)%mod + d[i - 1].bomb)%mod;
                    break;
                case '2':
                    if(i != n-1) {
                        d[i].two = d[i-1].bomb;
                    }
                    break;
                case '?':
                    d[i].zero = (d[i-1].zero + d[i-1].leftBomb)%mod;
                    if(i != n-1) {
                        d[i].rightBomb = (d[i - 1].zero + d[i - 1].leftBomb)%mod;
                    }
                    d[i].leftBomb = d[i-1].bomb;
                    d[i].bomb = ((d[i - 1].two + d[i - 1].rightBomb)%mod + d[i - 1].bomb)%mod;
                    if(i != n-1) {
                        d[i].two = d[i-1].bomb;
                    }
            }
        }
        long ans = ((d[n-1].zero + d[n-1].leftBomb)%mod + d[n-1].bomb)%mod;
        System.out.println(ans);
    }
}
