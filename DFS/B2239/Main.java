import java.io.*;
import java.util.*;

public class Main {
	static class Dir{
		int y, x;
		Dir(int y, int x){
			this.y = y; this.x = x;
		}
	}
	
	static int[][] board = new int[9][9];
	static int zero;
	
	public static void main(String[] args) throws IOException {
		input();
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != 0) continue;
				dfs(new Dir(i, j));
			}
		}
	}
	
	public static void printBoard() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void dfs(Dir cur) {
		
		for(int i = 1; i <= 9; i++) {
			if(check(cur, i)) {
				board[cur.y][cur.x] = i;
				zero--;
				
				if(zero == 0) {
					printBoard();
					
					System.exit(0);
				}
				
				outer:
				for(int k = 0; k < 9; k++) {
					for(int j = 0; j < 9; j++) {
						if(board[k][j] != 0) continue;
						dfs(new Dir(k, j));
						break outer;
					}
				}
				
				board[cur.y][cur.x] = 0;
				zero++;
			}
		}
		
		return;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			String temp = br.readLine();
			for(int j = 0; j < 9; j++) {
				board[i][j] = temp.charAt(j) - '0';
				if(board[i][j] == 0) zero++;
			}
		}
		
	}
	
	public static boolean check(Dir cur, int num) {
		// 행
		for(int i = 0; i < 9; i++) {
			if(board[cur.y][i] == num) return false;
		}
		
		// 열
		for(int i = 0; i < 9; i++) {
			if(board[i][cur.x] == num) return false;
		}
		
		// 사각형
		int sy = (cur.y / 3) * 3;
		int sx = (cur.x / 3) * 3;
		
		for(int i = sy; i < sy + 3; i++) {
			for(int j = sx; j < sx + 3; j++) {
				if(board[i][j] == num) return false;
			}
		}

		return true;
	}
}
