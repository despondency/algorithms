import com.algorithms.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testMergeSort() {
		MergeSort mergeSort = new MergeSort(new int[]{63, 2, 1, 423, 54, 62, 1, 87});
		mergeSort.sort();
		int actual[] = mergeSort.getSortedArray();
		int expected[] = new int[]{1, 1, 2, 54, 62, 63, 87, 423};
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testMergeSortDescending() {
		MergeSort mergeSort = new MergeSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
		mergeSort.sort();
		int actual[] = mergeSort.getSortedArray();
		int expected[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Assert.assertArrayEquals(expected, actual);
	}
}
