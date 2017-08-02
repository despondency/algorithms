package com.algorithms.graph.mst.prim;

import java.util.*;

class Edge
{
	int u;
	int v;
	int dist;
	public Edge(int u, int v, int dist){
		this.u = u;
		this.v = v;
		this.dist = dist;
	}

	public static Edge createEdge(int u, int v, int dist){
		return new Edge(u,v,dist);
	}
}

public class Prim {
	 private boolean M[];
	 private Vector<Vector<Edge>> G;
	 private List<Edge> spanningTree;
	 private int V;
	 private PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.dist));

	 public Prim(int V){
	 	this.V = V;
	 	this.M = new boolean[V];
	 	this.G = new Vector<>();
	 	this.spanningTree = new ArrayList<>();
	 	for (int i = 0; i < V;i++){
	 		G.add(new Vector<>()); // u idx -> u -> children
		}
	 }

	 public List<Edge> getSpanningTree(){
	 	return spanningTree;
	 }

	 private void expand(int vertex){
		M[vertex] = true;
	 	for(Edge e : G.get(vertex)){
					if(!M[e.v]) {
						pq.add(e);
					}
		 }
	 }

	 public void addEdge(int u, int v, int dist){
	 	G.get(u).add(Edge.createEdge(u,v,dist));
	 	G.get(v).add(Edge.createEdge(v,u,dist));
	 }

	 public int MST() {
		 int mst = 0;
		 expand(0);
		 while (!pq.isEmpty()) {
			 Edge e = pq.poll();
			 if (M[e.u] && M[e.v]) continue;
			 mst += e.dist;
			 spanningTree.add(e);
			 if (!M[e.u]) expand(e.u);
			 if (!M[e.v]) expand(e.v);
		 }
		 return mst;
	 }

}

