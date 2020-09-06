package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); 
		int S = Integer.parseInt(st.nextToken());

		int[] sums = new int[N + 1];
		int[] list = new int[N + 1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			sums[i] = sums[i-1] + list[i];
		}
		int answer = Integer.MAX_VALUE;
		
		for(int i = 1; i <= N; i++) {
			if(sums[N] - sums[i-1] < S) continue;
			
			int start = i, end = N;
			
			while(start+1 < end) {
				int mid = (start + end) / 2;
				if(sums[mid] - sums[i-1] < S) start = mid;
				else end = mid;
			}
			answer = Math.min(answer, end-i+1);
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}