import com.algorithms.graph.apsp.JohnsonsAlgorithm;
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

		johnsonsAlgorithm.johnsonsAlgorithm();
	}

	@Test
	public void testJohnsonsAlgorithmASPS2() throws Exception{
		JohnsonsAlgorithm johnsonsAlgorithm = new JohnsonsAlgorithm(4, true);
		johnsonsAlgorithm.connect(0,1,4);
		johnsonsAlgorithm.connect(0,2,2);
		johnsonsAlgorithm.connect(2,1,1);
		johnsonsAlgorithm.connect(2,3,3);
		johnsonsAlgorithm.connect(1,3,-2);

		johnsonsAlgorithm.johnsonsAlgorithm();
	}

}
