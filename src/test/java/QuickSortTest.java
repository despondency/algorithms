import com.algorithms.sort.QuickSort;
import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

	@Test
	public void testQuickSort() {
		QuickSort quickSort = new QuickSort(new Integer[]{63, 2, 1, 423, 54, 62, 1, 87});
		quickSort.sort();
		Integer actual[] = quickSort.getSortedArray();
		Integer expected[] = new Integer[]{1, 1, 2, 54, 62, 63, 87, 423};
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testQuickSortDescending() {
		QuickSort quickSort = new QuickSort(new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
		quickSort.sort();
		Integer actual[] = quickSort.getSortedArray();
		Integer expected[] = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Assert.assertArrayEquals(expected, actual);
	}
}
