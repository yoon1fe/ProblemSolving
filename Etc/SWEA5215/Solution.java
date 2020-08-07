package com.ssafy.day10.ws03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Stuff{
	int taste, calorie;
	Stuff(int taste, int calorie){
		this.taste = taste; this.calorie = calorie;
	}
}

public class Solution {
	static Stuff[] stuff;
	static boolean[] isSelected;
	public static int N, L;
	static int ans = 0;
	static int total = 0;

	static void solve(ArrayList<Stuff> list) {
		int tasteSum = 0;
		int calSum = 0;
		for(Stuff s : list) {
			tasteSum+= s.taste;
			calSum += s.calorie;
		}
		
		if(calSum > L) return;
		ans = Math.max(ans, tasteSum);
	}
	
	static void makeSubset(int cnt) {
		if(cnt == N) {
			ArrayList<Stuff> list = new ArrayList<>();
			for(int i = 0; i< N; i++) {
				if(isSelected[i]) list.add(stuff[i]);
			}
			//total++;
			//System.out.println();
			if(list.size() == 0) return;
			solve(list);
			return;
		}
		
		isSelected[cnt] = true;
		makeSubset(cnt+1);
		isSelected[cnt] = false;
		makeSubset(cnt+1);
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ans = 0; 
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			stuff = new Stuff[N];
			isSelected = new boolean[N];
			
			for(int i =0 ;i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				stuff[i] = new Stuff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			makeSubset(0);
			
			
			sb.append("#" + test_case + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

}
