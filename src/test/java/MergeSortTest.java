import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

		@Test
		public void testMergeSort(){
			MergeSort mergeSort = new MergeSort(new int[]{63,2,1,423,54,62,1,87});
			int actual[] = mergeSort.getSortedArray();
			int expected[] = new int[]{1,1,2,54,62,63,87,423};
			Assert.assertArrayEquals(expected, actual);
		}


}
