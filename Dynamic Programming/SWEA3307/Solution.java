package SWEA;

import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		Solution s = new Solution();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++ ) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			List<Long> list = new ArrayList<>();
			int[] dp = new int[N+1];
			for(int i = 0; i < N; i++) {
				list.add(Long.parseLong(st.nextToken()));
			}
			 
			for(int i = 0; i < list.size(); i++) {
				if(dp[i] == 0) dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(list.get(j) < list.get(i) && dp[i] < 1 + dp[j]) {
						dp[i] = 1 + dp[j];
					}
				}
			}
			bw.write("#" + tc + " " + Arrays.stream(dp).max().getAsInt() + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
