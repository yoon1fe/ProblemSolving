package SWEA;

import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, answer;
	static List<Integer>[] graph;
	static boolean[] v;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
			
			graph = new List[N+1];
			
			for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from].add(to);
				graph[to].add(from);
			}
			
			for(int i = 1; i <= N; i++) {
				v = new boolean[N+1];
				dfs(i, 1);
			}
			
			bw.write("#" + tc + " " + answer + "\n");
			answer = 0;
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int num, int cnt) {
		answer = Math.max(answer, cnt);
		v[num] = true;
		
		for(int i = 0; i < graph[num].size(); i++) {
			int next = graph[num].get(i);
			if(v[next] == true) continue;

			dfs(next, cnt+1);
			v[next] = false;
		}
	}
	
}
