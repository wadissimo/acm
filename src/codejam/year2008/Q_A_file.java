package codejam.year2008;

import java.io.*;

public class Q_A_file {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(Q_A_file.class.getResourceAsStream("A-large-practice.in")));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(Q_A_file.class.getResourceAsStream("Q_A_test.in")));
        BufferedReader reader = new BufferedReader(new InputStreamReader(Q_A_file.class.getResourceAsStream("A-large-practice.in")));
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/vadim/dev/tmp/test.out"));
        int T = Integer.parseInt(reader.readLine());
        System.out.println("T = " + T);
        for (int t = 0; t < T; t++) {
            int s = Integer.parseInt(reader.readLine());
            String[] engines = new String[s];
            for (int i = 0; i < s; i++) {
                engines[i] = reader.readLine();
            }
            int Q = Integer.parseInt(reader.readLine());
            int ans = 0;
            if (Q != 0) {
                int[] query = new int[Q];
                for (int i = 0; i < Q; i++) {
                    String str = reader.readLine();
                    for (int j = 0; j < s; j++) {
                        if (str.equals(engines[j])) {
                            query[i] = j;
                            break;
                        }
                    }
                }
                int INF = 1_000_000;

                int next = -1;
                int cur = -1;
                while (next < INF) {
                    int best = 0;
                    int bestEngine = -1;
                    for (int i = 0; i < s; i++) {
                        if (i == cur)
                            continue;
                        int j = next + 1;
                        for (; j < Q; j++) {
                            if (query[j] == i) {
                                if (j > best) {
                                    best = j;
                                    bestEngine = i;
                                    break;
                                }
                                break;
                            }
                        }
                        if (j == Q) {
                            next = INF;
                            break;
                        }
                    }
                    if (next == INF)
                        break;
                    ans++;
                    next = best;
                    cur = bestEngine;
                }
            }
            System.out.println("ans = " + ans);

            writer.write("Case #" + (t + 1) + ": " + ans + "\n");
        }
        writer.flush();
        writer.close();


    }
}
