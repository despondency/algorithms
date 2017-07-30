import java.util.Vector;

public class DFS {

	private Vector<Vector<Integer>> G;
	private int E;
	private boolean[] U;
	private boolean isDirected;
	public DFS(int E, boolean isDirected) {
		this.E = E;
		this.G = new Vector<>();
		for (int i = 0; i < E; i++) {
			G.add(new Vector<>());
		}
		this.U = new boolean[E];
		this.isDirected = isDirected;
	}

	public void DFS(int vertex) {
		U[vertex] = true;
		for (int i = 0; i < G.get(vertex).size(); i++) {
			if (!U[G.get(vertex).get(i)]) {
				DFS(G.get(vertex).get(i));
			}
		}
	}

	public void connect(int u, int v) {
		G.get(u).add(v);
		if(!isDirected) {
			G.get(v).add(u);
		}
	}
}
