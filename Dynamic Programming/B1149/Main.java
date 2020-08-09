import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] color = new int[N][3];
        for(int i =0 ; i < N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j< 3; j++) {
        		color[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int[][] dp = new int[N][3];
        dp[0][0] = color[0][0];
        dp[0][1] = color[0][1];
        dp[0][2] = color[0][2];
        
        for(int i = 1; i< N; i++) {
        	dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + color[i][0];
        	dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + color[i][1];
        	dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + color[i][2];
        }
        
        System.out.println(Arrays.stream(dp[N-1]).min().getAsInt());
    }
}