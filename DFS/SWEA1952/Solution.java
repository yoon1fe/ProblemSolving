import java.io.*;
import java.util.*;

public class Solution {
	static int[] cost = new int[4];
	static int[] months = new int[12];
	static int answer;
	
	public static void main(String[] args) throws IOException {
		input();
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < 4; i++) cost[i] = Integer.parseInt(st.nextToken());
			answer = cost[3];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 12; i++) months[i] = Integer.parseInt(st.nextToken());
			
			solve();
			
			System.out.println("#" + tc + " " + answer);
		}		
	}
	
	public static void solve() {
		dfs(0, 0);
	}
	
	public static void dfs(int month, int sum) {
		if(month > 11) {
			answer = Math.min(answer, sum);
			return;
		}
		
		if(months[month] == 0) dfs(month + 1, sum);
		
		dfs(month + 1, sum + months[month]*cost[0]);
		dfs(month + 1, sum + cost[1]);
		dfs(month + 3, sum + cost[2]);
	}
}
