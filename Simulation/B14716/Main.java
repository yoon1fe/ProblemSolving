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
	
	static int[][] map;
	static int M, N;
	static boolean[][] v;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		input();
	
		System.out.println(solve());
	}
	
	public static int solve() {
		int cnt = 0;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 || v[i][j]) continue;
				bfs(new Dir(i, j));
				cnt++;
			}
		}

		return cnt;
	}
	
	public static void bfs(Dir s) {
		Queue<Dir> q = new LinkedList<>();
		
		q.offer(s);
		v[s.y][s.x] = true; 
		
		while(!q.isEmpty()) {
			Dir cur = q.poll();
			
			for(int i = 0; i < 8; i++) {
				Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
				if(!isIn(next) || v[next.y][next.x] || map[next.y][next.x] == 0) continue;
				
				v[next.y][next.x] = true;
				q.offer(next);
			}
		}
	}
	
	public static boolean isIn(Dir c) {
		if(0 <= c.y && c.y < M && 0 <= c.x && c.x < N) return true;
		else return false;
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		v = new boolean[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
}