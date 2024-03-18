import org.junit.Test;
import static org.junit.Assert.*;

public class OneHandSortTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] target = new int[] {0, 1, 2};
		assertArrayEquals(new int[] { }, new OneHandSort().sortShelf(target));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] target = new int[] {1, 2, 3, 0};
		assertArrayEquals(new int[] {2, 1, 0, 3, 4 }, new OneHandSort().sortShelf(target));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] target = new int[] {1, 0, 3, 2};
		assertArrayEquals(new int[] {0, 1, 4, 2, 3, 4 }, new OneHandSort().sortShelf(target));
	}
}
