package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	
	static class Fireball{
		int y, x, mass, s, d;

		public Fireball(int y, int x, int mass, int s, int d) {
			this.y = y; this.x = x; this.mass = mass; this.s = s; this.d = d;
		}
	}
	
	static int N, M, K;
	static List<Fireball>[][] map;
	static List<Fireball> list = new ArrayList<>();
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		input();
		
		System.out.println(solve());
	}
	
	public static int solve() {
		int answer = 0;
		
		for(int time = 0; time < K; time++) {

			// 파이어볼 이동
			for(Fireball cur : list) {
				int ny = (cur.y + N + dy[cur.d] * (cur.s % N)) % N;
				int nx = (cur.x + N + dx[cur.d] * (cur.s % N)) % N;
				
				cur.y = ny; cur.x = nx;
				
				map[ny][nx].add(cur);
			}
			
			// 파이어볼 두개 이상 든 곳에서 
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j].size() == 1) map[i][j].clear();
					if(map[i][j].size() < 2) continue;
					
					int massSum = 0, sSum = 0;
					
					boolean even = map[i][j].get(0).d % 2 == 0 ? true : false;
					boolean odd = map[i][j].get(0).d % 2 == 1 ? true : false;
					
					for(Fireball cur : map[i][j]) {
						massSum += cur.mass;
						sSum += cur.s;
						even = even & cur.d % 2 == 0 ? true : false;
						odd = odd & cur.d % 2  == 1 ? true : false;
						list.remove(cur);
					}
					
					int newMass = massSum / 5;
					int size = map[i][j].size();
					map[i][j].clear();
					
					if(newMass == 0) continue;
					int newS = sSum / size;
					
					
					if(even | odd) { 	// 0 2 4 6
						for(int k = 0; k < 8; k += 2) {
							list.add(new Fireball(i, j, newMass, newS, k));
						}
					} else {
						for(int k = 1; k < 8; k += 2) {
							list.add(new Fireball(i, j, newMass, newS, k));
						}
					}
				}
			}
		}
		
		for(Fireball cur : list) answer += cur.mass;
		
		return answer;
	}	

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
		map = new List[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) map[i][j] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new Fireball(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
	}
}