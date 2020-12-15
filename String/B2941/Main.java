import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br.readLine().replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "1").length());
	}	
}