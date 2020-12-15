import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		input();
	}
	
	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			solve(n);
		}
	}
	
	public static void solve(int n) {
		int z = 0, o = 1;
		if(n < 2) {
			o = n;
			z = 1-o;
		} else {
			int[] dp = new int[n+1];
			dp[0] = 0; dp[1] = 1;
			for(int i = 2; i <= n; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
			o = dp[n]; z = dp[n-1];
		}
		
		System.out.println(z + " " + o);
	}
}