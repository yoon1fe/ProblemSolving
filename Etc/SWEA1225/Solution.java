package com.ssafy.day03.ws02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i = 0; i< 8; i++) {
				q.offer(sc.nextInt());
			}
			
			outer:
			while(true) {
				for(int i = 1; i<= 5; i++) {
					int front = q.poll();
					front -= i;
					if(front < 1) front = 0;
					q.offer(front);
					if(front < 1) break outer;
				}
			}
			
			System.out.print("#" + test_case + " ");
			while(!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}

}
