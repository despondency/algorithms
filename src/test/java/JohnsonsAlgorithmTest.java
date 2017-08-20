import com.algorithms.graph.apsp.JohnsonsAlgorithm;
import org.junit.Assert;
import org.junit.Test;


public class JohnsonsAlgorithmTest {

	@Test
	public void testJohnsonsAlgorithmASPS() throws Exception{
		JohnsonsAlgorithm johnsonsAlgorithm = new JohnsonsAlgorithm(4, true);
		johnsonsAlgorithm.connect(0,1,-5);
		johnsonsAlgorithm.connect(1,2,4);
		johnsonsAlgorithm.connect(0,2,2);
		johnsonsAlgorithm.connect(0,3,3);
		johnsonsAlgorithm.connect(2,3,1);

		int dist[][] = johnsonsAlgorithm.johnsonsAPSP();
		int expected[][] = new int[][]{
			{0, -5, -1, 0},
			{1000000000, 0, 4, 5},
			{1000000000, 1000000000, 0, 1},
			{1000000000,1000000000,1000000000,0}
		};

		Assert.assertArrayEquals(expected,dist);
	}

	@Test
	public void testJohnsonsAlgorithmASPS2() throws Exception{
		JohnsonsAlgorithm johnsonsAlgorithm = new JohnsonsAlgorithm(4, true);
		johnsonsAlgorithm.connect(0,1,4);
		johnsonsAlgorithm.connect(0,2,2);
		johnsonsAlgorithm.connect(2,1,1);
		johnsonsAlgorithm.connect(2,3,3);
		johnsonsAlgorithm.connect(1,3,-2);

		int dist[][] = johnsonsAlgorithm.johnsonsAPSP();
		int expected[][] = new int[][]{
			{0,3,2,1},
			{1000000000,0,1000000000,-2},
			{1000000000, 1, 0, -1},
			{1000000000,1000000000,1000000000,0}
		};
		Assert.assertArrayEquals(expected,dist);
	}

	@Test
	public void testJohnsonsAlgorithmASPS3() throws Exception{
		JohnsonsAlgorithm johnsonsAlgorithm = new JohnsonsAlgorithm(4, true);
		johnsonsAlgorithm.connect(0,2,-2);
		johnsonsAlgorithm.connect(1,2,3);
		johnsonsAlgorithm.connect(1,0,4);
		johnsonsAlgorithm.connect(2,3,2);
		johnsonsAlgorithm.connect(3,1,-1);

		int dist[][] = johnsonsAlgorithm.johnsonsAPSP();
		int expected[][] = new int[][]{
			{0,-1,-2,0},
			{4,0,2,4},
			{5,1,0,2},
			{3,-1,1,0}
		};
		Assert.assertArrayEquals(expected,dist);
	}



}
