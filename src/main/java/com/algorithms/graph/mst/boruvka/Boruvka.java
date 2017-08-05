package com.algorithms.graph.mst.boruvka;

import java.util.Vector;

public class Boruvka {

	public class Edge {

		int u;
		int v;
		int dist;

		public Edge(int u, int v, int dist) {
			this.u = u;
			this.v = v;
			this.dist = dist;
		}
	}

	private Vector<Edge> G;
	private Vector<Edge> mstEdges;
	private int[] id;
	private int[] depth;
	private int components;
	private int V;

	public Boruvka(int V) {
		this.V = V;
		this.components = V;
		this.id = new int[V];
		this.depth = new int[V];
		this.mstEdges = new Vector<>();
		this.G = new Vector<>();
		for (int i = 0; i < V; i++) {
			id[i] = i;
			depth[i] = 1;
		}
	}

	public void addEdge(int u, int v, int dist) {
		Edge uEdge = new Edge(u, v, dist);
		Edge vEdge = new Edge(v, u, dist);
		G.add(vEdge);
		G.add(uEdge);
	}

	public int root(int u) {
		while (id[u] != u) {
			id[u] = id[id[u]];
			u = id[u];
		}
		return u;
	}

	public boolean isConnected(int u, int v) {
		return root(u) == root(v);
	}

	public void union(int u, int v) {
		int uRoot = root(u);
		int vRoot = root(v);
		if (depth[uRoot] < depth[vRoot]) {
			id[vRoot] = uRoot;
			depth[uRoot] += depth[vRoot];
		}
		else {
			id[uRoot] = vRoot;
			depth[vRoot] += depth[uRoot];
		}
		components--;
	}

	public int MST() {
		int mst = 0;

		for (int i = 1; i < V && mstEdges.size() < V - 1 ; i += i){
			Edge bestDist[] = new Edge[V];
			for(Edge e : G){
				int u = e.u; int v = e.v;
				int rootU = root(u);
				int rootV = root(v);
				if(rootU == rootV) continue;
				if(bestDist[rootU] == null || bestDist[rootU].dist > e.dist){
					bestDist[rootU] = e;
				}
				if(bestDist[rootV] == null || bestDist[rootV].dist > e.dist){
					bestDist[rootV] = e;
				}
			}
			for(int w = 0; w < V;w++){
				Edge cur = bestDist[w];
				if(cur != null){
					if(!isConnected(cur.u,cur.v)){
						mstEdges.add(cur);
						mst+=cur.dist;
						union(cur.u,cur.v);
					}
				}
			}
		}
		return mst;
	}
}
