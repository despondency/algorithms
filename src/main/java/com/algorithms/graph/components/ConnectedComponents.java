package com.algorithms.graph.components;

import java.util.Vector;

public class ConnectedComponents {

	private Vector<Vector<Integer>> G;
	private int V;
	private boolean[] U;
	private int[] id;
	private int[] sz;

	public ConnectedComponents(int V) {
		this.V = V;
		this.G = new Vector<>();
		for (int i = 0; i < V; i++) {
			G.add(new Vector<>());
		}
		U = new boolean[V];
		id = new int[V];
		sz = new int[V];
	}

	public void resetUsed() {
		U = new boolean[V];
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

	public void connectedComponents() {
		int currentConnnectedComponent = 0;
		for (int i = 0; i < G.size(); i++) {
			DFS(i, currentConnnectedComponent);
			currentConnnectedComponent++;
			resetUsed();
		}
	}

	public int[] getComponents(){
		return id;
	}

	public int[] getSizeOfEachComponentForId(){
		return sz;
	}
}
