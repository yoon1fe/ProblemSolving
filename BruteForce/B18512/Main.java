package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int H1 = Integer.parseInt(st.nextToken());
		int H2 = Integer.parseInt(st.nextToken());
		int maxLen = 10000 + Math.max(H1, H2);
		boolean[] v = new boolean[maxLen];

		while (true) {
			v[H1] = true;
			H1 += X;
			if (H1 >= maxLen)
				break;
		}

		boolean flag = false;
		while (true) {
			if (v[H2]) {
				flag = true;
				break;
			}
			v[H2] = true;
			H2 += Y;
			if (H2 >= maxLen)
				break;
		}

		System.out.println(flag == true ? H2 : -1);
	}
}