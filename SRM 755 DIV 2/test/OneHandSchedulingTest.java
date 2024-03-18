import org.junit.Test;
import static org.junit.Assert.*;

public class OneHandSchedulingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] tStart = new int[] {10, 100, 236};
		int[] tEnd = new int[] {47, 235, 347};
		assertEquals("possible", new OneHandScheduling().checkSchedule(tStart, tEnd));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] tStart = new int[] {100, 236, 10};
		int[] tEnd = new int[] {235, 347, 47};
		assertEquals("possible", new OneHandScheduling().checkSchedule(tStart, tEnd));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] tStart = new int[] {10, 20};
		int[] tEnd = new int[] {20, 30};
		assertEquals("impossible", new OneHandScheduling().checkSchedule(tStart, tEnd));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] tStart = new int[] {10, 400000, 500000};
		int[] tEnd = new int[] {20, 600000, 700000};
		assertEquals("impossible", new OneHandScheduling().checkSchedule(tStart, tEnd));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] tStart = new int[] {1, 40, 50, 60};
		int[] tEnd = new int[] {1000000, 41, 51, 61};
		assertEquals("impossible", new OneHandScheduling().checkSchedule(tStart, tEnd));
	}
}
