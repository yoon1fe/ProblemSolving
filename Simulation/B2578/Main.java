package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	static class Dir{
		int y, x;
		Dir(int y, int x){
			this.y = y; this.x = x;
		}
	}
	static Map<Integer, Dir> board = new HashMap<>();
	static boolean[][] checked = new boolean[5][5];
	
	public static int checkBingos() {
		int cnt = 0;
		int left = 0, right = 0;
		
		for(int i = 0; i < 5; i++) {
			int r = 0, c = 0;
			
			if(checked[i][i]) right++;
			if(checked[i][4 - i]) left++;
			
			for(int j = 0; j < 5; j++) {
				if(checked[i][j]) r++;
				if(checked[j][i]) c++;
			}
			if(r == 5) cnt++; 
			if(c == 5) cnt++;
		}
		if(left == 5) cnt++;
		if(right == 5) cnt++;
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> nums = new ArrayList<>();
		int answer = 0;
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				board.put(Integer.parseInt(st.nextToken()), new Dir(i, j));
			}
		}
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int n : nums) {
			answer++;
			Dir pos = board.get(n);
			checked[pos.y][pos.x] = true;
			if(checkBingos() >= 3) break;
		}
			
		System.out.println(answer);
	}
}


/*
11 12 2 24 10
16 1 13 3 25
6 20 5 21 17
19 4 8 14 9
22 15 7 23 18
5 10 7 16 2
4 22 8 17 13
3 18 1 6 25
12 19 23 14 21
11 24 9 20 15
 */