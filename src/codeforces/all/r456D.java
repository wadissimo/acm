package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class r456D {
    class Square{
        int x,y;
        long size;

        public Square(int x, int y, long size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), r = in.ni(), k = in.ni();
        int nmax = Math.min(r, n-r+1);
        int mmax = Math.min(r, m-r+1);
        long nsize = n - (nmax-1)*2;
        long msize = m - (mmax-1)*2;
        PriorityQueue<Square> pq = new PriorityQueue<>(new Comparator<Square>() {
            @Override
            public int compare(Square o1, Square o2) {
                return -Long.compare((long)o1.x*o1.y, (long)o2.x*o2.y);
            }
        });
        pq.offer(new Square(nmax, mmax, nsize*msize));
        long sum = 0;
        TreeSet<Square> taken = new TreeSet<>(new Comparator<Square>() {
            @Override
            public int compare(Square o1, Square o2) {
                if(o1.x == o2.x)
                    return Integer.compare(o1.y, o2.y);
                else
                    return Integer.compare(o1.x, o2.x);
            }
        });
        while(k > 0){
            Square next = pq.poll();
            if(taken.contains(next))
                continue;
            taken.add(next);
            if(next.size >= k){
                sum += k*(long)next.x*next.y;
                k = 0;
            } else {
                sum += next.size*next.x*next.y;
                k-=next.size;
            }

            if(next.y > 1){
                pq.offer(new Square(next.x, next.y-1, next.x == nmax? 2*nsize : 4));
            }
            if(next.x > 1){
                pq.offer(new Square(next.x-1, next.y, next.y == mmax? 2*msize : 4));
            }
        }
        out.println((double)sum/((long)(n-r+1)*(m-r+1)));
    }
}
