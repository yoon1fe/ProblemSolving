package Programmers;

import java.util.*;

class Solution {
	StringBuilder sb = new StringBuilder();
	Set<Integer> set = new HashSet<>();
	boolean[] isSelected;
	int answer = 0;

	public int solution(String numbers) {
		isSelected = new boolean[numbers.length()];

		// 조합으로 만들 수 있는 숫자 만들기
		for (int depth = 1; depth <= numbers.length(); depth++) {
			dfs(numbers, depth);
		}

		for (int num : set) {
			if (isPrime(num) == true) answer++;
		}

		return answer;
	}

	public void dfs(String numbers, int depth) {
		if (sb.length() == depth) {
			// 다 만들면 중복 제거를 위해 Set에 추가
			set.add(Integer.valueOf(sb.toString()));
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (isSelected[i] == true) continue;
			isSelected[i] = true;
			sb.append(numbers.charAt(i));

			dfs(numbers, depth);

			sb.delete(sb.length() - 1, sb.length());
			isSelected[i] = false;
		}
	}

	public boolean isPrime(int num) {
		if (num < 2) return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.solution(new String("17")));
//		System.out.println(s.solution(new String("011")));
	}
}