package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	static class Action {
		int x, y;
		Action(int x, int y){
			this.x = x; this.y = y;
		}
	}
	
	static int solve(int N, List<Action> action) {
		int answer = N;
		boolean[] v = new boolean[N+1];
		
		for(Action a : action) {
			for(int i = a.x; i < a.y; i++) {
				if(v[i]) continue;
				v[i] = true;
				answer--;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Action> action = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine()); 
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			action.add(new Action(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		System.out.println(solve(N, action));
	}
}