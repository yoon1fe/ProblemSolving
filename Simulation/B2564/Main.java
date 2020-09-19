package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	static class Info{
		int side, length;
		Info(int side, int length){
			this.side = side; this.length = length;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<Info> shop = new ArrayList<>();
		int answer = 0;
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			shop.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		Info Dong = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		for(Info s : shop) {
			switch(Dong.side) {
			case 1:
				switch(s.side) {
				case 1: answer += Math.abs(Dong.length - s.length); break;
				case 2: answer += Math.min(Dong.length + s.length, (2 * r) - (Dong.length + s.length)) + c; break;
				case 3: answer += Dong.length + s.length; break;
				case 4: answer += r - Dong.length + s.length; break;
				}
				break;
			case 2:
				switch(s.side) {
				case 1: answer += Math.min(Dong.length + s.length, (2 * r) - (Dong.length + s.length)) + c; break;
				case 2: answer += Math.abs(Dong.length - s.length); break;
				case 3: answer += Dong.length + c - s.length; break;
				case 4: answer += r - Dong.length + c - s.length; break;
				}
				break;
			case 3:
				switch(s.side) {
				case 1: answer += Dong.length + s.length; break;
				case 2: answer += c - Dong.length + s.length; break;
				case 3: answer += Math.abs(Dong.length - s.length); break;
				case 4: answer += Math.min(Dong.length + s.length, (2 * c) - (Dong.length + s.length)) + r; break;
				}
				
				break;
			case 4:
				switch(s.side) {
				case 1: answer += Dong.length + c - s.length; break;
				case 2: answer += c - Dong.length + r - s.length; break;
				case 3: answer += Math.min(Dong.length + s.length, (2 * c) - (Dong.length + s.length)) + r; break;
				case 4: answer += Math.abs(Dong.length - s.length); break;
				}
				break;
			}
		}
		System.out.println(answer);
	}		
}
