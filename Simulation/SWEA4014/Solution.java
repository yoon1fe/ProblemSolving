package SWEA;

import java.io.*;
import java.util.*;

public class Solution {
    static int ans;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[][] map;
			int N, X;
			N = Integer.parseInt(st.nextToken()); X = Integer.parseInt(st.nextToken());
			
			map = new int[N * 2][N];

			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i< N; i++)
				for(int j = 0; j< N; j++)
					map[i+N][j] = map[j][i];
			
			for(int i = 0; i< 2*N; i++) solve(map[i], X);
			
			bw.write("#" + tc + " " + ans + "\n");
			ans = 0;
		}
		
		bw.flush();
		bw.close();
	}

	static void solve(int[] line, int X) {
        int start = line[0];
        boolean[] checked = new boolean[line.length];
        boolean possible = true;

        outer:
        for(int i = 1; i< line.length; i++){
            int diff = Math.abs(start - line[i]);
            if(diff > 1) {
                possible = false; break;
            }
            if(start > line[i]){
                for(int j = i; j < i+X; j++){
                    if(j >= line.length || checked[j] || line[j] != line[i]){
                        possible = false;  break outer;
                    }
                    checked[j] = true;
                }
            }else if(start == line[i]) continue;
            else{
                for(int j = i-1; j > i-1 - X; j--){
                    if(j < 0 || checked[j] || line[j] != start){
                        possible = false; break outer;
                    }
                    checked[j] = true;
                }
            }
            start = line[i];
        }

        ans = possible == true ? ans + 1 : ans;
    }	
}
