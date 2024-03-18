import org.junit.Test;
import static org.junit.Assert.*;

public class OneHandSort2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 4;
		int[] targetPrefix = new int[] {1, 2, 3, 0};
		int a = 0;
		int b = 0;
		assertEquals(5, new OneHandSort2().minMoves(N, targetPrefix, a, b));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 4;
		int[] targetPrefix = new int[] {2, 3, 0, 1};
		int a = 0;
		int b = 0;
		assertEquals(6, new OneHandSort2().minMoves(N, targetPrefix, a, b));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 10;
		int[] targetPrefix = new int[] {3, 7};
		int a = 1664525;
		int b = 1013904223;
		assertEquals(11, new OneHandSort2().minMoves(N, targetPrefix, a, b));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 10;
		int[] targetPrefix = new int[] {5, 9, 8, 7, 6, 0, 3};
		int a = 0;
		int b = 1;
		assertEquals(13, new OneHandSort2().minMoves(N, targetPrefix, a, b));
	}
}
