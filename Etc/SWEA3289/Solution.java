package com.ssafy.day07.ws02;

import java.util.Scanner;

public class Solution {
	static int []p;
	
	static int find(int a) {
		if(p[a]==a) return a;
		return p[a] = find(p[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if(aRoot != bRoot) p[bRoot] = aRoot;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder output = new StringBuilder();
			output.append("#" + test_case + " ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			p = new int[N+1];
			for(int i =1; i <= N; i++) p[i] = i;
			
			for(int i =0 ; i < M; i++) {
				int o = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				switch(o) {
				case 0:
					union(a,  b);
					break;
				case 1:
					output.append(find(a) == find(b) ? "1" : "0");
					break;
				}
			}

			System.out.println(output.toString());
		}
	}

}
