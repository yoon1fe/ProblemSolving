package Programmers;

import java.util.*;

class Solution {
	public int solution(int n) {
        int inputCnt = getCnt(Integer.toBinaryString(n));
        
        for(int i = n + 1; i <= 1000000; i++) {
        	if(inputCnt == getCnt(Integer.toBinaryString(i))) return i;
        }
        return -1;
    }
	
	public int getCnt(String str) {
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1') cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.solution(78));
	}
}