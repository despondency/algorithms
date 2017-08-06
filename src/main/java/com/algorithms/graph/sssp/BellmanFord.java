package com.algorithms.graph.sssp;

import java.util.Vector;

public class BellmanFord {

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

	private int V;
	private Vector<Vector<Edge> > G;
	private int S;
	private static final int INF = 1000000000;
	private final boolean isDirected;

	public BellmanFord(int V, int S, boolean isDirected) {
		this.V = V;
		this.S = S;
		this.G = new Vector<>();
		for(int i = 0;i < V;i++){
			G.add(new Vector<>());
		}
		this.isDirected = isDirected;
	}

	public void connect(int u, int v, int dist){
		G.get(u).add(new Edge(u,v,dist));
		if(!isDirected){
			G.get(v).add(new Edge(v,u,dist));
		}
	}

	public int[] shortestPaths() throws Exception{
		int dist[] = new int[V];
		for (int i = 0; i < V; i++) {
			dist[i] = INF;
		}
		dist[S] = 0;
		// relax V-1 times all V edges
		for (int i = 0; i < V - 1; i++) {
			for (int w = 0; w < V; w++) {
				for (Edge e : G.get(w)) {
					dist[e.v] = Math.min(dist[e.v], dist[e.u] + e.dist);
				}
			}
		}
		// if we can relax an edge one more time, well, bad luck, we have a negative cycle
		// which we can use to continuously exploit until the shortest path goes -INF
		// check for negative cycle // one more pass
		for(int u = 0;u < V;u++) {
			for(Edge e : G.get(u)){
				if(dist[e.v] > dist[e.u] + e.dist){
					throw new Exception("Negative Cycle Detected.");
				}
			}
		}
		return dist;
	}
}
