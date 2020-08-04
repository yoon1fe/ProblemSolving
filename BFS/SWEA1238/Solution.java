package com.ssafy.day07.ws01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int [][] graph;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	static int bfs(int start) {
		int [] visited = new int[101];
		int maxCnt = 0, ans = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 1; i< 101; i++) {
				if(graph[cur][i] != 1 || visited[i] != 0) continue;

				visited[i] = visited[cur]+1;
				q.offer(i);
			}
			maxCnt = visited[cur];
		}
		
		for(int i = 1 ; i< 101; i++) {
			if(maxCnt != visited[i]) continue;
			ans = ans > i ? ans : i;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case= 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int start = sc.nextInt();
			graph = new int[101][101];
			
			for(int i = 0; i < N/2; i++) 
				graph[sc.nextInt()][sc.nextInt()] = 1;
			
			System.out.println("#" + test_case + " " + bfs(start));
		}
	}
}
