package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		Map<Integer, Integer> paren = new HashMap<>();
		List<Integer> parenIdx = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				s.push(i);
				parenIdx.add(i);
			}else if(input.charAt(i) == ')') {
				paren.put(s.pop(), i);
			}
		}

		List<String> output = new LinkedList<>();
		
		for (int i = 1; i < (1 << parenIdx.size()); i++) {
			StringBuilder sb = new StringBuilder();
			
			Map<Integer, Integer> idx = new HashMap<>();
			// 부분집합 만들기
			for (int j = 0; j < parenIdx.size(); j++) {
				if ((i & (1 << j)) != 0) {
					idx.put(parenIdx.get(j), paren.get(parenIdx.get(j)));
				}
			}
			
			for (int k = 0; k < input.length(); k++) {
				// 빼야 할 괄호
				if (input.charAt(k) == '(' && idx.containsKey(k)) continue;
				if (input.charAt(k) == ')' && idx.containsValue(k)) continue;
				
				sb.append(input.charAt(k));
			}
			output.add(sb.toString());
		}
		output.sort(Comparator.naturalOrder());
		
		for(int i = 0; i < output.size(); i++)
			System.out.println(output.get(i));
	}
}

