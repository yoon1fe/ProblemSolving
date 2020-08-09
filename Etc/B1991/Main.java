import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	char c;
	Node left;
	Node right;
	Node(char c){
		this.c = c;
	}
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] tree = new Node[26];
        
        for(int i = 0; i < 26; i++) tree[i] = new Node((char)(65+i));
        
        for(int i = 0; i< N; i++){
        	st = new StringTokenizer(br.readLine(), " ");
        	char cur = st.nextToken().charAt(0);
        	char l = st.nextToken().charAt(0);
        	char r = st.nextToken().charAt(0);
        	if(l != '.') tree[cur - 65].left = tree[l - 65];
        	if(r != '.') tree[cur - 65].right = tree[r - 65];
        }
        
        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
        System.out.println();
    }
    
    static void preOrder(Node cur) {
    	if(cur!= null) {
    		System.out.print(cur.c);
    		preOrder(cur.left);
    		preOrder(cur.right);
    	}
    }
    
    static void inOrder(Node cur) {
    	if(cur!= null) {
    		inOrder(cur.left);
    		System.out.print(cur.c);
    		inOrder(cur.right);
    	}
    }
    
    static void postOrder(Node cur) {
    	if(cur!= null) {
    		postOrder(cur.left);
    		postOrder(cur.right);
    		System.out.print(cur.c);
    	}
    }
}