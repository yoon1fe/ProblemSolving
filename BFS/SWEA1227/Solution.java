import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dir{
	int y, x;
	Dir(int y, int x){
		this.y = y; this.x = x;
	}
}

public class Solution {
	static String[] map;
	static Dir s = null, d = null;
	static final int N = 100;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	static boolean isIn(Dir cur) {
		if(0<= cur.y && cur.y < N && 0<= cur.x && cur.x < N) return true;
		else return false;
	}
	
	static int bfs(Dir start) {
		boolean [][] visited = new boolean[N][N];
		Queue<Dir> q = new LinkedList<Dir>();
		q.offer(start);
		visited[start.y][start.x] = true; 
		
		while(!q.isEmpty()) {
			Dir cur = q.poll();
			
			for(int i =0 ; i< 4; i++) {
				Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
				if(!isIn(next)) continue;
				if(!visited[next.y][next.x]&& map[next.y].charAt(next.x) != '1') {
					visited[next.y][next.x] = true;
					q.offer(next);
				}
			}
		}
		return visited[d.y][d.x] == true ? 1 : 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case= 1; test_case <= T; test_case++) {
			Integer.parseInt(sc.nextLine());
			map = new String[N];
			
			for(int i = 0; i< N; i++) {
				map[i] = sc.nextLine();
				if(map[i].indexOf('2') != -1) s = new Dir(i, map[i].indexOf('2'));
				if(map[i].indexOf('3') != -1) d = new Dir(i, map[i].indexOf('3'));
			}

			System.out.println("#" + test_case + " " + bfs(s));
		}
	}
}
