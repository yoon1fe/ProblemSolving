package com.ssafy.day09.ws01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
	int start, end;

	public Meeting(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Meeting o) {
		if(this.end == o.end) return this.start - o.start;
		return this.end - o.end;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		Meeting[] m = new Meeting[N];
		int ans = 1;
		
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			m[i] = new Meeting(s, e);
		}
		Arrays.sort(m);
		
		int endPoint = m[0].end;
		for(int i = 1; i< N; i++) {
			if(endPoint <= m[i].start){
				ans++;
				endPoint = m[i].end;
			}
		}
		System.out.println(ans);
	}
}
