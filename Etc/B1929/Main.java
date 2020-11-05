import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] isNotPrime = new boolean[N + 1];
		
		isNotPrime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(isNotPrime[i]) continue;
			for(int j = i + i; j <= N; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(!isNotPrime[i]) System.out.println(i);
		}
	}		
}