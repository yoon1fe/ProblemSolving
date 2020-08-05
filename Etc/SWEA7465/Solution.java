package com.ssafy.day08.ws01;

import java.util.Scanner;

public class Solution {
	static int[] p;
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) p[y] = x;
	}
	
	public static int find(int x) {
		if(x == p[x]) return x;
		return p[x] = find(p[x]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			p = new int[N+1];
			for(int i =1; i<= N; i++) p[i] = i;	//make
			
			for(int i =0 ; i< M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				union(x, y);
			}
			for(int i =1; i<= N; i++) find(i);
			
			boolean[] selected = new boolean[N+1];
			int cnt = 0;
			for(int i = 1; i <= N; i++ ) if(!selected[p[i]]) selected[p[i]] = true;
			for(boolean b : selected) if(b) cnt++;
			
			sb.append("#" + test_case + " " + cnt + "\n");
		}
		System.out.println(sb.toString());
	}
}
