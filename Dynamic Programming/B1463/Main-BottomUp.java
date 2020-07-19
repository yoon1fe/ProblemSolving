package PS;

import java.util.Scanner;

public class Main-BottomUp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] dp = new int[N + 1];
        input.close();

        for(int i=2; i<=N;i++){
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }

        System.out.println(dp[N]);
    }
}