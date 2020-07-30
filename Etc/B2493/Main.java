package com.ssafy.day03.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower{
	int idx;
	int height;
	
	Tower(int idx, int height){
		this.idx = idx;
		this.height = height;
	}
}
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Stack<Tower> s = new Stack<Tower>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int []ans = new int[N];
		
		int ansIdx = 1;
		int idx = 1;
		
		while(idx <= N) {
			int h = Integer.parseInt(st.nextToken());
			if(s.isEmpty()) {
				s.add(new Tower(idx++, h));
				continue;
			}
			while(!s.isEmpty() && h > s.peek().height) {
				s.pop();
			}
			if(s.isEmpty()) ans[ansIdx++] = 0;
			else ans[ansIdx++] = s.peek().idx;
			s.add(new Tower(idx++, h));
		}

		for(int i : ans)
			System.out.print(i + " ");
	}

}
