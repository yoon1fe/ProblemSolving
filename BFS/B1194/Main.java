import java.io.*;
import java.util.*;

public class Main {

	static class Dir{
		int y, x, keys;
		Dir(int y, int x, int keys){
			this.y = y; this.x = x; this.keys = keys;
		}
	}
	
	static int N, M;
	static char[][] map;
	static int[][][] v;
	static Dir s;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		input();
		
		System.out.println(bfs());
	}
	
	public static boolean isIn(Dir c) {
		if(0 <= c.y && c.y < N && 0 <= c.x && c.x < M) return true;
		else return false;
	}
	
	public static int bfs() {
		Queue<Dir> q = new LinkedList<>();
		
		q.offer(s);
		v[s.keys][s.y][s.x] = 1;
		
		while(!q.isEmpty()) {
			Dir cur = q.poll();
			
			if(map[cur.y][cur.x] == '1') return v[cur.keys][cur.y][cur.x] - 1; 
			
			for(int i = 0; i < 4; i++) {
				Dir next = new Dir(cur.y + dy[i], cur.x + dx[i], cur.keys);
				if(!isIn(next) || map[next.y][next.x] =='#') continue;
				if(v[cur.keys][next.y][next.x] > 0) continue;
				
				if(65 <= map[next.y][next.x] && map[next.y][next.x] <= 70) {
					if((cur.keys & 1 << map[next.y][next.x]- 'A') == 0) continue;
				}

				if(97 <= map[next.y][next.x] && map[next.y][next.x] <= 102) {
					next.keys = cur.keys | 1 << (map[next.y][next.x] - 'a');
				}

				v[next.keys][next.y][next.x] = v[cur.keys][cur.y][cur.x] + 1;
				q.offer(next);
			}
		}
	
		return -1;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		v = new int[1 << 6][N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					s = new Dir(i, j, 0);
					map[i][j] = '.';
				}
			}
		}
		
	}
	
}
