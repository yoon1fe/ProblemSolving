package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new ArrayList[N+1];
		int[] inDegree = new int[N+1];
		
		for(int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int forward = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			
			graph[forward].add(back);
			inDegree[back]++;
		}
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) pq.offer(i);
		}
		
		while(!pq.isEmpty()) {
			int node = pq.poll();
			
			System.out.print(node + " ");
			
			for(int i = 0; i < graph[node].size(); i++) {
				int next = graph[node].get(i);
				
				if(--inDegree[next] == 0) {
					pq.offer(next);
				}
			}
		}
	}
}