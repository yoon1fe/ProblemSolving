import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int minBurger = Integer.MAX_VALUE, minDrink = Integer.MAX_VALUE;
		
		int t = 3;
		while(t-- > 0) {
			minBurger = Math.min(minBurger, Integer.parseInt(br.readLine()));
		}

		t= 2;
		while(t-- > 0) {
			minDrink = Math.min(minDrink, Integer.parseInt(br.readLine()));
		}
		
		System.out.println(minBurger + minDrink - 50);
	}
}