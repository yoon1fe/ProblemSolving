import java.util.Scanner;

public class Solution {
	static int N;
	static String[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(sc.nextLine());
			map = new String[N];
			
			for(int i = 0; i< N; i++) {
				String t = sc.nextLine();
				map[i] = t;
			}
			
			int ans = 0;
			
			int len = 1;
			int startIdx = N/2;
			for(int i = 0; i<N/2; i++) {
				for(int j = 0; j < N; j++) {
					if(j == startIdx) {
						int cnt = 0;
						while(cnt < len) {
							ans+=map[i].charAt(j) - '0';
							cnt++;
							j++;
						}
						break;
					}
				}
				startIdx--;
				len+=2;
			}
			
			for(int i = 0; i < N;i++) {
				ans += map[N/2].charAt(i) - '0';
			}
			len-=2;
			startIdx++;
			for(int i = (N/2)+1; i< N; i++) {
				for(int j = 0; j < N; j++) {
					if(j == startIdx) {
						int cnt = 0;
						while(cnt < len) {
							ans+=map[i].charAt(j) - '0';
							cnt++;
							j++;
						}
						break;
					}
				}
				startIdx++;
				len-=2;
			}
			
			System.out.println("#" + test_case + " " + (ans));
		}
	}
}
