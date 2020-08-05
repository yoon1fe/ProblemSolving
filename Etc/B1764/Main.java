import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> ans = new ArrayList<>();
		HashSet<String> s = new HashSet<>();
		int N = Integer.parseInt(sc.next()); int M = Integer.parseInt(sc.next()); sc.nextLine();
		for(int i =0; i < N; i++) s.add(sc.nextLine());
		for(int i =0; i < M; i++) {
			String temp = sc.nextLine();
			if(!s.add(temp)) ans.add(temp);
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(String str : ans) System.out.println(str);
	}
}