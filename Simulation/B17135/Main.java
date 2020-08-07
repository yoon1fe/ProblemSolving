package com.ssafy.day10.ws01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Dir{
	int y, x;
	Dir(int y, int x){
		this.y = y; this.x = x;
	}
}

public class Main {
	static int N, M, D;
	static int[][] map;
	static int ans = 0;
	static int enemy = 0;
	
	public static int dist(Dir a, Dir e) {
		return Math.abs(a.y - e.y) + Math.abs(a.x - e.x);
	}
	
	public static int attack() {
		int tEnemy = enemy;
		int cnt = 0;
		int[][] tempMap = new int[N+1][M];
		for(int i = 0; i <= N; i++)
			System.arraycopy(map[i], 0, tempMap[i], 0, map[i].length);
		
		ArrayList<Dir> archers = new ArrayList<>();
		for(int i =0 ; i<M; i++) {
			if(map[N][i] == 2) archers.add(new Dir(N, i));
			if(archers.size() == 3) break;
		}
		
		while(tEnemy > 0) {
			ArrayList<Dir> minDir = new ArrayList<Dir>();
			
			for(int a = 0; a < 3; a++ ) {
				int minDist = 99999;
				minDir.add(new Dir(N, 0));
				for(int j = 0; j< M; j++) {
					for(int i = N-1; i>= 0; i--) {
						if(tempMap[i][j] == 1) {
							int distance = dist(archers.get(a), new Dir(i, j));
							if(distance > D) continue;
							if(minDist > distance) {
								minDist = distance;
								minDir.get(a).y = i; minDir.get(a).x = j;
							}
						}
					}
				}		
			}
			
			for(int i = 0; i<minDir.size(); i++) {
				if(minDir.get(i).y == N || tempMap[minDir.get(i).y][minDir.get(i).x] == 0) continue;
				tempMap[minDir.get(i).y][minDir.get(i).x] = 0;
				cnt++;
				tEnemy--;
			}
			
			for(int i = 0; i< M; i++) if(tempMap[N-1][i] == 1) tEnemy--;
			for(int i = N-1; i>=0; i--) {
				for(int j = 0; j< M; j++) { 
					if(i == 0) tempMap[i][j] = 0;
					else tempMap[i][j] = tempMap[i-1][j];
				}
			}
		}
		return cnt;
	}
	
	public static void makeArcher(int cnt, int start) {
		if(cnt == 3) {
			int ret = attack();
			ans = ans > ret ? ans : ret;
			return;
		}
		
		for(int i = start; i < M; i++) {
			map[N][i] = 2;
			makeArcher(cnt+1, i+1);
			map[N][i] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) enemy++;
			}
		}
		
		makeArcher(0, 0);
		
		System.out.println(ans);
	}
}