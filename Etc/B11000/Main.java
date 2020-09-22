package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	static class Lec implements Comparable<Lec> {
		int s, t;
		Lec(int s, int t){
			this.s = s; this.t = t;
		}
		
		public int compareTo(Lec o) {
			return this.t - o.t;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Lec> pq = new PriorityQueue<>();
		List<Lec> lectures = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			lectures.add(new Lec(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(lectures, new Comparator<Lec>() {
			public int compare(Lec o1, Lec o2) {
				if(o1.s == o2.s) return o1.t - o2.t;
				return o1.s - o2.s;
			}
		});
		
		for(Lec l : lectures) {
			if(pq.isEmpty()) pq.offer(l);
			else {
				if(pq.peek().t <= l.s) {
					pq.poll();
					pq.offer(l);
				}else pq.offer(l);
			}
		}
		System.out.println(pq.size());
	}
}
