package Programmers;

import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int sc : scoville) pq.offer(sc);
		
		while(!pq.isEmpty()) {
			int sc1 = pq.poll();
			if(sc1 >= K) return answer;
			if(pq.isEmpty()) return -1;
			int sc2 = pq.poll();
			
			pq.offer(sc1 + sc2 * 2);
			
			answer++;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.solution(new int[] {1, 2, 3, 9, 10, 12}, 70000));
	}
}