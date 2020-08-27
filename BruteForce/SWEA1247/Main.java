package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int[] dy = {-1, 0, 1};
	static int[] dx = {1, 1, 1};
	static int N;
	static boolean[] isSelected;
	static int[] order;
	static char[][] map;
	static int answer = Integer.MAX_VALUE;
	static List<Dir> customers;
	static Dir company;
	static Dir home;
	
	static class Dir{
		int y, x;
		Dir(int y ,int x){
			this.y = y; this.x = x;
		}
	}
	
	
	public static void comb(int cnt) {
		if(cnt == N) {
			answer = Math.min(answer, getDistances());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			order[cnt] = i;
			comb(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	public static int getDistances() {
		Dir from = company;
		int sum = 0;
		for(int i = 0; i < customers.size(); i++) {
			Dir to = customers.get(order[i]);
			sum += Math.abs(from.y - to.y) + Math.abs(from.x - to.x);
			from = to;
		}
		sum += Math.abs(from.y - home.y) + Math.abs(from.x - home.x);
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			isSelected = new boolean[N];
			order = new int[N];
			customers = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			company = new Dir(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Dir(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < N; i++) {
				customers.add(new Dir(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			comb(0);
			
			output.append("#" + t + " " + answer + "\n");
			
			answer = Integer.MAX_VALUE;
		}
		System.out.println(output.toString());
	}
}
