import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	int N;
	boolean[] v;			// true: A,	false: B
	int [][] synergy;
	int answer = Integer.MAX_VALUE;
	int getTasteDiff() {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		int aSum = 0, bSum = 0;
		for(int i = 0 ; i < v.length; i++) {
			if(v[i]) a.add(i);			// A
			else b.add(i);				// B
		}
		
		for(int i = 0; i < a.size(); i++) {
			for(int j = i+1; j < a.size(); j++) {
				aSum += synergy[a.get(i)][a.get(j)] + synergy[a.get(j)][a.get(i)];
				bSum += synergy[b.get(i)][b.get(j)] + synergy[b.get(j)][b.get(i)];
			}
		}
		
		return Math.abs(aSum - bSum);
	}
	void dfs(int cnt, int idx, int[][] syn) {
		if(cnt == N/2) {
			answer = Math.min(answer, getTasteDiff());
			return;
		}
		
		for(int i = idx; i < N; i++) {
			v[i] = true;
			dfs(cnt+1, i + 1, syn);
			v[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		Solution s = new Solution();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++ ) {
			s.N = Integer.parseInt(br.readLine());
			s.v = new boolean[s.N];
			s.synergy = new int[s.N][s.N];
			for(int i = 0 ; i < s.N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0 ; j < s.N; j++) {
					s.synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			s.dfs(0, 0, s.synergy);
			bw.write("#" + tc + " " + s.answer + "\n");
			s.answer = Integer.MAX_VALUE;
		}

		bw.flush();
		bw.close();
	}
}
