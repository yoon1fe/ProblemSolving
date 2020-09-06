package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n != 0) pq.offer(n);
			else {
				sb.append(pq.peek() != null ? pq.poll()+"\n" : 0+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}