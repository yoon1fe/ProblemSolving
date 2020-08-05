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
	static int M, N;
	static int ans = 0;
	static int[][] box;
	static int[][] visited;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static ArrayList<Dir> tomatoes = new ArrayList<Dir>();
	
	static boolean isIn(Dir cur) {
		if(0<= cur.y && cur.y < N && 0<= cur.x && cur.x < M) return true;
		else return false;
	}
	
	static int bfs() {
		Queue<Dir> q = new LinkedList<Dir>();
		for(Dir t : tomatoes) {
			visited[t.y][t.x] = 1;
			q.offer(t);
		}
		
		while(!q.isEmpty()) {
			Dir cur = q.poll();
			
			for(int i =0; i< 4; i++) {
				Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
				if(!isIn(next) || box[next.y][next.x] == -1 || visited[next.y][next.x] != 0 ) continue;
				
				q.offer(next);
				visited[next.y][next.x] = visited[cur.y][cur.x] + 1;
				ans = ans > visited[next.y][next.x] ? ans : visited[next.y][next.x]; 
			}
		}
		
		outer:
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] == 0 && box[i][j] != -1) {
					ans = 0;
					break outer;
				}
			}
		}
		return ans - 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		boolean isFull = true;
		box = new int[N][M];
		visited = new int[N][M];
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j] == 1) tomatoes.add(new Dir(i, j));
				if(box[i][j] == 0) isFull = false;
			}
		}
		
		if(isFull) System.out.println("0");
		else System.out.println(bfs());
	}
}
