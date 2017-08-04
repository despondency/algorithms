import com.algorithms.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinarySearchTest {
		@Test
		public void testBinarySearch(){
			int A[] = new int[]{4,1,53,6,3,124,7,234,24,1231231265};
			// sorted is
			// 1,3,4,6,7,24,53,124,234,1231231264
			Arrays.sort(A);
			BinarySearch binarySearch = new BinarySearch(A);
			Assert.assertEquals(2,binarySearch.equalBound(4));
			Assert.assertEquals(9,binarySearch.lowerBound(235));
			Assert.assertEquals(7,binarySearch.lowerBound(55));

			//1231231265 is in the array, if we use it its gonna be found, if we use higher value we are going to get pointer out of the array
			Assert.assertEquals(10,binarySearch.lowerBound(1231231267)); // there is no such element so we return index out of the array

			//1231231265 we look for element that is strongly > of 1231231265
			Assert.assertEquals(10,binarySearch.upperBound(1231231265)); // theres no bigger el -> 10th index is index out of the array
		}
}
