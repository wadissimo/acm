package codeforces.r300;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        String s = in.readLine();
        int n = Integer.parseInt(s);
        char d[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            s = in.readLine();
            for (int j = 0; j < n; j++) {
                d[i][j] = s.charAt(j);
            }
        }
        char r[][] = new char[2*n-1][2*n-1];
        r[n-1][n-1] = 'o';
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(d[i][j] == 'o') {
//                    for (int k = 0; k < n; k++) {
//                        for (int l = 0; l < n; l++) {
//                            if(d[k][l] == '.') {
//                                r[n + k - i][n + l - j] = '.';
//                            } else if(d[k][l] == 'x') {
//                                if(r[n+k-i][n+l-j] != '.') {
//                                    r[n + k - i][n + l - j] = 'x';
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(d[i][j] == '.') {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            if(d[k][l] == 'o') {
                                r[n + i - k - 1][n + j - l - 1] = '.';
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(d[i][j] == 'x') {
                    boolean found = false;

                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            if(d[k][l] == 'o') {
                                if(r[n + i - k - 1][n + j - l - 1] != '.') {
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if(found) break;
                    }
                    if(!found) {
                        out.println("NO");
                        return;
                    }
                }
            }
        }


//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(d[i][j] == 'o'){
//
//                    for (int k = 0; k < n; k++) {
//                        for (int l = 0; l < n; l++) {
//                            if(d[k][l] == '.' && (r[n + k - i][n + l - j] == '\0')) {
//
//                                out.println("NO");
//                                return;
//
//                            }
//                        }
//                    }
//                }
//            }
//        }


        out.println("YES");
        for (int i = 0; i < 2*n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 2* n - 1; j++) {
                if(r[i][j] == '\0') {
                    r[i][j] = 'x';
                }
                sb.append(r[i][j]);
            }
            out.println(sb);
        }
    }
}
