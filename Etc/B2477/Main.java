package BOJ;

import java.io.*;
import java.util.*;

public class Main {
	static class Info{
		int dir, length;
		Info(int dir, int length){
			this.dir = dir; this.length = length;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Info> list = new ArrayList<>();
		int K = Integer.parseInt(br.readLine());
		
		int N = 0, M = 0;		// 세로, 가로
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			if(list.get(i).dir == 1 || list.get(i).dir == 2) N = Math.max(list.get(i).length, N);
			if(list.get(i).dir == 3 || list.get(i).dir == 4) M = Math.max(list.get(i).length, M);
		}
		list.add(list.get(0));
		
		int answer = M * N;
		
		for(int i = 0; i < list.size() - 1; i++) {
			Info f = list.get(i);
			Info s = list.get(i+1);
			if((f.dir == 1 && s.dir == 3) || (f.dir == 2 && s.dir == 4) || (f.dir == 3 && s.dir == 2) || (f.dir == 4 && s.dir == 1)) {
				answer -= f.length * s.length;
				break;
			}
		}
		
		System.out.println(answer * K);
	}
}
