import org.junit.Assert;
import org.junit.Test;

public class LevenshteinDistanceTest {

	@Test
	public void testLevenshteinDistance() {
		LevenshteinEditDistance a = new LevenshteinEditDistance("kitten", "sitten");
		Assert.assertEquals(1, a.editDistance());
		LevenshteinEditDistance b = new LevenshteinEditDistance("", "kitten");
		Assert.assertEquals(6, b.editDistance());
		LevenshteinEditDistance c = new LevenshteinEditDistance("kit", "kitten");
		Assert.assertEquals(3, c.editDistance());
		LevenshteinEditDistance d = new LevenshteinEditDistance("smit", "smitten");
		Assert.assertEquals(3, d.editDistance());
		LevenshteinEditDistance e = new LevenshteinEditDistance("", "");
		Assert.assertEquals(0, e.editDistance());
	}
}
