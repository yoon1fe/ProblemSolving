import java.util.Stack;

public class Main {
	
	public static boolean isRight(String p) {		
		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i < p.length(); i++) {
			if(!s.isEmpty() && s.peek() == '(' && p.charAt(i) == ')') s.pop();
			else s.push(p.charAt(i));
		}
		if(s.isEmpty()) return true;
		else return false;
	}
	
	
	public static String solution(String p) {		// p는 항상 균형잡힌 괄호 문자열
        String answer = "";
        if(isRight(p) || p.length() == 0) return p;
        
        String u = "";
        String v = "";
        int l = 0; int r = 0;
        for(int i = 0; i< p.length(); i++) {
        	if(p.charAt(i) == '(') l++;
        	else if(p.charAt(i) == ')') r++;
        	if(l == r) {
        		u = p.substring(0, i + 1); 
        		v = p.substring(i+1);
        		break;
        	}
        }
  
        if(isRight(u)) {
        	return u + solution(v);
        }
        
        else {
        	String temp = "(" + solution(v) + ")";
        	for(int i = 1; i < u.length() - 1; i++) 
        		temp += u.charAt(i) == '(' ? ")" : "(";
        	answer = temp;
        }
        return answer;
    }

	public static void main(String[] args) throws Exception {
		String p = "()))((()";
		
		System.out.println(solution(p));
	}
}