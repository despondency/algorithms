package com.algorithms.graph.sssp;

import java.util.Stack;
import java.util.Vector;

public class DAGShortestPath {

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

	public class Pair {

		int dist;
		int to;

		public Pair(int dist, int to) {
			this.dist = dist;
			this.to = to;
		}
	}

	private int V;
	private Vector<Vector<Edge >> G;
	private Stack<Integer> topologicalOrder;
	private static final int INF = 1000000000;
	private boolean[] M;
	public DAGShortestPath(int V){
		this.V = V;
		this.G = new Vector<>();
		for(int i = 0 ;i < V;i++){
			G.add(new Vector<>());
		}
		this.M = new boolean[V];
		this.topologicalOrder = new Stack<>();
	}

	public void dfs(int vertex){
		M[vertex] = true;
		for(Edge e : G.get(vertex)){
			if(!M[e.v]){
				dfs(e.v);
			}
		}
		topologicalOrder.add(vertex);
	}

	public void connect(int u, int v,int dist){
		G.get(u).add(new Edge(u,v,dist));
	}

	public void topologicalSort(){
		for(int i = 0 ; i <V;i++){
			if (!M[i]){
				dfs(i);
			}
		}
	}

	public int[] shortestPaths(){
			topologicalSort();
			int dist[] = new int[V];
			for(int i = 0 ; i< V;i++){ dist[i] = INF; }
			dist[0] = 0;
			while(!topologicalOrder.isEmpty()){
				Integer vertex = topologicalOrder.peek();
				topologicalOrder.pop();
				for(Edge outgoing : G.get(vertex)){
					if (dist[vertex] + outgoing.dist < dist[outgoing.v]) {
						dist[outgoing.v] = dist[vertex] + outgoing.dist;
					}
				}
			}
			return dist;
	}

}
