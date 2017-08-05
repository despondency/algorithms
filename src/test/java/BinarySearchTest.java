import com.algorithms.search.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinarySearchTest {

	@Test
	public void testBinarySearch() {
		int A[] = new int[]{4, 1, 53, 6, 3, 124, 7, 234, 24, 1231231265};
		// sorted is
		// 1,3,4,6,7,24,53,124,234,1231231264
		Arrays.sort(A);
		BinarySearch binarySearch = new BinarySearch(A);
		Assert.assertEquals(2, binarySearch.equalBound(4));
		Assert.assertEquals(0, binarySearch.equalBound(1));
		Assert.assertEquals(6, binarySearch.equalBound(53));
		Assert.assertEquals(3, binarySearch.equalBound(6));
		Assert.assertEquals(1, binarySearch.equalBound(3));
		Assert.assertEquals(7, binarySearch.equalBound(124));
		Assert.assertEquals(4, binarySearch.equalBound(7));
		Assert.assertEquals(8, binarySearch.equalBound(234));
		Assert.assertEquals(5, binarySearch.equalBound(24));
		Assert.assertEquals(9, binarySearch.equalBound(1231231265));

		Assert.assertEquals(0, binarySearch.lowerBound(0)); // there is no 0 so we get 0th index as bigger (1)
		Assert.assertEquals(1, binarySearch.lowerBound(2)); // there is no 2 so we get 1st index as bigger (3)
		Assert.assertEquals(1, binarySearch.lowerBound(3));
		Assert.assertEquals(2, binarySearch.lowerBound(4));
		Assert.assertEquals(3, binarySearch.lowerBound(5));
		Assert.assertEquals(3, binarySearch.lowerBound(6));
		Assert.assertEquals(4, binarySearch.lowerBound(7));
		// 7 -> 24
		Assert.assertEquals(4, binarySearch.lowerBound(7));
		Assert.assertEquals(5, binarySearch.lowerBound(8));
		Assert.assertEquals(5, binarySearch.lowerBound(9));
		Assert.assertEquals(5, binarySearch.lowerBound(10));
		Assert.assertEquals(5, binarySearch.lowerBound(11));
		Assert.assertEquals(5, binarySearch.lowerBound(12));
		Assert.assertEquals(5, binarySearch.lowerBound(13));
		Assert.assertEquals(5, binarySearch.lowerBound(14));
		Assert.assertEquals(5, binarySearch.lowerBound(15));
		Assert.assertEquals(5, binarySearch.lowerBound(16));
		Assert.assertEquals(5, binarySearch.lowerBound(17));
		Assert.assertEquals(5, binarySearch.lowerBound(18));
		Assert.assertEquals(5, binarySearch.lowerBound(19));
		Assert.assertEquals(5, binarySearch.lowerBound(20));
		Assert.assertEquals(5, binarySearch.lowerBound(21));
		Assert.assertEquals(5, binarySearch.lowerBound(22));
		Assert.assertEquals(5, binarySearch.lowerBound(23));
		Assert.assertEquals(5, binarySearch.lowerBound(24));

		Assert.assertEquals(9, binarySearch.lowerBound(235));
		Assert.assertEquals(7, binarySearch.lowerBound(55));

		//1231231265 is in the array, if we use it its gonna be found, if we use higher value we are going to get pointer out of the array
		Assert.assertEquals(10, binarySearch.lowerBound(1231231267)); // there is no such element so we return index out of the array

		//1231231265 we look for element that is strongly > of 1231231265
		Assert.assertEquals(10, binarySearch.upperBound(1231231265)); // theres no bigger el -> 10th index is index out of the array
		Assert.assertEquals(0, binarySearch.upperBound(0));
	}
}
