package codeforces.r301;



import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int r = in.ni();
        int s = in.ni();
        int p = in.ni();
        double a [][][] = new double[r+1][s+1][p+1];
        a[r][s][p] = 1.0;
        for (int i = r; i >= 0; i--) {
            for (int j = s; j >= 0; j--) {
                for (int k = p; k >= 0; k--) {
                    if(i == 0 && j == 0 && k == 0) break;
                    if(i != r && k > 0) {
                        a[i][j][k] += a[i + 1][j][k] * (i+1)*(k)/((i+1)*j+(i+1)*k + j*k);
                    }
                    if(j != s && i > 0) {
                        a[i][j][k] += a[i][j+1][k] * (j+1)*(i)/((j+1)*i+(j+1)*k + i*k);
                    }
                    if(k != p && j > 0) {
                        a[i][j][k] += a[i][j][k+1] * (k+1)*(j)/((k+1)*j+(k+1)*i + j*i);
                    }
                    if(Double.isNaN(a[i][j][k])) {
                        out.print("debug");
                    }
                }
            }

        }
        double rw = 0;
        for (int i = 0; i <= r; i++) {
            rw += a[i][0][0];
        }
        double sw = 0;
        for (int i = 0; i <= s; i++) {
            sw += a[0][i][0];
        }
        double pw = 0;
        for (int i = 0; i <= p; i++) {
            pw += a[0][0][i];
        }
        out.printf("%.12f %.12f %.12f\n", rw, sw, pw);
    }
}
