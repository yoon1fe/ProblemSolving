package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken()); 
		int C = Integer.parseInt(st.nextToken());
		String[] input = new String[R + C];
		
		for(int i = 0; i < R; i++) {
			input[i] = br.readLine();
		}
		
		for(int i = 0; i < C; i++) {
			char[] colString = new char[R];
			for(int j = 0; j < R; j++) {
				colString[j] = input[j].charAt(i);
			}
			input[i + R] = String.valueOf(colString);
		}
		Set<String> set = new TreeSet<>();
		
		for(String s : input) {
			st = new StringTokenizer(s, "#");
			String str = st.nextToken();
			if(str.length() >= 2) 
				set.add(str);
		}
		
		System.out.println(set.iterator().next());
	}
}