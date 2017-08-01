import java.util.Stack;
import java.util.Vector;

public class KosarajuSharir {
	private Vector<Vector<Integer>> G;
	private Vector<Vector<Integer>> reverseG;
	private Stack<Integer> topologicalSort;
 	private int V;
	private boolean[] U;
	private int[] id;
	private int[] sz;

	public KosarajuSharir(int V) {
		this.V = V;
		this.G = new Vector<>();
		this.reverseG = new Vector<>();
		this.topologicalSort = new Stack<>();
		for (int i = 0; i < V; i++) {
			G.add(new Vector<>());
		}
		for (int i = 0; i < V; i++) {
			reverseG.add(new Vector<>());
		}
		U = new boolean[V];
		id = new int[V];
		sz = new int[V];
	}

	public void resetUsed() {
		U = new boolean[V];
	}

	private void DFS(int vertex, int currentComponent) {
		U[vertex] = true;
		id[vertex] = currentComponent;
		sz[currentComponent]++;
		for (int i = 0; i < G.get(vertex).size(); i++) {
			if (!U[G.get(vertex).get(i)]) {
				DFS(G.get(vertex).get(i), currentComponent);
			}
		}
	}

	public void SCC(){
		topologicalSort();
		resetUsed();
		int currentComponent = 0;
		while (!topologicalSort.isEmpty()){
			int explore = topologicalSort.peek();
			topologicalSort.pop();
			if(!U[explore]){
				DFS(explore,currentComponent);
			}
			currentComponent++;
		}
	}

	private void topologicalSortDFS(int vertex){
		U[vertex] = true;
		for (int i = 0; i < reverseG.get(vertex).size(); i++) {
			if (!U[reverseG.get(vertex).get(i)]) {
				topologicalSortDFS(reverseG.get(vertex).get(i));
			}
		}
		topologicalSort.add(vertex);
	}

	private void topologicalSort(){
		for (int i = 0; i < reverseG.size();i++){
			if(!U[i]){
				topologicalSortDFS(i);
			}
		}
	}

	public boolean isConnected(int u, int v) {
		return id[u] == id[v];
	}

	public void connect(int u, int v) {
		G.get(u).add(v);
		// record reverse graph optimization
		reverseG.get(v).add(u);
	}

	public int[] getComponents(){
		return id;
	}

	public int[] getSizeOfEachComponentForId(){
		return sz;
	}
}
