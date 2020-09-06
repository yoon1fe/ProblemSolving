package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); 
		int S = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;
		int[] list = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> rangeList = new HashMap<>();
		
		
		int left = 0, right = 0, sum = list[0];
		while(true) {
			if(right >= N) break;
			if(sum < S) {
				if(right+1 >= N) break;
				sum += list[++right];
			}else {
				rangeList.put(left, right);
				sum -= list[left++];
			}
		}
		for(Integer s : rangeList.keySet()) {
			answer = Math.min(answer, rangeList.get(s) - s);
//			System.out.println(s + " " + rangeList.get(s));
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer + 1);
	}
}