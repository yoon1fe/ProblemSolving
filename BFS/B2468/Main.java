package com.ssafy.day10.ws02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dir{
	int y, x;
	Dir(int y, int x){
		this.y = y; this.x = x;
	}
}

public class Main {
	static int N;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[][] map;
	
	static boolean isIn(Dir c) {
		if(0<= c.y && c.y < N && 0<= c.x && c.x < N) return true;
		else return false;
	}
	
	static void bfs(Dir cur, boolean[][] map) {
		Queue<Dir> q = new LinkedList<Dir>();
		q.offer(cur);
		map[cur.y][cur.x] = true;
		
		while(!q.isEmpty()) {
			Dir c = q.poll();
			
			for(int i = 0; i< 4; i++) {
				Dir next = new Dir(c.y + dy[i], c.x + dx[i]);
				if(!isIn(next) || map[next.y][next.x] ) continue;
				q.offer(next);
				map[next.y][next.x] = true;
			}
		}
	}
	
	static int rainning(int height) {
		int cnt = 0;
		boolean[][] afterRain = new boolean[N][N];
		
		for(int i =0 ;i < N; i++) {
			for(int j = 0 ; j< N; j++) {
				if(map[i][j] <= height) afterRain[i][j] = true;
			}
		}
		
		for(int i =0 ;i < N; i++) {
			for(int j = 0 ; j< N; j++) {
				if(!afterRain[i][j]) {
					cnt++;
					bfs(new Dir(i, j), afterRain);
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =	Integer.parseInt(br.readLine());
		map = new int[N][N];
		int maxLen = 0;
		StringTokenizer st;
		int ans = 0;
		
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j< N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxLen = Math.max(maxLen, map[i][j]);
			}
		}
		
		for(int i = 0; i< maxLen; i++) 
			ans = Math.max(ans, rainning(i));
		
		System.out.println(ans);
	}
}
