package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static String[] map;
	static int[][][] v;
	static int N, M;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	static class Dir{
		int y, x;
		boolean breaked;
		Dir(int y, int x, boolean breaked) {
			this.y = y; this.x = x; this.breaked = breaked;
		}
	}
	
	static boolean isIn(Dir c) {
		if(0 <= c.y && c.y < N && 0 <= c.x && c.x < M) return true;
		else return false;
	}
	
	public static int bfs() {
		Queue<Dir> q = new LinkedList<>();
		q.offer(new Dir(0, 0, false));
		
		v[0][0][0] = 1;
		while(!q.isEmpty()){
			Dir cur = q.poll();
			
			if(cur.y == N-1 && cur.x == M-1) {
				return cur.breaked == true ? v[cur.y][cur.x][1] : v[cur.y][cur.x][0];
			}
			
			for(int i = 0; i < 4; i++) {
				Dir next = new Dir(cur.y + dy[i], cur.x + dx[i], false);
				if(!isIn(next)) continue;
				
				if(cur.breaked == true) {								// 벽 부순적 있을 때
					if(v[next.y][next.x][1] != 0) continue;
					if(map[next.y].charAt(next.x) == '0') {
						v[next.y][next.x][1] = v[cur.y][cur.x][1] + 1;
						next.breaked = true;
						q.offer(next);
					}
				}else {													// 벽 부순적 없을 때
					if(v[next.y][next.x][0] != 0) continue;
					if(map[next.y].charAt(next.x) == '0') {
						v[next.y][next.x][0] = v[cur.y][cur.x][0] + 1;
						q.offer(next);
					}else {
						v[next.y][next.x][1] = v[cur.y][cur.x][0] + 1;
						next.breaked = true;
						q.offer(next);
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map = new String[N];
		v = new int[N][M][2];
		
		for(int i = 0; i < N; i++) map[i] = br.readLine();
		
		System.out.println(bfs());
	}
}