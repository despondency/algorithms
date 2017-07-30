public class QuickFind {

	private int[] ids; // lookup

	public QuickFind(int sz) {
		ids = new int[sz];
		for (int i = 0; i < sz; i++) {
			ids[i] = i; // map each to idx
		}
	}

	public boolean isConnected(int p, int q) {
		return ids[p] == ids[q];
	}

	public void union(int p, int q) {
		int idOfp = ids[p];
		int idOfq = ids[q];
		for (int i = 0; i < ids.length; i++) {
			// this loop is 2*N+2 operations at worst.
			// count the variables assignment increments
			// also the if statement check
			if (ids[i] == idOfp) {
				ids[i] = idOfq;
			}
		}
	}
}
