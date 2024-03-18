package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PRADIPSUM {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int j = 0;
        while(true){
            String line = in.readLine();
            if (line == null)
                break;
            StringTokenizer st = new StringTokenizer(line);
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if(a > b){
                out.println((a+b)*(a-b+1)/2);
            }else{
                out.println((a+b)*(b-a+1)/2);
            }
        }

    }
}
