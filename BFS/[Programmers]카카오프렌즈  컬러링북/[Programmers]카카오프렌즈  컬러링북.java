import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main{
	static class Dir{
		int y, x;
		Dir(int y, int x){
			this.y = y; this.x = x;
		}
	}

	public static boolean isIn(Dir c, int m, int n) {
		if(0<= c.y && c.y < m && 0<= c.x & c.x < n ) return true;
		else return false;
	}
	
	public static int bfs(Dir s, int[][] picture, boolean[][] v, int m, int n) {
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		int size = 1;
        Queue<Dir> q = new LinkedList<Dir>();
        q.offer(s);
		v[s.y][s.x] = true;
        while(!q.isEmpty()) {
        	Dir cur = q.poll();
        	
        	for(int i = 0; i< 4; i++) {
        		Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
        		if(!isIn(next, m, n)) continue;
        		if(v[next.y][next.x]) continue;
        		if(picture[cur.y][cur.x] != picture[next.y][next.x]) continue;
        		
        		v[next.y][next.x] = true;
        		q.offer(next);
        		size++;
        	}
        }
		return size;
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
        List<Integer> sizeList = new LinkedList<Integer>();
        int[] answer = new int[2];
        boolean [][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(picture[i][j] == 0 || visited[i][j]) continue;
        		sizeList.add(bfs(new Dir(i, j), picture, visited, m, n));
        	}
        }
        
        answer[0] = sizeList.size();
        answer[1] = Collections.max(sizeList);
        return answer;
    }
	
	public static void main(String[] args) {
		int[] ans = new int[2];
		int[][] n = {
				{1, 1, 1, 0}, 
				{1, 2, 2, 0}, 
				{1, 0, 0, 1}, 
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}};
		
		System.out.println(Arrays.toString(solution(6, 4, n)));
	}
}