package yandex.r1;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.*;

public class B {
    public double a(int x1, int y1, int x2, int y2) {
        double angle = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));

        if(angle < 0){
            angle += 360;
        }

        return angle;
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int x[] = new int[n];
        int y[] = new int[n];
        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            y[i] = in.ni();
            p[i] = in.ni();
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Map<Double, List<Integer>> map = new HashMap<Double, List<Integer>>();
            TreeMap<Double, Integer> population = new TreeMap<Double, Integer>();
            TreeMap<Double, Integer> totalPopulation = new TreeMap<Double, Integer>();
            for (int j = 0; j < n; j++) {
                double angle = a(x[i], y[i], x[j], y[j]);
                List<Integer> values = map.get(angle);
                if(values == null) {
                    values = new ArrayList<Integer>();
                    map.put(angle, values);
                }
                values.add(p[j]);
                population.put(angle, 0);
            }
            int total = 0;
            for (Map.Entry<Double, Integer> entry : population.entrySet()) {
                int subTotal = 0;
                for (Integer pop : map.get(entry.getKey())) {
                    subTotal += pop;
                }
                entry.setValue(subTotal);
                total += subTotal;
                totalPopulation.put(entry.getKey(), total);
            }
            for (Double angle : population.keySet()) {
                if(angle > 180.0) break;
                Double opposite = angle + 180.0;

                int top = totalPopulation.get(angle) - population.get(angle);
                Map.Entry<Double, Integer> ceilingEntry = totalPopulation.ceilingEntry(opposite);
                if(ceilingEntry != null) {
                    top += total - ceilingEntry.getValue() + population.get(ceilingEntry.getKey());
                }

                ans = Math.min(ans, Math.abs(total + p[i] - top - top));
                ans = Math.min(ans, Math.abs(total - top - top - p[i]));
                top = totalPopulation.get(angle);
                Map.Entry<Double, Integer> floorEntry = totalPopulation.floorEntry(opposite);
                top += total - floorEntry.getValue();
                ans = Math.min(ans, Math.abs(total + p[i] - top - top));
                ans = Math.min(ans, Math.abs(total - top - top - p[i]));

            }
        }
        out.println(ans);

    }
}
