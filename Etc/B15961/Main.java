package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static int solve(int[] sushi, int[] s, int k, int c) {
		int answer = 0;
		int cnt = 1;
		s[c]++;
		for(int i = 0; i < k; i++) {
			if(s[sushi[i]] == 0) cnt++;
			s[sushi[i]]++;
		}
		
		for(int i = 0; i < sushi.length; i++) {
			if(s[sushi[(i+k) % sushi.length]] == 0) cnt++;
			s[sushi[(i+k) % sushi.length]]++;
			
			s[sushi[i]]--;
			if(s[sushi[i]] == 0) cnt--;
			answer = Math.max(answer, cnt);
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
		int[] s = new int[3001];
		int[] sushi = new int[N];
		
		for(int i = 0 ; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());
		System.out.println(solve(sushi, s, k, c));
		
	}
}
