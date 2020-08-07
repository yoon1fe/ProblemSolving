package com.ssafy.day10.ws03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dir{
	int y, x;
	Dir(int y, int x){
		this.y = y; this.x = x;
	}
}

public class Solution {
	public static int[][] map;
	public static int N, M;
	public static boolean[][] notAvail;
	public static int cnt = 0;
	public static double dist(Dir a, Dir b) {
		return Math.pow(Math.pow(a.y- b.y, 2) + Math.pow(a.x - b.x, 2), 0.5);
	}
	
	public static boolean isIn(Dir c) {
		if(0<= c.y && c.y < M && 0<= c.x && c.x < N) return true;
		else return false;
	}
	
	public static int solve() {
		cnt = 0;
		for(int i =0; i<map.length; i++) {
			for(int j = 0; j<map[i].length; j++) {
				if(!notAvail[i][j]) {
					cnt++;
					Dir next = new Dir(i+2, j);
					if(isIn(next)) notAvail[next.y][next.x] = true;
					next = new Dir(i, j+2);
					if(isIn(next)) notAvail[next.y][next.x] = true;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			notAvail = new boolean[M][N];
			
			System.out.println("#" + test_case + " " + solve());
		}
	}

}
