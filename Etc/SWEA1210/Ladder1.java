package com.ssafy.day02;

import java.util.Arrays;
import java.util.Scanner;

public class Ladder1 {
	static int size = 100;
	
	private static boolean isIn(int y, int x) {
		if(0<= y && y < size && 0<= x && x < size) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String output = "";
		int[] dy = {0, 0, -1};
		int[] dx = {1, -1, 0};
		
		int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int [][] ladder = new int[size][size];
			boolean [][] checked = new boolean[size][size];
			
			for(int i = 0; i< size;i++) 
				for(int j = 0; j<size;j++)
					ladder[i][j] = sc.nextInt();
			
			for(int i = 0; i<size;i++) {
				if(ladder[size-1][i] == 2) {
					int cy = size-1;
					int cx = i;
					int ny = size;
					int nx = size;
					
					while(ny != 0) {
						for(int j = 0; j< 3; j++) {
							ny = cy + dy[j];
							nx = cx + dx[j];
							if(!isIn(ny, nx)) continue;
							if(ladder[ny][nx] == 1 && !checked[ny][nx]) {
								cy = ny;
								cx = nx;
								checked[cy][cx] = true;
								break;
							}
						}					
					}
					
					output += "#" + test_case + " " + nx + "\n";
					
					break;
				}
			}
			
		}
		System.out.println(output);
	}
}
