import java.util.Vector;

public class ConnectedComponents {

	public Vector<Vector<Integer>> G;
	public int E;
	public boolean[] U;
	public int[] id;
	public int[] sz;

	public ConnectedComponents(int E) {
		this.E = E;
		this.G = new Vector<>();
		for (int i = 0; i < E; i++) {
			G.add(new Vector<>());
		}
		U = new boolean[E];
		id = new int[E];
		sz = new int[E];
	}

	//this could be used if we need SSC/CC
	public void resetUsed() {
		U = new boolean[E];
	}

	public void DFS(int vertex, int currentComponent) {
		//currently explored vertex
		//System.out.println(vertex);
		U[vertex] = true;
		id[vertex] = currentComponent;
		sz[currentComponent]++;
		for (int i = 0; i < G.get(vertex).size(); i++) {
			if (!U[G.get(vertex).get(i)]) {
				DFS(G.get(vertex).get(i), currentComponent);
			}
		}
	}

	public boolean isConnected(int u, int v) {
		return id[u] == id[v];
	}

	public void connect(int u, int v) {
		G.get(u).add(v);
		G.get(v).add(u);
	}

	public void printGraph() {
		for (int i = 0; i < G.size(); i++) {
			System.out.println("Vertex " + i + " children are ");
			for (int j = 0; j < G.get(i).size(); j++) {
				System.out.print(G.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public void connectedComponents() {
		int currentConnnectedComponent = 0;
		for (int i = 0; i < G.size(); i++) {
			DFS(i, currentConnnectedComponent);
			currentConnnectedComponent++;
			resetUsed();
		}
	}

	public void printComponentAndSize() {
		// same id -> same component
		for (int i = 0; i < id.length; i++) {
			System.out.print(id[i] + " ");
		}
		System.out.println();
		// size of the component for each vertex
		for (int i = 0; i < sz.length; i++) {
			System.out.print(sz[i] + " ");
		}
	}

	public static void main(String[] args) {
		ConnectedComponents graph = new ConnectedComponents(10);
		graph.connect(0, 1);
		graph.connect(2, 3);
		graph.connect(3, 4);
		graph.connect(5, 6);
		graph.connect(6, 7);
		graph.connect(7, 8);
		graph.connectedComponents();
		System.out.println(graph.isConnected(7, 8)); // true
		System.out.println(graph.isConnected(9, 0)); // false
		System.out.println(graph.isConnected(2, 4)); // transitively connected 2 -> 3 -> 4
		graph.printComponentAndSize();
	}
}
