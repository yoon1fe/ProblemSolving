import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 10001;
	static boolean[] isPrime = new boolean[MAX];
	
	public static void main(String[] args) throws Exception {
		init();
		input();
	}
	
	// 에라토스테네스의 체
	public static void init() {
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		
		for(int i = 2; i <= Math.sqrt(MAX); i++) {
			if(isPrime[i] == false) continue;
			
			for(int j = i + i; j < MAX; j += i) {
				isPrime[j] = false;
			}
		}
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			solve(n);
		}
	}
	
	public static void solve(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 2; i <= n/2; i++) {
			int left = i;
			int right = n - i;
			if(isPrime[left] == true && isPrime[right] == true) {
				if(map.size() == 0) {
					map.put(left, right);
				} else {
					int oriSum = 0;
					for(int k : map.keySet()) {
						oriSum = map.get(k) - k;
					}
					if(oriSum > (right - left)) {
						map.clear();
						map.put(left, right);
					}
				}
			}
		}
		
		for(int k : map.keySet()) {
			System.out.println(k + " " + map.get(k));
		}
	}
}