package BOJ;

import java.io.*;
import java.util.*;

public class Main {
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      List<Integer>[] students = new ArrayList[N+1];
      int[] inDegree = new int[N+1];
      
      for(int i = 0; i <= N; i++) students[i] = new ArrayList<>();
      
      for(int i = 0; i < M; i++) {
    	  st = new StringTokenizer(br.readLine(), " ");
    	  int a = Integer.parseInt(st.nextToken());
    	  int b = Integer.parseInt(st.nextToken());
    	  students[a].add(b);
    	  inDegree[b]++;
      }
      
      TopologicalSort(students, inDegree);
   }
   
   public static void TopologicalSort(List<Integer>[] graph, int[] inDegree) {
	   Queue<Integer> q = new LinkedList<>();
	   for(int i = 1; i < inDegree.length; i++) {
	   	  if(inDegree[i] == 0) q.offer(i);
	   }
	   
	   while(!q.isEmpty()) {
		   int cur = q.poll();
		   System.out.print(cur + " ");
		   for(int i = 0; i < graph[cur].size(); i++) {
			   int next = graph[cur].get(i);
			   if(--inDegree[next] == 0) q.offer(next);
		   }
	   }
	   /*
	    * 노드를 모두 방문하기 전에 q가 빈다면 싸이클이 존재하는 것이다.
	    */
   }
}