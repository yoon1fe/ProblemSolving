package PS;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> friend = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> enemy = new ArrayList<>();
    static int m;
    static boolean []check;

    public static void dfs(int idx) {
        for (int t : friend.get(idx)) {
            if(check[t] == false) {
                check[t] = true;
                dfs(t);
            }
        }
        for (int t : enemy.get(idx)) {
            for (int e : enemy.get(t)) {
                if(check[e] == false) {
                    check[e] = true;
                    dfs(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        check = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            friend.add(new ArrayList<>());
            enemy.add(new ArrayList<>());
        }

        for(int i = 0; i< m ;i++){
            char fe = sc.next().charAt(0);
            int from = sc.nextInt();
            int to = sc.nextInt();

            if(fe == 'F'){
                friend.get(from).add(to);
                friend.get(to).add(from);
            }
            else{
                enemy.get(from).add(to);
                enemy.get(to).add(from);
            }
        }

        //check friend or enemy
        int answer = 0;
        for(int i = 1; i<= n; i++){
            if(check[i] == false){
                check[i] = true;
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }
}