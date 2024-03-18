package chelper;

public class RandomGraph {
    public double probability(int n, int p) {
        double pe = p / 1000.0d;
        double p1 = 1.0 - Math.pow(1.0-pe, n-1);
        double p2 = 1.0 - Math.pow(1.0-pe, n-2);
        double p3 = 1.0 - Math.pow(1.0-pe, n-3);
        double pg4 = p1*p2*p3;
        double pg42 = pg4*2.0 - pg4*pg4;
        double res = pg4 + pg4 - 4.0/Math.pow(2.0, (n*(n-1))/2);

        return res;
    }
}
