package Programmers;

import java.util.*;

class Solution {
	public Integer[] solution(String[] genres, int[] plays) {
		List<Integer> answer = new ArrayList<>();
		
		// 
		Map<String, Integer> sum = new TreeMap<>();
		Map<String, Map<Integer, Integer>>list = new HashMap<>();
		
		for(int i = 0; i < genres.length; i++) {
			// 장르 별 플레이 수
			if(sum.containsKey(genres[i]) == false) sum.put(genres[i], plays[i]);
			else sum.put(genres[i], sum.get(genres[i]) + plays[i]);

			// 노래 별 플레이 수
			if(list.containsKey(genres[i]) == false) {
				Map<Integer, Integer> temp = new HashMap<>();
				temp.put(i, plays[i]);
				list.put(genres[i], temp);
			}
			else list.get(genres[i]).put(i, plays[i]);
		}

		// 장르 별 플레이 수로 정렬
		List<String> sumKeys = new ArrayList<>(sum.keySet());
		Collections.sort(sumKeys, (o1, o2)->(sum.get(o2).compareTo(sum.get(o1))));
		
		for(String k : sumKeys){
			// 노래 별 플레이 수로 정렬
			List<Integer> listKeys = new ArrayList<>(list.get(k).keySet());
			Collections.sort(listKeys, (o1, o2)->(list.get(k).get(o2).compareTo(list.get(k).get(o1))));
			
			for(int i = 0; i < 2 && i < listKeys.size(); i++) {
				answer.add(listKeys.get(i));
			}
		}
		
		return answer.toArray(new Integer[answer.size()]);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		
		String[] g = {"classic", "pop", "classic", "classic", "pop"};
		int[] p = {500, 600, 150, 800, 2500};
		
		System.out.println(s.solution(g, p).toString());
	}
}