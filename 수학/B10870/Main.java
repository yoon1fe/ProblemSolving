import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println(fib(input()));
	}
	
	public static int fib(int n) {
		if(n <= 1) return n;
		
		return fib(n-1) + fib(n-2);
	}

	public static int input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Integer.parseInt(br.readLine());
	}
}