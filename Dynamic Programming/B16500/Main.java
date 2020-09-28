package BOJ;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> A = new HashSet<>();
        int[] dp = new int[101];

        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            A.add(br.readLine());
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if(dp[j] == 1) {
                    if(A.contains(s.substring(i, j))) dp[i] = 1;
                }
            }
            if(A.contains(s.substring(i))) dp[i] = 1;
        }
        System.out.println(dp[0]);
    }
}