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
    static int[] dx = {0, 1, 0, -1};		// 상, 우, 하, 좌
    static int N, M, R, C, L;				// 세로, 가로, 맨홀 위치(R, C), 탈출 후 소요된 시간 L
    static int[][] map;
    static Dir start;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());	
			start = new Dir(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bw.write("#" + tc + " " + bfs(start) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int bfs(Dir s) {
		Queue<Dir> q = new LinkedList<>();
		int[][] v = new int[N][M];
		int answer = 0;
		
		q.offer(s);
		v[s.y][s.x] = 1;
		
		while(!q.isEmpty()) {
			Dir cur = q.poll();
			
			if(v[cur.y][cur.x] == L) break;
			
			switch(map[cur.y][cur.x]) {
			case 1:
				for(int i = 0; i < 4; i++) makeNext(q, v, cur, i); 
				break;
			case 2:
				for(int i = 0; i < 3; i+=2) makeNext(q, v, cur, i); 
				break;
			case 3:
				for(int i = 1; i < 4; i+=2) makeNext(q, v, cur, i); 
				break;
			case 4:
				for(int i = 0; i < 2; i++) makeNext(q, v, cur, i); 
				break;
			case 5:
				for(int i = 1; i < 3; i++) makeNext(q, v, cur, i); 
				break;
			case 6:
				for(int i = 2; i < 4; i++) makeNext(q, v, cur, i); 
				break;
			case 7:
				for(int i = 0; i < 4; i+=3) makeNext(q, v, cur, i); 
				break;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(v[i][j] == 0) continue;
				answer++;
			}
		}
		
		return answer;
	}

	private static void makeNext(Queue<Dir> q, int[][] v, Dir cur, int i) {
		Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
		if(!isIn(next) || v[next.y][next.x] != 0) return;
		if(!check(i, next)) return;
		
		q.offer(next);
		v[next.y][next.x] = v[cur.y][cur.x] + 1;
	}
	
	public static boolean check(int d, Dir next) {
		switch(d) {
		case 0:
			if(map[next.y][next.x] == 1 || map[next.y][next.x] == 2 || map[next.y][next.x] == 5 || map[next.y][next.x] == 6) return true;
			break;
		case 1:
			if(map[next.y][next.x] == 1 || map[next.y][next.x] == 3 || map[next.y][next.x] == 6 || map[next.y][next.x] == 7) return true;
			break;
		case 2:
			if(map[next.y][next.x] == 1 || map[next.y][next.x] == 2 || map[next.y][next.x] == 4 || map[next.y][next.x] == 7) return true;
			break;
		case 3:
			if(map[next.y][next.x] == 1 || map[next.y][next.x] == 3 || map[next.y][next.x] == 4 || map[next.y][next.x] == 5) return true;
			break;
		}
		return false;
	}
	
	public static boolean isIn(Dir c) {
		if(0 <= c.y && c.y < N && 0 <= c.x && c.x < M) return true;
		else return false;
	}
	
}
