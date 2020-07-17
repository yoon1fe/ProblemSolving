package PS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dir{
    int y;
    int x;
    Dir(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class Main{
    static int N;
    static int M;
    static int [][] map;
    static int [][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static boolean isIn(Dir dir){
        if(0<= dir.y && dir.y < N && 0<= dir.x && dir.x < M) return true;
        else return false;
    }
    //BFS
    public static int solve(){
        int ans = 0;
        Queue<Dir> q = new LinkedList<>();

        q.offer(new Dir(0, 0));
        visited[0][0] = 1;

        while(!q.isEmpty()){
            Dir cur = new Dir(q.peek().y, q.peek().x);
            q.poll();

            for(int i=0;i<4;i++){
                Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
                if(!isIn(next)) continue;
                if(visited[next.y][next.x] != 0) continue;
                if(map[next.y][next.x] != 1) continue;

                q.offer(next);
                visited[next.y][next.x] = visited[cur.y][cur.x] + 1;
            }
        }

        ans = visited[N-1][M-1];
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        map = new int[N][M];
        visited = new int[N][M];

        for(int i=0;i<N;i++){
            String temp = input.next();
            for(int j=0;j<M;j++){
                map[i][j] = temp.charAt(j)-'0';
                visited[i][j] = 0;
            }
        }

        System.out.print(solve());
    }
}