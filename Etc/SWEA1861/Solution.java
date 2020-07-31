package com.ssafy.day05.ws02;

import java.util.Scanner;

public class Solution {
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int N;
	static int[][] map;
	static int[][] cntMap;
	
	static boolean isIn(int y, int x) {
		if(0<= y && y < N && 0<= x && x < N) return true;
		else return false;
	}
	
	static int solve(int cy, int cx, int cnt) {
		for(int i =0 ; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			
			if(!isIn(ny, nx)) continue;
			if(map[ny][nx] == map[cy][cx] + 1) 
				cnt = solve(ny, nx, cnt+1);
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			cntMap = new int[N][N];
			for(int i = 0; i< N ;i++ ) {
				for(int j =0 ; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i =0 ; i< N; i++) {
				for(int j = 0; j < N; j++) {
					cntMap[i][j] = solve(i, j, 1);
				}
			}
			
			int ansNum = 9999;
			int ansCnt = 0;
			for(int i =0 ; i< N; i++) {
				for(int j = 0; j < N; j++) {
					if(ansCnt <= cntMap[i][j]) {
						if(ansCnt == cntMap[i][j]) {
							ansNum = ansNum > map[i][j] ? map[i][j] : ansNum;
						}else {
							ansNum = map[i][j];
							ansCnt = cntMap[i][j];
						}
					}
				}
			}
			System.out.print("#"+ test_case + " " + ansNum + " " + ansCnt);
		}
	}

}
