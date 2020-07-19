package PS;

import java.util.Scanner;

public class Main-TopDown {
    static int[] dp;
    public static int make(int n){
        if(n == 1) return 0;
        if (dp[n] != 0) return dp[n];

        int ans = make(n-1) + 1;
        if(n % 2 == 0) ans = Math.min(ans, make(n/2) + 1);
        if(n % 3 == 0) ans = Math.min(ans, make(n/3) + 1);
        dp[n] = ans;

        return ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        dp = new int[N + 1];
        input.close();

        System.out.println(make(N));
    }
}