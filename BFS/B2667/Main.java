package PS;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

class Dir{
    int y;
    int x;

    Dir(int y, int x){
        this.y = y; this.x = x;
    }
}

public class Main {
    static int N;
    static int[][] map;
    static int apartCnt = 0;
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static boolean isIn(Dir c){
        if(0<= c.y && c.y < N && 0<= c.x && c.x < N) return true;
        else return false;
    }

    public static ArrayList<Integer> solve(){
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(0); //단지 개수
        int cnt = 0;

        for(int i=0;i<N;i++){
            for(int j = 0; j< N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    answers.add(bfs(i, j));
                    cnt++;
                }
            }
        }
        Collections.sort(answers);
        answers.set(0, cnt);

        return answers;
    }

    public static int bfs(int y, int x){
        int cnt = 1;
        Queue<Dir> q = new LinkedList<>();
        q.offer(new Dir(y, x));
        visited[y][x] = true;

        while(!q.isEmpty()){
            Dir cur = new Dir(q.peek().y, q.peek().x);
            q.poll();

            for(int i = 0;i<4;i++){
                Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
                if(!isIn(next) || visited[next.y][next.x] || map[next.y][next.x] == 0) continue;

                cnt++;
                q.offer(next);
                visited[next.y][next.x] = true;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> answers;
        N = input.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String temp = input.next();
            for(int j=0;j<N;j++){
                map[i][j] = temp.charAt(j)-'0';
                visited[i][j] = false;
            }
        }
        answers = solve();

        for(int i : answers)
            System.out.println(i);
    }
}