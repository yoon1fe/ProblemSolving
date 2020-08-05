import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dir{
	int y, x;
	Dir(int y, int x){
		this.y = y; this.x = x;
	}
}

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
	static int N, M;
	static boolean isIn(Dir cur) {
		if(0<= cur.y && cur.y < M && 0<= cur.x && cur.x < N) return true;
		else return false;
	}
	
	static void bfs(Dir s) {
		Queue<Dir> q = new LinkedList<>();
		q.offer(s);
		visited[s.y][s.x] = true;
		
		while(!q.isEmpty()) {
			Dir cur = q.poll();
			
			for(int i =0 ; i < 8 ; i++) {
				Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
				if(!isIn(next) || visited[next.y][next.x] || map[next.y][next.x]!= 1 ) continue;
				
				q.offer(next);
				visited[next.y][next.x] = true; 
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		
		while(N != 0 && M != 0) {
			map = new int[M][N];
			visited = new boolean[M][N];
			int cnt = 0;
			for(int i = 0; i< M; i++) {
				for(int j = 0; j< N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i< M; i++) {
				for(int j = 0; j< N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(new Dir(i, j));
						cnt++;
					}
				}
			}
			
			sb.append(cnt + "\n");
			
			N = sc.nextInt();
			M = sc.nextInt();
		}
		
		System.out.println(sb.toString());
	}
}
