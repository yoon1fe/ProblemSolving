package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static boolean[] alpha = new boolean[26];
	static char[][] map;
	static int R, C;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int answer = 0;
	
	public static boolean isIn(int y, int x) {
		if(0<= y && y < R && 0<= x && x < C) return true;
		else return false;
	}
	
	public static void dfs(int y, int x, int cnt) {
		answer = Math.max(answer, cnt);
		
		for(int i = 0 ; i < 4; i++) {
			int ny = y + dy[i], nx = x + dx[i];
			if(!isIn(ny, nx) || alpha[map[ny][nx]-65]) continue;
			alpha[map[ny][nx]-65] = true;
			dfs(ny, nx, cnt+1);
			alpha[map[ny][nx]-65] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String temp = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		alpha[map[0][0]-65] = true;
		dfs(0, 0, 1);
		System.out.println(answer);
	}
}
