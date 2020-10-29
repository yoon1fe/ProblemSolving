import java.io.*;
import java.util.*;

public class Main {

	static class Dir{
		int y, x;
		Dir(int y, int x){
			this.y = y; this.x = x;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int remained, last;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		input();
		
		System.out.println(solve());
		System.out.println(last);
	}
	
	public static int solve() {
		int time = 0;
		
		while(true) {
			time++;
			
			bfs(new Dir(0, 0));
			if(remained == 0) break;
		}
		
		return time;
	}
	
	public static void bfs(Dir s) {
		Queue<Dir> q = new LinkedList<>();
		List<Dir> adj = new ArrayList<>();
		boolean[][] v = new boolean[N][M];
		
		q.offer(s);
		v[s.y][s.x] = true;
		
		while(!q.isEmpty()) {
			Dir cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
				if(!isIn(next) || v[next.y][next.x]) continue;
				
				if(map[next.y][next.x] == 0) q.offer(next);
				else if(map[next.y][next.x] == 1) adj.add(next);
				
				v[next.y][next.x] = true; 
			}
		}
		
		last = remained;
		remained -= adj.size();
		
		for(Dir c : adj) {
			map[c.y][c.x] = 0; 
		}
		
	}
	
	public static boolean isIn(Dir c) {
		if(0 <= c.y && c.y < N && 0 <= c.x && c.x < M) return true;
		else return false;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) remained++;
			}
		}
		
	}
}
