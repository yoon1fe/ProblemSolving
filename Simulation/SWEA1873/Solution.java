import java.util.Scanner;

class Dir{
	int y;
	int x;
	Dir(int y, int x){
		this.y = y;
		this.x = x;
	}
}

public class Solution {
	static int H;
	static int W;
	static char tank;
	static Dir tankLoc;
	static int dir;
	static char[][] map = null;
	static int[] dy = {-1, 1, 0, 0};		//0: ^/1: v/2: </3: >
	static int[] dx = {0, 0, -1, 1};
	
	static boolean isIn(Dir cur) {
		if(0<= cur.y && cur.y < H && 0<= cur.x && cur.x < W) return true;
		else return false;
	}
	
	static void moveUp() {
		tank = '^';
		map[tankLoc.y][tankLoc.x]= tank; 
		dir = 0;
		Dir next = new Dir(tankLoc.y + dy[dir], tankLoc.x + dx[dir]);
		if(isIn(next) && map[next.y][next.x] == '.') {
			map[tankLoc.y][tankLoc.x] = '.';
			map[next.y][next.x]= tank; 
			tankLoc = next;
		}
	}
	static void moveDown() {
		tank = 'v';
		map[tankLoc.y][tankLoc.x]= tank; 
		dir = 1;
		Dir next = new Dir(tankLoc.y + dy[dir], tankLoc.x + dx[dir]);
		if(isIn(next) && map[next.y][next.x] == '.') {
			map[tankLoc.y][tankLoc.x] = '.';
			map[next.y][next.x]= tank; 
			tankLoc = next;
		}
	}
	static void moveLeft() {
		tank = '<';
		map[tankLoc.y][tankLoc.x]= tank; 
		dir = 2;
		Dir next = new Dir(tankLoc.y + dy[dir], tankLoc.x + dx[dir]);
		if(isIn(next) && map[next.y][next.x] == '.') {
			map[tankLoc.y][tankLoc.x] = '.';
			map[next.y][next.x]= tank; 
			tankLoc = next;
		}
	}
	static void moveRight() {
		tank = '>';
		map[tankLoc.y][tankLoc.x]= tank; 
		dir = 3;
		Dir next = new Dir(tankLoc.y + dy[dir], tankLoc.x + dx[dir]);
		if(isIn(next) && map[next.y][next.x] == '.') {
			map[tankLoc.y][tankLoc.x] = '.';
			map[next.y][next.x]= tank; 
			tankLoc = next;
		}
	}
	static void shoot() {
		Dir shell = new Dir(tankLoc.y + dy[dir], tankLoc.x + dx[dir]);
		
		while(isIn(shell) && (map[shell.y][shell.x] == '.' || map[shell.y][shell.x]== '-' || map[shell.y][shell.x] == '*')) {
			if(map[shell.y][shell.x] == '*' ) {
				map[shell.y][shell.x] = '.';
				break;
			}
			shell.y += dy[dir];
			shell.x += dx[dir];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			H = Integer.parseInt(sc.next());
			W = Integer.parseInt(sc.next());
			map = new char[H][W];
			sc.nextLine();
			
			for(int i = 0; i< H; i++) {
				String temp = sc.nextLine();
				map[i] = temp.toCharArray();
			}
			
			for(int i = 0; i<H; i++) {
				for(int j = 0; j< W; j++) {
					if (map[i][j] == '^') {
						tankLoc = new Dir(i, j);
						tank = '^';
						dir = 0;
					} else if (map[i][j] == 'v') {
						tankLoc = new Dir(i, j);
						tank = 'v';
						dir = 1;
					} else if (map[i][j] == '<') {
						tankLoc = new Dir(i, j);
						tank = '<';
						dir = 2;
					} else if (map[i][j] == '>') {
						tankLoc = new Dir(i, j);
						tank = '>';
						dir = 3;
					}
				}
			}
			
			int N = Integer.parseInt(sc.nextLine());
			String orders = sc.nextLine();
			for(int i = 0; i < N; i++) {
				char order = orders.charAt(i);
				
				switch(order) {
				case 'U':
					moveUp();
					break;
				case 'D':
					moveDown();
					break;
				case 'L':
					moveLeft();
					break;
				case 'R':
					moveRight();
					break;
				case 'S':
					shoot();
					break;
				}
			}
			
			System.out.print("#" + test_case + " ");
			for(int i = 0; i< H; i++) {
				for(int j = 0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}
	}
}
