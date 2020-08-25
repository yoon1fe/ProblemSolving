package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int solve(int n, int r, int c) {
		if(n == 1) {
			if(r == 0 && c == 0) return 0;
			else if(r == 0 && c == 1) return 1;
			else if(r == 1 && c == 0) return 2;
			else if(r == 1 && c == 1) return 3;
		}
		if(r < Math.pow(2, n-1) && c < Math.pow(2, n-1)) return solve(n-1, r, c);
		else if(r < Math.pow(2, n-1) && c >= Math.pow(2, n-1)) return (int)Math.pow(4, n-1) + solve(n-1, r, c-(int)Math.pow(2, n-1));
		else if(r >= Math.pow(2, n-1) && c < Math.pow(2, n-1)) return 2 * (int)Math.pow(4, n-1) + solve(n-1, r-(int)Math.pow(2, n-1), c);
		else if(r >= Math.pow(2, n-1) && c >= Math.pow(2, n-1)) return 3 * (int)Math.pow(4, n-1) + solve(n-1, r-(int)Math.pow(2, n-1), c-(int)Math.pow(2, n-1));
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); int r = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken()); 
		
		System.out.println(solve(N, r, c));
	}
}