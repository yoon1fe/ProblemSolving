package com.ssafy.day02;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String output = "";
		int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int [] box = new int[100];
			
			for(int i = 0; i< 100;i++) 
				box[i] = sc.nextInt();

			Arrays.sort(box);
			for(int i = 0; i<n; i++) {
				box[0]++;
				box[99]--;
				
				Arrays.sort(box);
			}
			output += "#" + test_case + " " + (box[99] - box[0]) + "\n";
		}
		System.out.println(output);
	}

}
