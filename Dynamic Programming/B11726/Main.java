package PS;

import java.util.Scanner;

public class Main{
    static int[] dp;

    private static int topDown(int n){
        if(n == 0 || n == 1) return 1;
        if(dp[n] != 0) return dp[n];

        dp[n] = topDown(n-1) + topDown(n-2);
        dp[n] %= 10007;

        return dp[n];
    }

    private static int bottomUp(int n){
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<=n;i++){
            dp[i] = dp[i-2] + dp[i-1];
            dp[i] %= 10007;
        }

        return dp[n];
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];

        //System.out.println(topDown(n));
        System.out.println(bottomUp(n));
    }
}