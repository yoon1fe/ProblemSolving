#include <iostream>
#include <algorithm>

using namespace std;

int R, C;
char m[20][20];
int ans = 0;
int dx[4] = { 1, -1, 0 , 0 };
int dy[4] = { 0, 0, 1, -1 };
bool c[26] = { 0, };

int compare(int a, int b) {
	if (a > b) return a;
	else return b;
}

bool isIn(int x, int y) {
	if (0 <= x && x < R && 0 <= y && y < C)
		return true;
	else return false;
}

void dfs(int x, int y, int cnt) {
	ans = compare(ans, cnt);

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (isIn(nx, ny)) {
			if (c[m[nx][ny] - 'A'] == false) {
				c[m[nx][ny] - 'A'] = true;
				dfs(nx, ny, cnt + 1);
				c[m[nx][ny] - 'A'] = false;
			}
		}
	}
}

int main() {
	cin >> R >> C;

	for (int i = 0; i < R; i++)
		for (int j = 0; j < C; j++)
			cin >> m[i][j];
	c[m[0][0] - 'A'] = true;

	dfs(0, 0, 1);

	cout << ans;

	return 0;
}