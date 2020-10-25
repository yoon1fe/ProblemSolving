import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static void solution(int width, int[] blocks) {
		int rain = 0;

		int[] area = new int[width];

		for (int i = 0; i < width; i++) {
			area[i] += blocks[i];
		}

		int startIdx = 0;

		for (int j = 0; j < width; j++) {
			if (area[j] == 0)
				continue;

			startIdx = j + 1;
			break;
		}

		outer: while (true) {

			for (int j = startIdx; j < width; j++) {
				if (area[j] >= area[startIdx - 1]) {

					for (int k = startIdx; k < j; k++) {
						rain += (area[startIdx - 1] - area[k]);
						area[k] = area[startIdx - 1];
					}
					startIdx = j + 1;
					continue outer;
				}
			}
			break;
		}

		startIdx = width - 1;

		for (int j = width - 1; j >= 0; j--) {
			if (area[j] == 0)
				continue;

			startIdx = j - 1;
			break;
		}

		outer: while (true) {
			for (int j = startIdx; j >= 0; j--) {
				if (area[j] >= area[startIdx + 1]) {

					for (int k = startIdx; k > j; k--) {
						rain += (area[startIdx + 1] - area[k]);
						area[k] = area[startIdx + 1];
					}

					startIdx = j - 1;
					continue outer;
				}
			}

			break;
		}

		System.out.println(rain);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] b = new int[W];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < W; i++) b[i] = Integer.parseInt(st.nextToken());

		solution(W, b);

	}

}