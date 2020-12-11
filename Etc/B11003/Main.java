import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		input();
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Deque<Integer> deque = new ArrayDeque<>();		// 인덱스(list[idx] 오름차순)
		
		int N = Integer.parseInt(st.nextToken()); int L = Integer.parseInt(st.nextToken());
		int[] list = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());

			// i-L ~ i 범위 밖에 있는 인덱스 제거
			if(!deque.isEmpty() && deque.getFirst() <= i - L) {
				deque.removeFirst();
			}
			
			// 새로 입력받은 애보다 큰 애들은 deque에서 빼자
			while(!deque.isEmpty() && list[deque.getLast()] > list[i]) {
				deque.removeLast();
			}
			
			deque.offer(i);
			// list[deque.getFirst] 는 i-L ~ i 범위 안에 있고 그 중 가장 작은 수
//			sb.append(list[deque.getFirst()] + " ");	// 시간 초과 ;;
			sb.append(list[deque.getFirst()]).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}