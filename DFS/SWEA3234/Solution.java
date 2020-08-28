package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	int N;
	int ans;
	
	void dfs(int cnt, int[] w, boolean[] v, int l, int r) {
		if(cnt == N) {
			ans++;
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			if(v[i]) continue; 
			v[i] = true;
			if(l >= r + w[i]) {
				dfs(cnt+1, w, v, l, r + w[i]);
			}
			dfs(cnt+1, w, v, l+w[i], r);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution s = new Solution();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			s.N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int[] weights = new int[s.N];
			boolean[] v = new boolean[s.N];
			int left = 0, right = 0;
			
			for(int i = 0; i < s.N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			s.dfs(0, weights, v, left, right);
			bw.write("#" + tc + " " + s.ans + "\n");
			s.ans = 0;
		}
		bw.flush();
		bw.close();
	}
}
