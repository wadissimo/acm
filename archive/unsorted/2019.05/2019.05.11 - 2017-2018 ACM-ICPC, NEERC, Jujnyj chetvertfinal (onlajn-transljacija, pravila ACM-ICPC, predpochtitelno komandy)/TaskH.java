package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class TaskH {
    private int num(char c){
        if(c >='a' && c <='z'){
            return c-'a';
        } else if(c >='A' && c <= 'Z'){
            return c-'A'+26;
        } else {
            return c-'0'+52;
        }
    }
    private char rev(int n){
        if(n < 26)
            return (char)(n+'a');
        else if(n < 52)
            return (char)(n-26+'A');
        else
            return (char)(n-52 + '0');
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        int[] cnt = new int[100];
        String s = in.ns();
        for (int i = 0; i < N; i++) {
            cnt[num(s.charAt(i))]++;
        }

        LinkedList<Character> even = new LinkedList<>();
        LinkedList<Character> odd = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            if(cnt[i] == 0)
                continue;
            if(cnt[i] %2 == 1) {
                odd.add(rev(i));
            }
            for (int j = 0; j < cnt[i] / 2; j++) {
                even.add(rev(i));
            }
        }
        if(odd.size() <= 1) {
            out.println(1);
            StringBuilder pal = new StringBuilder();
            for (Character c : even) {
                pal.append(c);
            }
            out.print(pal);
            if (!odd.isEmpty())
                out.print(odd.pollFirst());
            out.print(pal.reverse());
            out.println();
        } else {
            for (int div = 1; div <= N; div++) {
                if(N%div == 0 && (N/div)%2 == 1){
                    if(odd.size() > div || (div - odd.size())%2 == 1)
                        continue;
                    char[] center = new char[div];
                    for (int i = 0; i < div; i++) {
                        if(!odd.isEmpty()){
                            center[i] = odd.pollFirst();
                        } else {
                            center[i] = center[i+1] = even.pollFirst();
                            i++;
                        }
                    }
                    out.println(div);
                    int size = (N/div - 1)/2;
                    for (int i = 0; i < div; i++) {
                        StringBuilder pal = new StringBuilder();
                        for (int j = 0; j < size; j++) {
                            pal.append(even.pollFirst());
                        }
                        out.print(pal); out.print(center[i]);out.print(pal.reverse());out.print(' ');
                    }
                    return;
                }
            }
        }
    }
}
