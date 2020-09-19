package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> nums = new ArrayList<>();
		List<Integer> students = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) nums.add(Integer.parseInt(st.nextToken()));
		
		int idx = 1;
		for(int n : nums) {
			students.add(students.size() - n, idx++);
		}
		
		for(int n : students) System.out.print(n + " ");
	}
}