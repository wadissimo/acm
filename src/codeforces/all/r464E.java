package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class r464E {
    long[] sum;
    int[] cnt;
    int[] max;
    int maxN;
    double eps = 1e-10;

    private double search(int maxValue){
        int bitMask = Integer.highestOneBit(maxN);
        long ss = 0;
        long nn = 0;
        int idx = 0;
        int mmax = 0;
        double ans = 0;
        while(bitMask != 0){
            int midIdx = idx + bitMask;
            bitMask >>= 1;
            if(midIdx > maxN)
                continue;
            if(max[midIdx]>=maxValue)
                continue;
            mmax = Math.max(mmax, max[midIdx]);
            double avg = (ss + sum[midIdx]+maxValue)/(double)(nn + cnt[midIdx]+1);
            if(Math.abs(avg - mmax) < eps)
                return avg;
            if(avg > mmax){
                idx = midIdx;
                ss += sum[midIdx];
                nn += cnt[midIdx];
                ans = avg;
            } else {
                mmax = 0;
            }
        }
        return ans;
    }
    private void add(int pos, int val) {
        while (pos < maxN) {
            sum[pos] += val;
            cnt[pos]++;
            max[pos] = Math.max(max[pos], val);
            pos += (pos&-pos);
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int q = in.ni();
        int[][]query = new int[q][2];
        TreeMap<Integer, Integer> vals = new TreeMap<>();
        for (int i = 0; i < q; i++) {
            query[i][0] = in.ni();
            if(query[i][0] == 1){
                query[i][1] = in.ni();
                vals.put(query[i][1], -1);
            }
        }
        int[] ids = new int[vals.size()+1];
        int ii = 1;
        for (Map.Entry<Integer, Integer> entry : vals.entrySet()) {
            ids[ii] = entry.getKey();
            entry.setValue(ii);
            ii++;
        }
        maxN = ii+7;
        sum = new long[maxN+1];
        max = new int[maxN +1];
        cnt = new int[maxN +1];
        int max = 0;
        for (int i = 0; i < q; i++) {
            if(query[i][0] == 1){
                int val = query[i][1];
                max = Math.max(val, max);
                add(vals.get(val), val);
            } else {
                double mean = search(max);
                if(mean < eps)
                    out.println(0.0);
                else
                    out.println(max - mean);
            }
        }
    }
}
