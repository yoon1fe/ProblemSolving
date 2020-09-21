package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 1003001;

	public static boolean check(int num) {
		StringBuilder str = new StringBuilder();
		str.append(num);
		if(str.toString().equals(str.reverse().toString()))return true;
		else return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isNotPrime = new boolean[MAX + 1];
		int N = Integer.parseInt(br.readLine());
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(MAX); i++) {
			if(isNotPrime[i]) continue;
			for(int j = i*i; j <= MAX; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		for(int i = N; i <= MAX; i++) {
			if(!isNotPrime[i] && check(i)) {
				System.out.println(i);
				break;
			}
		}
	}
}
