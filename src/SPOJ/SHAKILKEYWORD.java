package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SHAKILKEYWORD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.ni();
        for (int i = 0; i < T; i++) {
            String s = in.readLine();
            boolean found = false;
            for (StringTokenizer st = new StringTokenizer(s, "|$ *@.&\\\"!^,?"); st.hasMoreTokens(); ) {
                String tok = st.nextToken();
                if(tok.contains("#")){
                    out.println(tok);
                    found = true;
                }
            }
            if(!found)
                out.println("No keywords.");

        }
    }
}
