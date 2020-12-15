import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		long[] fb = new long[91];
		int N = input();
		
		fb[0] = 0; fb[1] = 1;
		for(int i = 2; i <= N; i++) {
			fb[i] = fb[i-1] + fb[i-2];
		}
		System.out.println(fb[N]);
	}

	public static int input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Integer.parseInt(br.readLine());
	}
}