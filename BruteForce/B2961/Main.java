import java.io.*;
import java.util.StringTokenizer;

class Stuff{
	int s;		// 곱
	int b;		// 합 
	Stuff(int s, int b){
		this.s = s; this.b = b;
	}
}

public class Main {
	static Stuff[] stuff;
	static boolean[] isSelected;
	static int N;
	static long ans = 1000000000;
	
	static void solve() {
		int S = 1;
		int B = 0;
		boolean isZero = true;
		for(int i =0; i<N; i++) {
			if(!isSelected[i]) continue;
			isZero = false;
			S *= stuff[i].s;
			B += stuff[i].b;
		}
		if(isZero) return;
		
		int diff = Math.abs(S - B);
		ans = ans > diff ? diff : ans;
	}
	
	static void makeSubset(int cnt) {
		if(N == cnt) {
			solve();
			return;
		}
		
		isSelected[cnt] = true;
		makeSubset(cnt+1);
		isSelected[cnt] = false;
		makeSubset(cnt+1);
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		stuff = new Stuff[N];
		isSelected = new boolean[N];
		for(int i = 0; i< N; i++){
			st = new StringTokenizer(in.readLine(), " ");
			stuff[i] = new Stuff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		makeSubset(0);
		System.out.println(ans);
	}
}
