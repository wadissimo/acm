import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class OneHandScheduling {
	class Seg{
		int from , to;

		public Seg(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	public String checkSchedule(int[] tStart, int[] tEnd) {
		int n = tStart.length;
		Seg[] segs = new Seg[n];
		for (int i = 0; i < n; i++) {
			segs[i] = new Seg(tStart[i], tEnd[i]);
		}
		Arrays.sort(segs, Comparator.comparingInt((x)->(x.from)));
		int prev = -1;
		boolean possible = true;
		for (Seg seg : segs) {
			if(seg.from <= prev){
				possible = false;
				break;
			}
			prev = seg.to;
		}

		return possible?"possible":"impossible";
	}
}
