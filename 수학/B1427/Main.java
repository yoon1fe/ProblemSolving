import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		input();
	}
	
	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		List<Integer> list = new ArrayList<>();
		
		for(char ch : str) {
			list.add(ch -'0');
		}
		
		Collections.sort(list, (n1, n2)->{return n2 - n1;});
		
		for(int i : list) System.out.print(i);
	}
}