package codejam.year2008;

import java.io.*;

public class TestFileWriter {
    public static void main(String[] args) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter("/home/vadim/dev/tmp/test.out"));
        w.write("test");
        w.close();
    }
}
