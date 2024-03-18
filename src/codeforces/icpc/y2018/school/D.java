package codeforces.icpc.y2018.school;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.ni(); long m = in.ni();
        int[][] pair = new int[(int)m][2];
        int[] cnt = new int[(int)n];
        for (int i = 0; i < m; i++) {
            pair[i][0] = in.ni()-1;
            pair[i][1] = in.ni()-1;
            cnt[pair[i][0]]++;
            cnt[pair[i][1]]++;
        }
        if(m >=(n-1)*n/2){
            out.println("NO");
        } else {
            out.println("YES");

            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                if(cnt[i] < n-1){
                    x = i;
                    boolean[] used = new boolean[(int)n];
                    for (int j = 0; j < m; j++) {
                        if(pair[j][0] == x){
                            used[pair[j][1]] = true;
                        } else if(pair[j][1] == x){
                            used[pair[j][0]] = true;
                        }
                    }
                    for (int j = 0; j < n; j++) {
                        if(j!=x && !used[j]){
                            y = j;
                            break;
                        }
                    }
                    break;
                }
            }
            x++;y++;
            int id = 1;
            for (int i = 1; i <= n; i++) {
                if(i == x){
                    out.print(n-1);
                } else if(i == y){
                    out.print(n);
                } else
                    out.print(id++);
                if(i != n)
                    out.print(" ");
            }
            out.println();
            id = 1;
            for (int i = 1; i <= n; i++) {
                if(i == x){
                    out.print((n-1));
                } else if(i == y){
                    out.print(n-1);
                } else
                    out.print(id++);
                if(i != n)
                    out.print(" ");
            }
            out.println();
        }
    }
}
