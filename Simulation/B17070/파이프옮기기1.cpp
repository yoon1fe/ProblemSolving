#include <iostream>
#include <algorithm>


using namespace std;

int N;
int map[16][16];
int c[16][16] = { 0, };
int ans = 0;
bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < N) return true;
	else return false;
}

void dfs(int x, int y) {
	if (x == N - 1 && y == N - 1) {
		ans++;
		return;
	}

	c[x][y] = 1;

	if (c[x][y - 1] == 1) {	//파이프 가로
		for (int i = 0; i < 2; i++) {	//경우 두가지
			if (i == 0) {	//가로로 연결
				if (isIn(x, y+1) && map[x][y + 1] != 1) {
					dfs(x, y + 1);
					c[x][y + 1] = 0;
				}
			}
			else {
				if (isIn(x, y + 1) && isIn(x + 1, y) && isIn(x + 1, y + 1) && map[x][y + 1] != 1 && map[x + 1][y] != 1 && map[x + 1][y + 1] != 1) {
					dfs(x + 1, y + 1);
					c[x + 1][y + 1] = 0;
				}
			}
		}
	}
	else if (c[x - 1][y] == 1) {	//세로
		for (int i = 0; i < 2; i++) {	//경우 두가지
			if (i == 0) {	//세로로 연결
				if (isIn(x + 1, y) && map[x+1][y] != 1) {
					dfs(x+1, y);
					c[x + 1][y] = 0;
				}
			}
			else {
				if (map[x][y + 1] != 1 && map[x + 1][y] != 1 && map[x + 1][y + 1] != 1) {
					dfs(x + 1, y + 1);
					c[x + 1][y + 1] = 0;
				}
			}
		}
	}
	else if (c[x - 1][y - 1] == 1) {	//대각선
		for (int i = 0; i < 3; i++) {	//경우 세가지
			if (i == 0) {	//가로로 연결
				if (isIn(x, y + 1) && map[x][y + 1] != 1) {
					dfs(x, y + 1);
					c[x][y + 1] = 0;
				}
			}
			else if (i == 1) {
				if (isIn(x + 1, y) && map[x+1][y] != 1) {
					dfs(x+1,y);
					c[x + 1][y] = 0;
				}
			}
			else {
				if (isIn(x, y + 1) && isIn(x + 1, y) && isIn(x + 1, y + 1) && map[x][y + 1] != 1 && map[x + 1][y] != 1 && map[x + 1][y + 1] != 1) {
					dfs(x + 1, y + 1);
					c[x + 1][y + 1] = 0;
				}
			}
		}
	}
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			cin >> map[i][j];
	//초기 파이프 설정
	c[0][0] = 1;
	c[0][1] = 1;

	dfs(0, 1);

	cout << ans;

	return 0;
}