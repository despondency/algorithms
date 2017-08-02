import com.algorithms.sort.CountingSort;
import org.junit.Assert;
import org.junit.Test;

public class CountingSortTest {
	@Test
	public void testCountingSort() {
		CountingSort countingSort = new CountingSort(new int[]{63, 2, 1, 423, 54, 62, 1, 87});
		Integer actual[] = countingSort.sort();
		Integer expected[] = new Integer[]{1, 1, 2, 54, 62, 63, 87, 423};
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testCountingSortDescending() {
		CountingSort countingSort = new CountingSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
		Integer actual[] = countingSort.sort();
		Integer expected[] = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Assert.assertArrayEquals(expected, actual);
	}
}
