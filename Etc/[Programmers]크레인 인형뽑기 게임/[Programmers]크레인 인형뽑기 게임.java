import java.util.Stack;

public class Main{
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<Integer>();
        
        for(int i = 0; i < moves.length; i++) {
        	int cur = moves[i] - 1;
        	
        	for(int j = 0; j < board.length; j++) {
        		if (board[j][cur] == 0 ) continue;
        		if(bucket.isEmpty()) {
        			bucket.push(board[j][cur]);
             		board[j][cur] = 0; 
             		break;
        		}
        		if(board[j][cur] == bucket.peek()) {
        			bucket.pop();
        			answer+=2;
        		}else bucket.push(board[j][cur]);
        		board[j][cur] = 0; 
        		break;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] ans = new int[2];
		int[][] board = {
				{0,0,0,0,0}, 
				{0,0,1,0,3}, 
				{0,2,5,0,1}, 
				{4,2,4,4,2}, 
				{3,5,1,3,1}
				};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		System.out.println(solution(board, moves));
	}
}