package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, -1};																	
	static final int HMIL = 100000000;																

	static class Dir{
		int cur, next;
		Dir(int cur, int next) {
			this.cur = cur; this.next = next;
		}
	}
	
	public static long bfs(int[] spring, int K) {				
		Queue<Dir> q = new LinkedList<>();		
		Set<Integer> dupCheck = new HashSet<>();
		long sum  = 0;
		
		for(int i = 0; i < spring.length; i++) {											
			q.offer(new Dir(spring[i], spring[i]));	
			dupCheck.add(spring[i]);
		}
		
		while(!q.isEmpty()) {		
			Dir cur = q.poll();																		
			
			for(int i = 0; i <2; i++) {																
				Dir next = new Dir(cur.cur, cur.next + dx[i]);																
				if(next.next > (HMIL + 50000) || (-1 * (HMIL + 50000)) > next.next || dupCheck.contains(next.next)) continue;							

				q.offer(next);
				dupCheck.add(next.next);
				sum += Math.abs(next.cur - next.next);																	
				K--;				
				
				if(K == 0) return sum;																		
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());				
		st = new StringTokenizer(br.readLine(), " ");												
		int[] spring = new int[N];																		
		for(int i = 0; i < N; i++) {
			spring[i] = Integer.parseInt(st.nextToken());							
		}
		
		System.out.println(bfs(spring, K));																		
	}
}