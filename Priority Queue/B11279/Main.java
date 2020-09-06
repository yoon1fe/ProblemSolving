package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int num;
		public Node(int n) {
			this.num = n;
		}

		public int compareTo(Node o) {
			return o.num - this.num;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n != 0) pq.offer(new Node(n));
			else {
				sb.append(pq.peek() != null ? pq.poll().num+"\n" : 0+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}