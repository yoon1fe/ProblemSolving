package com.ssafy.day05.ws01;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String[] cards = new String[N];
			for(int i = 0; i<N;i++) 
				cards[i] = sc.next();
		
			int Uidx = 0;
			int Didx = N%2 == 0 ? N/2 : N/2+1;
			String[] afterShuffle = new String[N];
			
			for(int i =0 ; i< N; i++) 
				afterShuffle[i] = i%2==0 ? cards[Uidx++] : cards[Didx++];
			
			System.out.print("#" + test_case + " ");
			for(String s : afterShuffle) System.out.print(s + " ");
			System.out.println();
		}
	}
}
