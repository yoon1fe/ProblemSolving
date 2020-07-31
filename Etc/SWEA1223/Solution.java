package com.ssafy.day05.hw;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 1;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(sc.nextLine());
			Stack<Character> s = new Stack<Character>();
			String line = sc.nextLine();
			String postfix = "";
			
			for(int i =0 ;i<line.length(); i++) {
				if(line.charAt(i) != '+' && line.charAt(i) != '*') postfix += line.charAt(i);
				else {
					if(line.charAt(i) == '*') {
						
						s.push(line.charAt(i));
					}else {
						do {
							if(s.isEmpty()) break;
							postfix+= s.pop();
						}while(!s.isEmpty() &&s.peek()!= '+');
						s.push(line.charAt(i));
					}
				}
			}
			while(!s.isEmpty()) {
				postfix += s.pop();
			}
			
			
			System.out.println(postfix);
			
			
			Stack<Integer> calc = new Stack<Integer>();
			for(int i =0; i<postfix.length(); i++) {
				if(postfix.charAt(i) != '+' && postfix.charAt(i) != '*') {
					calc.push(postfix.charAt(i) - '0');
					
				}
				else {
					int op1 = calc.pop();
					int op2 = calc.pop();
					char operator = postfix.charAt(i);
					switch(operator) {
					case '*':
						int times = op1 * op2;
						calc.push(times);
						break;
					case '+':
						int plus = op1 + op2;
						calc.push(plus);
						break;
					}
				}
			}
		
			System.out.println("#" + test_case + " " + calc.peek());
		
		
		}
	}

}
