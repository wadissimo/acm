package codeforces.r244;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Mahmoud Aladdin <aladdin3>
 */
public class Da {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskD {
    int[] Zalgorithm(char[] s) {
        int[] z = new int[s.length];
        Arrays.fill(z, 0);
        z[0] = s.length;
        int L = 0, R = 0;
        int n = s.length;
        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && s[R-L] == s[R]) R++;
                z[i] = R-L; R--;
            } else {
                int k = i-L;
                if (z[k] < R-i+1) z[i] = z[k];
                else {
                    L = i;
                    while (R < n && s[R-L] == s[R]) R++;
                    z[i] = R-L; R--;
                }
            }
        }
        return z;
    }

    public void solve(int testNumber, InputReader jin, OutputWriter jout) {
        String s1 = jin.token();
        String s2 = jin.token();


        int v = Integer.MAX_VALUE;
        for(int i = 0; i < s1.length(); i++) {
            String part = s1.substring(i);
            int[] arr1 = Zalgorithm((part + "$" + s2).toCharArray());
            int m1 = -1;
            int m2 = -1;
            for(int j = 1; j < arr1.length; j++) {
                if(arr1[j] > m1) {
                    m2 = m1;
                    m1 = arr1[j];
                } else if(arr1[j] > m2) {
                    m2 = arr1[j];
                }
            }
            if(m1 > 0 && m1 > m2) {
                part = s1.substring(i, i + m1);
                //jout.print(part, m1);
                arr1 = Zalgorithm((part + "$" + s1).toCharArray());
                m1 = 0; int m22 = 0;
                for(int j = 1; j < arr1.length; j++) {
                    if(arr1[j] > m1) {
                        m22 = m1;
                        m1 = arr1[j];
                    } else if(arr1[j] > m2) {
                        m22 = arr1[j];
                    }
                }
                //jout.println("", m1, m22, m2);
                if(m1 > m22) {
                    v = Math.min(v, Math.max(m2 + 1, m22 + 1));
                }
            }
        }
        jout.println(v < Integer.MAX_VALUE? v: -1);
    }
}

class InputReader {
    private static final int bufferMaxLength = 1024;
    private InputStream in;
    private byte[] buffer;
    private int currentBufferSize;
    private int currentBufferTop;
    private static final String tokenizers = " \t\r\f\n";

    public InputReader(InputStream stream) {
        this.in = stream;
        buffer = new byte[bufferMaxLength];
        currentBufferSize = 0;
        currentBufferTop = 0;
    }

    private boolean refill() {
        try {
            this.currentBufferSize = this.in.read(this.buffer);
            this.currentBufferTop = 0;
        } catch(Exception e) {}
        return this.currentBufferSize > 0;
    }


    private Byte readChar() {
        if(currentBufferTop < currentBufferSize) {
            return this.buffer[this.currentBufferTop++];
        } else {
            if(!this.refill()) {
                return null;
            } else {
                return readChar();
            }
        }
    }

    public String token()  {
        StringBuffer tok = new StringBuffer();
        Byte first;
        while((first = readChar()) != null && (tokenizers.indexOf((char) first.byteValue()) != -1));
        if(first == null) return null;
        tok.append((char)first.byteValue());
        while((first = readChar()) != null && (tokenizers.indexOf((char) first.byteValue()) == -1)) {
            tok.append((char)first.byteValue());
        }
        return tok.toString();
    }

}

class OutputWriter {
    private final int bufferMaxOut = 1024;
    private PrintWriter out;
    private StringBuilder output;
    private boolean forceFlush = false;

    public OutputWriter(OutputStream outStream) {
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outStream)));
        output = new StringBuilder(2 * bufferMaxOut);
    }

    public OutputWriter(Writer writer) {
        forceFlush = true;
        out = new PrintWriter(writer);
        output = new StringBuilder(2 * bufferMaxOut);
    }

    private void autoFlush() {
        if(forceFlush || output.length() >= bufferMaxOut) {
            flush();
        }
    }

    public void print(Object... tokens) {
        for(int i = 0; i < tokens.length; i++) {
            if(i != 0) output.append(' ');
            output.append(tokens[i]);
        }
        autoFlush();
    }

    public void println(Object... tokens) {
        print(tokens);
        output.append('\n');
        autoFlush();
    }

    public void flush() {
        out.print(output);
        output.setLength(0);
    }

    public void close() {
        flush();
        out.close();
    }
}