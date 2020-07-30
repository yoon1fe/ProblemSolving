package com.ssafy.day03.ws01;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] left = {'(', '<', '{', '['};
		char[] right = {')', '>', '}', ']'};
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(sc.nextLine());
			
			String temp = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			
			int ans = 1;
			outer:
			for(int i = 0; i< N; i++) {
				for(int j = 0; j < 4; j++) {
					if(left[j] == temp.charAt(i)) {		//괄호 시작하는거면 push
						stack.push(left[j]);
						break;
					}
					else if(right[j] == temp.charAt(i)) {
						if(left[j] == stack.peek()) {
							stack.pop();
							break;
						}else {
							ans = 0;
							break outer;
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", test_case, ans);
		}
	}
}
