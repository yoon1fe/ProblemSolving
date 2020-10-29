import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		input();
		
	}
	

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			String order = st.nextToken();
			int[][] board = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#" + tc);
			switch(order) {
			case "up": moveUp(N, board); break;
			case "down": moveDown(N, board); break;
			case "left": moveLeft(N, board); break;
			case "right": moveRight(N, board); break;
			}
			
		}		
	}
	
	public static void printBoard(int N, int[][] board) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void moveUp(int N, int[][] board) {
		for(int i = 0; i < N; i++) {
			Deque<Integer> q = new LinkedList<>();
			List<Integer> newList = new ArrayList<>();
			
			for(int j = 0; j < N; j++) {
				if(board[j][i] == 0) continue;
				if(q.size() == 0) q.offer(board[j][i]);
				else {
					if(q.peekLast() == board[j][i]) {
						q.pollLast();
						newList.addAll(q);
						q.clear();
						newList.add(board[j][i] * 2);
					}else q.offer(board[j][i]);
				}
				board[j][i] = 0;
			}
			newList.addAll(q);
			
			for(int j = 0; j < newList.size(); j++) board[j][i] = newList.get(j);
		}
		
		printBoard(N, board);
		
	}
	
	public static void moveDown(int N, int[][] board) {
		for(int i = 0; i < N; i++) {
			Deque<Integer> q = new LinkedList<>();
			List<Integer> newList = new ArrayList<>();
			
			for(int j = N - 1; j >= 0; j--) {
				if(board[j][i] == 0) continue;
				if(q.size() == 0) q.offer(board[j][i]);
				else {
					if(q.peekLast() == board[j][i]) {
						q.pollLast();
						newList.addAll(q);
						q.clear();
						newList.add(board[j][i] * 2);
					}else q.offer(board[j][i]);
				}
				board[j][i] = 0;
			}
			newList.addAll(q);
			
			for(int j = 0; j < newList.size(); j++) board[N - 1 - j][i] = newList.get(j);
		}
		
		printBoard(N, board);
	}
	
	public static void moveLeft(int N, int[][] board) {
		for(int i = 0; i < N; i++) {
			Deque<Integer> q = new LinkedList<>();
			List<Integer> newList = new ArrayList<>();
			
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 0) continue;
				if(q.size() == 0) q.offer(board[i][j]);
				else {
					if(q.peekLast() == board[i][j]) {
						q.pollLast();
						newList.addAll(q);
						q.clear();
						newList.add(board[i][j] * 2);
					}else q.offer(board[i][j]);
				}
				board[i][j] = 0;
			}
			newList.addAll(q);
			
			for(int j = 0; j < newList.size(); j++) board[i][j] = newList.get(j);
		}
		
		printBoard(N, board);
	}
	
	public static void moveRight(int N, int[][] board) {
		for(int i = 0; i < N; i++) {
			Deque<Integer> q = new LinkedList<>();
			List<Integer> newList = new ArrayList<>();
			
			for(int j = N - 1; j >= 0; j--) {
				if(board[i][j] == 0) continue;
				if(q.size() == 0) q.offer(board[i][j]);
				else {
					if(q.peekLast() == board[i][j]) {
						q.pollLast();
						newList.addAll(q);
						q.clear();
						newList.add(board[i][j] * 2);
					}else q.offer(board[i][j]);
				}
				board[i][j] = 0;
			}
			newList.addAll(q);
			
			for(int j = 0; j < newList.size(); j++) board[i][N - 1 - j] = newList.get(j);
		}
		
		printBoard(N, board);
	}
}
