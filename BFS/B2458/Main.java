import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Integer>[] forward;
	static List<Integer>[] back;
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
	public static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			int answer = 0;
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			forward = new List[N + 1];
			back = new List[N + 1];
			
			for(int i = 1; i <= N; i++) {
				forward[i] = new ArrayList<>();
				back[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				forward[a].add(b);
				back[b].add(a);
			}
			
			
			for(int i = 1; i <= N; i++) {
				if(check(i)) answer++;
			}
			
			System.out.println("#" + tc + " " + answer);
		}		
	}
	
	public static boolean check(int a) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[N + 1];
		
		q.offer(a);
		v[a] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 0; i < forward[cur].size(); i++) {
				int next = forward[cur].get(i);
				if(v[next]) continue;
				
				q.offer(next);
				v[next] = true;
			}
		}
		
		q.offer(a);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 0; i < back[cur].size(); i++) {
				int next = back[cur].get(i);
				if(v[next]) continue;
				
				q.offer(next);
				v[next] = true;
			}
		}
		
		boolean ret = true;
		for(int i = 1; i < v.length; i++) ret = ret & v[i];
		
		return ret;
	}

}
