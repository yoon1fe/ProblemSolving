import java.io.*;
import java.util.*;

public class Main {
	static int N;
	
	public static void main(String[] args) throws Exception {
		input();
		
		System.out.println(solve());
	}
	
	public static int solve() {
		int answer = 1, start = 2, six = 6;
		
		if(N == 1) return 1;
		if(N < 8) return 2;
		
		while(true) {
			if(start > N) break;
			answer++;
			start += six;
			six += 6;
		}
		
		return answer;
	}
	
	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	}	
}