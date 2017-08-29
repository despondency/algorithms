package com.algorithms.graph.flow;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class EdmondsKarp {

	public class Edge {
		int s,t,r,c,f;
		public Edge(int s, int t, int r, int c) {
			this.s = s;
			this.t = t;
			this.r = r;
			this.c = c;
		}
	}
	private int V;
	private Vector<Vector<Edge> > G;
	public EdmondsKarp(int V){
		this.V = V;
		this.G = new Vector<>();
		for (int i = 0;i < V;i++) {
			G.add(new Vector<>());
		}
	}

	public void connect(int s, int t, int capacity) {
		G.get(s).add(new Edge(s,t,G.get(t).size(), capacity));
		G.get(t).add(new Edge(t,s,G.get(s).size() - 1, capacity));
	}

	public long maxflow(int s, int t) {
		long flow = 0;
		while(true) {
			Edge[] path = new Edge[V];
			Queue<Integer> Q = new LinkedList<>();
			Q.add(s);
			while (!Q.isEmpty	()) {
				Integer curr = Q.poll();
				for (Edge e : G.get(curr)) {
					if (path[e.t] == null && e.t != s && e.c > e.f){
						path[e.t] = e; // aug path addition
						Q.add(e.t); // add new vertex
					}
				}
			}
			// no augmenting path found
			if (path[t] == null) {
				break;
			}
			int df = Integer.MAX_VALUE;
			for (int u = t; u != s; u = path[u].s){
				df = Math.min(df, path[u].c - path[u].f);
			}
			for (int u = t; u != s; u = path[u].s){
				path[u].f += df; // push flow
				G.get(path[u].t).get(path[u].r).f -= df; // reduce flow
			}
			flow += df;
		}
		return flow;
	}

}
