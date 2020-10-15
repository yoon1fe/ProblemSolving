package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	static int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static List<Integer> nums = new ArrayList<>();
	static List<String> depthList;
	
	public static void comb(int depth, int idx, int cnt) {
		if(cnt == depth) {
			Collections.sort(nums, Collections.reverseOrder());
			StringBuilder sb = new StringBuilder();
			for(int n : nums) sb.append(n);
			
			depthList.add(sb.toString());
			return;
		}
		
		for(int i = idx; i < numbers.length; i++) {
			nums.add(numbers[i]);
			comb(depth, i + 1, cnt + 1);
			nums.remove((Integer)numbers[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, String> map = new TreeMap<>();
		int mapIdx = 0;
		
		for(int i = 1; i <= 10; i++) {
			depthList = new ArrayList<>();
			comb(i, 0, 0);
			Collections.sort(depthList);
			
			for(String l : depthList) map.put(mapIdx++, l);
		}
		
		System.out.println(map.get(N) != null ? map.get(N) : -1);
	}
}