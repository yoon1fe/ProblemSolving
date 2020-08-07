import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	static int[] dx = {1, -1, 2};
	
	static boolean isIn(int c) {
		if(0<= c && c <= 100000) return true;
		else return false;
	}
	
	public static int bfs(int s, int d) {
		Queue<Integer> q = new LinkedList<Integer>();
		int []map = new int[100001];
		q.offer(s);
		map[s] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == d) return map[cur];
			
			for(int i =0 ; i< 3; i++) {
				int next = cur + dx[i];
				if(i == 2) next = cur * 2;
				if(!isIn(next) || map[next] != 0) continue;
				q.offer(next);
				map[next] = map[cur] + 1;
			}
		}		
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(bfs(N, K) - 1);
	}
}