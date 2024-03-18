import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class OneHandSort {

	public int[] sortShelf(int[] target) {
		int n = target.length;
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if(target[i] == i)
				continue;
			int idx = 0;
			for (int j = 0; j < n; j++) {
				if(target[j] == i){
					idx = j;
					break;
				}
			}
			list.add(i);
			list.add(idx);
			list.add(n);
			int tmp = target[i];
			target[i] = target[idx];
			target[idx] = tmp;
		}
		int[] res = new int[list.size()];
		int idx = 0;
		for (Integer num : list) {
			res[idx++] = num;
		}

		return res;
	}
}
