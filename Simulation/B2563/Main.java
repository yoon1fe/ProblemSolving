package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer = 0;
		boolean[][] paper = new boolean[100][100];
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for(int i = y; i < y + 10; i++) {
				for(int j = x; j < x + 10; j++) {
					if(paper[i][j]) continue;
					paper[i][j] = true;
					answer++;
				}
			}
		}
		System.out.println(answer);
	}		
}
