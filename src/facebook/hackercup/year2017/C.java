package facebook.hackercup.year2017;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Vadimka on 08.01.2017.
 */
public class C {
    private static BigInteger[][] getMatrix(int cubeType) { // matrix: number of throws x possible sums
        BigInteger[][] matrix = new BigInteger[20][20*cubeType];
        for (int i = 0; i < cubeType; i++) { //fill first cube
            matrix[0][i] = BigInteger.ONE;
        }
        //add a cube and recalculate
        for (int i = 0; i < 19; i++) {
            BigInteger sum = BigInteger.ZERO;
            for (int j = i; j < (i+2)*cubeType - 1; j++) {
                if(matrix[i][j] != null) {
                    sum = sum.add(matrix[i][j]);
                }
                if(j-cubeType >= i) {
                    sum = sum.subtract(matrix[i][j-cubeType]);
                }
//  not needed >> if(sum.equals(BigInteger.ZERO)) {
//                    break;
//                }
                matrix[i+1][j+1] = sum;
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("c:/DEV/acm/tests/facebook/year2017/fighting_the_zombie.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2017/fighting_the_zombie_out.txt"));

        int[] cubes = new int[]{4,6,8,10,12,20};
        Map<Integer, BigInteger[][]> m = new HashMap<>();
        for (int i = 0; i < cubes.length; i++) {
            m.put(cubes[i], getMatrix(cubes[i]));
        }
        int t = Integer.parseInt(r.readLine()); // number of cycles
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int h = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(r.readLine());
            double maxP = 0; // find the best spell
            for (int j = 0; j < s; j++) {
                String formula = st.nextToken();
                int dpos = formula.indexOf('d');
                int plus = formula.indexOf('+');
                int minus = formula.indexOf('-');
                int signPos = plus != -1 ? plus : minus;
                int x = Integer.parseInt(formula.substring(0, dpos));
                int y = Integer.parseInt(formula.substring(dpos + 1, signPos != -1 ? signPos : formula.length()));
                int z = signPos == -1 ? 0 : Integer.parseInt(formula.substring(signPos + 1, formula.length()));
                if(minus != -1) {
                    z *= -1;
                }

                int hp = h;
                hp -= z;
                if(hp >= x) {
                    if(hp <= x*y) {
                        BigInteger sumWins = BigInteger.ZERO;
                        for (int k = hp-1; k < x*y; k++) {
                            sumWins = sumWins.add(m.get(y)[x-1][k]); //we can pre-calculate this as well
                        }
                        BigDecimal p = new BigDecimal(sumWins).divide(new BigDecimal(BigInteger.valueOf(y).pow(x)), 10, BigDecimal.ROUND_HALF_UP);
                        maxP = Math.max(maxP, p.doubleValue());
                    }
                } else {
                    maxP = 1.0; //best spell
                    break;
                }
            }

            w.write("Case #"+(i+1) + ": " + new BigDecimal(maxP).setScale(10, BigDecimal.ROUND_HALF_UP) + "\n");
        }
        w.close();

    }
}
