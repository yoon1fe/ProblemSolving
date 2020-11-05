package SWEA;

import java.io.*;
import java.util.*;

public class Solution {
	
	static class Dir{
		int y, x;
		Dir(int y, int x){
			this.y = y; this.x = x;
		}
	}
	
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, W, H, answer = Integer.MAX_VALUE;
    static int[][] map;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken()); W = Integer.parseInt(st.nextToken());	H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j <W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < W; i++) 
				dfs(0, map, i);
			
			bw.write("#" + tc + " " + answer + "\n");
			answer = Integer.MAX_VALUE;
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int cnt, int[][] map, int ball) {
		if(cnt == N) {
			answer = Math.min(answer, check(map));
			return;
		}
		
		int[][] temp = makeTempMap(map, ball);
		
		for(int i = 0; i < W; i++) {
			dfs(cnt + 1, temp, i);
		}
	}
	
	public static int check(int[][] map) {
		int cnt = 0;
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] != 0) cnt++;
			}
		}
		
		return cnt;
	}
	
	public static int[][] makeTempMap(int[][] map, int ball) {
		int[][] temp = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			if(map[i][ball] == 0) continue;
			
			return boom(map, new Dir(i, ball));		// 벽돌 찾으면 새로운 벽돌 리턴
		}
		
		return map;									// 벽돌 못찾았으면 원래 맵 리턴
	}
	
	public static int[][] boom(int[][] map, Dir s){
		int[][] temp = new int[H][W];
		Queue<Dir> q = new LinkedList<>();
		boolean[][] v = new boolean[H][W];
		
		q.offer(s);
		v[s.y][s.x] = true;
		
		while(!q.isEmpty()) {
			Dir cur = q.poll();
			
			for(int i = 0; i < map[cur.y][cur.x]; i++) {
				for(int j = 0; j < 4; j++) {
					Dir next = new Dir(cur.y + dy[j] * i, cur.x + dx[j] * i);
					if(!isIn(next) || v[next.y][next.x] || map[next.y][next.x] == 0) continue;

					v[next.y][next.x] = true;
					q.offer(next);
				}
			}
		}

		for(int i = 0; i < W; i++) {
			List<Integer> list = new ArrayList<>();
			
			for(int j = H - 1; j >= 0; j--) {
				if(v[j][i]) continue;
				list.add(map[j][i]);
			}
			
			for(int j = 0; j < list.size(); j++) {
				temp[H - 1 - j][i] = list.get(j);
			}
		}
		
		return temp;
	}
	
	public static boolean isIn(Dir c) {
		if(0 <= c.y && c.y < H && 0 <= c.x && c.x < W) return true;
		else return false;
	}
	
}
