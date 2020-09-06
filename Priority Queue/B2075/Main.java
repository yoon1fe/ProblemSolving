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
		StringTokenizer st;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				pq.offer(new Node(Integer.parseInt(st.nextToken())));
			}
		}

		for(int i = 0; i < N - 1; i++) pq.poll();
		System.out.println(pq.peek().num);
		
	}
}