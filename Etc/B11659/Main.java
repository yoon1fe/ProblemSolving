import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		input();
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		int[] prefixSum = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			prefixSum[i] = Integer.parseInt(st.nextToken()) + prefixSum[i-1];
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(prefixSum[j] - prefixSum[i-1]);
		}
	}
}