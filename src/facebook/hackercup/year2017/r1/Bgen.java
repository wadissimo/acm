package facebook.hackercup.year2017.r1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Vadimka on 15.01.2017.
 */
public class Bgen {
    public static void main(String[] args) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2017/r1/fighting_the_zombies_gen2.txt"));
        w.write("1\n");
        w.write("80 10\n");
        for (int i = 0; i < 80; i++) {
            w.write(10+" "+ i +"\n");
        }

        w.close();
    }
}
