import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	
	static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}
	
	static void union(int a, int b){
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) p[bRoot] = aRoot;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        p = new int[n+1];
        
        for(int i = 1; i<= n; i++) p[i] = i;		//make-set
        
        for(int i = 0 ; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int menu = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	switch(menu) {
        	case 0:
        		union(a, b);
        		break;
        	case 1:
        		sb.append(find(a) == find(b) ? "YES\n" : "NO\n");
        		break;
        	}
        }
        
       // for(int i : p) System.out.print(i + " ");
        
        System.out.println(sb.toString());
        
    }
}