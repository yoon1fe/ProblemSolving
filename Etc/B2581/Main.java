import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		boolean[] isNotPrime = new boolean[N + 1];
		List<Integer> list = new ArrayList<>();
		
		isNotPrime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(isNotPrime[i]) continue;
			for(int j = i + i; j <= N; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(!isNotPrime[i]) list.add(i);
		}
		
		if(list.size() == 0) {
			System.out.println(-1);
		}else {
			for(int p : list) sum += p;
			
			System.out.println(sum);
			System.out.println(list.get(0));
		}
	}	
}