package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> dwarfs = new ArrayList<>();
		int total = 0;
		for(int i = 0; i < 9; i++) {
			dwarfs.add(Integer.parseInt(br.readLine()));
			total += dwarfs.get(i);
		}
		// 조합으로 두 개 골라서 뺀게 100 되는 경우를 찾자

		outer:
		for(int i = 0; i < 9; i++) {
			int first = dwarfs.get(i);
			for(int j = i + 1; j < 9; j++) {
				int second = dwarfs.get(j);
				if(first + second + 100 == total) {
					dwarfs.remove((Integer)first);
					dwarfs.remove((Integer)second);
					break outer;
				}
			}
		}

		Collections.sort(dwarfs);
		
		for(int i : dwarfs) System.out.println(i);
	}
}