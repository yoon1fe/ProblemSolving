package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] dy = {-1, 0, 1};
	static int[] dx = {1, 1, 1};
	static int R, C, answer;
	static char[][] map;
	static boolean[][] v;
	
	static class Dir{
		int y, x;
		Dir(int y ,int x){
			this.y = y; this.x = x;
		}
	}
	
	public static boolean isIn(Dir c) {
		if(0<= c.y && c.y < R && 0 <= c.x && c.x < C) return true;
		else return false;
	}
	
	public static boolean dfs(Dir cur) {
		if(cur.x == C - 1) return true;
		
		for(int i = 0; i < 3; i++) {
			Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
			if(!isIn(next) || v[next.y][next.x] || map[next.y][next.x] == 'x') continue;
			
			v[next.y][next.x] = true; 
			if(dfs(next)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];
		
		for(int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
		for(int i = 0; i < R; i++) answer = dfs(new Dir(i, 0)) == true ? answer+1 : answer;
		
		System.out.println(answer);
	}
}
