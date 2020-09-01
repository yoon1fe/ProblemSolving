package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int to, weight;
		
		Node(int to, int weight){
			this.to = to; this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, E;
	static Map<Integer, List<Node>> graph = new HashMap<>();
	final static int INF  = Integer.MAX_VALUE;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dist = new int[V + 1];
		
		for(int i = 1; i <= V; i++) graph.put(i, new ArrayList<>());
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, weight));
		}
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		Dijkstra(start);
		
		for(int i = 1; i <= V; i++)
			System.out.println(dist[i] != INF ? dist[i] : "INF");
	}

	public static void Dijkstra(int s) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		boolean[] v = new boolean[V + 1];
		q.offer(new Node(s, 0));
		dist[s] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int curPos = cur.to;
			
			if(v[curPos]) continue;
			v[curPos] = true;
			
			for(Node node : graph.get(curPos)) {
				if(dist[node.to] > dist[curPos] + node.weight) {
					dist[node.to] = dist[curPos] + node.weight;
					q.add(new Node(node.to, dist[node.to]));
				}
			}
		}
	}
}