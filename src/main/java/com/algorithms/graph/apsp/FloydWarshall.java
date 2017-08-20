package com.algorithms.graph.apsp;

public class FloydWarshall {

		private int G[][];
		private int V;
		private boolean isDirected;
		private int INF = 1000000000;

		public FloydWarshall(int V, boolean isDirected){
			this.V = V;
			this.isDirected = isDirected;
			this.G = new int[V][];
			for (int i = 0; i < V; i++) {
				G[i] = new int[V];
				for (int j = 0; j < V; j++)
					G[i][j] = INF;
				G[i][i] = 0;
			}

		}

		public void connect(int u, int v, int dist){
			G[u][v] = dist;
			if (!isDirected){
				G[v][u] = dist;
			}
		}

		public int[][] floydWarshallASPS(){
			for(int k = 0 ; k < V; k++){
				for(int i = 0; i < V; i++){
					for(int j = 0 ; j < V;j++){
						G[i][j] = Math.min(G[i][j], G[i][k] + G[k][j]);
					}
				}
			}
			return G;
		}
}

