import java.io.*;
import java.util.*;

public class Main {
	static int A, B, C;
	
	public static void main(String[] args) throws Exception {
		input();
		int answer = 0;
		if(C != B) {
			answer = (A / (C-B)) + 1;
			if(answer < 0) answer = -1;
		}
		else answer = -1;
		System.out.println(answer);
	}
	
	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	}	
}