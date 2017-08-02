import com.algorithms.sort.InsertionSort;
import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {

	@Test
	public void testInsertionSort() {
		InsertionSort insertionSort = new InsertionSort(new int[]{63, 2, 1, 423, 54, 62, 1, 87});
		insertionSort.sort();
		int actual[] = insertionSort.getSortedArray();
		int expected[] = new int[]{1, 1, 2, 54, 62, 63, 87, 423};
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testInsertionSortDescending() {
		InsertionSort insertionSort = new InsertionSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
		insertionSort.sort();
		int actual[] = insertionSort.getSortedArray();
		int expected[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Assert.assertArrayEquals(expected, actual);
	}
}
