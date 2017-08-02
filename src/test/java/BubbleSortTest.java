import com.algorithms.sort.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void testBubbleSort() {
		BubbleSort bubbleSort = new BubbleSort(new int[]{63, 2, 1, 423, 54, 62, 1, 87});
		bubbleSort.sort();
		int actual[] = bubbleSort.getSortedArray();
		int expected[] = new int[]{1, 1, 2, 54, 62, 63, 87, 423};
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testBubbleSortDescending() {
		BubbleSort bubbleSort = new BubbleSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
		bubbleSort.sort();
		int actual[] = bubbleSort.getSortedArray();
		int expected[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Assert.assertArrayEquals(expected, actual);
	}
}
