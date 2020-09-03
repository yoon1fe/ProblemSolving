package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int to, weight;
		Node(int to, int weight) {
			this.to = to; this.weight = weight;
		}
	}
	
	static List<Map<Integer, Integer>> graph;		// to, weight
	static int N;
	static int sum = 0;
	static int answer = Integer.MAX_VALUE;
	static boolean[] v;
	
	public static void dfs(int cnt, int idx) {
		if(cnt == N) {
			if(!graph.get(idx).containsKey(0)) return;
			
			sum += graph.get(idx).get(0);
			answer = Math.min(answer, sum);
			sum -= graph.get(idx).get(0);
			return;
		}
		
		for(Integer to : graph.get(idx).keySet()) {
			if(to == 0) continue;
			if(v[to]) continue;
			if(sum + graph.get(idx).get(to) > answer) continue;
			v[to] = true;
			sum += graph.get(idx).get(to);
			dfs(cnt+1, to);
			v[to] = false; 
			sum -= graph.get(idx).get(to);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		v = new boolean[N];
		graph = new ArrayList<>();
		for(int i = 0; i < N; i++) graph.add(new HashMap<>());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int w = Integer.parseInt(st.nextToken());
				if(w == 0) continue;
				graph.get(i).put(j, w);
			}
		}

		dfs(1, 0);
		
		System.out.println(answer);
	}
}