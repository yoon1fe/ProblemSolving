package PS;

import java.io.IOException;

public class Main {
	class Solution {
		public int[] solution(int n) {
			if (n == 1) {
				int[] a = { 0 };
				return a;
			}
			int[] b = solution(n - 1);
			int[] a = new int[b.length * 2 + 1];

			System.arraycopy(b, 0, a, 0, b.length);
			a[b.length] = 0;
			int[] c = new int[b.length];

			for (int i = 0; i < c.length; i++) {
				if (b[b.length - 1 - i] == 1)
					c[i] = 0;
				else
					c[i] = 1;
			}

			System.arraycopy(c, 0, a, b.length + 1, c.length);
			return a;
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.print(solution(3));
	}
}