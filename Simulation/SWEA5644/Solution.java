package SWEA;

import java.io.*;
import java.util.*;

public class Solution {
	static class Dir {
		int y, x;
		Dir(int y, int x){
			this.y = y; this.x = x;
		}
	}
	
	static class BC{
		int y, x, c, p;

		public BC(int x, int y, int c, int p) {
			this.y = y;	this.x = x;	this.c = c;	this.p = p;
		}
	}
	
    static int[] dy = {0, -1, 0, 1, 0};
    static int[] dx = {0, 0, 1, 0, -1};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++ ) {
			int M, BCCount;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); BCCount = Integer.parseInt(st.nextToken());
			int[] A = new int[M]; int[] B = new int[M];
			BC[] bcs = new BC[BCCount];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int b = 0; b < BCCount; b++) {
				st = new StringTokenizer(br.readLine(), " ");
				bcs[b] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
	
			
			
			bw.write("#" + tc + " " + solve(A, B, bcs) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int solve(int[] A, int[] B, BC[] bcs) {
		int result = 0;
		Dir Adir = new Dir(1, 1);
		Dir Bdir = new Dir(10, 10);
		// 이동
		for(int i = 0; i < A.length; i++) {
			result += charge(Adir, Bdir, bcs);
			Adir = new Dir(Adir.y + dy[A[i]], Adir.x + dx[A[i]]);
			Bdir = new Dir(Bdir.y + dy[B[i]], Bdir.x + dx[B[i]]);
		}
		
		result += charge(Adir, Bdir, bcs);
		return result;
	}
	
	public static int charge(Dir A, Dir B, BC[] bcs) {
		int aP[] = new int[bcs.length];
		int bP[] = new int[bcs.length];
		int sum = 0;
		
		for (int i = 0; i < aP.length; i++) {
			BC bc = bcs[i];
			if (inRange(A, bc)) aP[i] = bc.p;
			if (inRange(B, bc)) bP[i] = bc.p;
		}
		for (int y = 0; y < aP.length; y++) {
			for (int x = 0; x < aP.length; x++) {
				if (x == y) sum = Math.max(sum, Math.max(aP[x], bP[x]));
				else sum = Math.max(sum, aP[x] + bP[y]);
			}
		}
		return sum;

	}

	private static boolean inRange(Dir c, BC bc) {
		if (Math.abs(c.y - bc.y) + Math.abs(c.x - bc.x) <= bc.c) return true;
		return false;
	}
	
}
