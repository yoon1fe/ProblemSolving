package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] selectedUniv = new int[2];
	static Integer[] selectedPlanet = new Integer[2]; 
	static List<Integer[]> PlanetList; 
	static int M, N; 
	static int answer;
	static int[][] universe; 
	
	public static boolean check(int i, int j) {
		int a = universe[selectedUniv[0]][i] - universe[selectedUniv[0]][j];
		int b = universe[selectedUniv[1]][i] - universe[selectedUniv[1]][j];

		if ((a == b) || (a > 0 && b > 0) || (a < 0 && b < 0)) return true; 
		else return false; 
	}
	public static void planetComb(int cnt, int idx) {
		if (cnt == 2) { 
			PlanetList.add(selectedPlanet.clone());
			return;
		}
		
		for (int i = idx; i < N; i++) { 
			selectedPlanet[cnt] = i; 
			planetComb(cnt + 1, i + 1); 
		}
	}
		

	public static void univComb(int cnt, int idx) {
		if (cnt == 2) {
			PlanetList = new ArrayList<>();
			planetComb(0, 0);

			boolean flag = true;
			for (int i = 0; i < PlanetList.size(); i++) {
				if (!check(PlanetList.get(i)[0], PlanetList.get(i)[1])) {
					flag = false;
					break;
				} 
			} 
			answer = flag == true ? answer + 1 : answer;
			return;
		}
			
		for (int i = idx; i < M; i++) {
			selectedUniv[cnt] = i;
			univComb(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		universe = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				universe[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		univComb(0, 0);
		System.out.println(answer);
	}
}