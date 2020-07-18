#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int R, C;
int wolf = 0, sheep = 0;
char m[250][250];
bool c[250][250] = { 0, };
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

bool isIn(int x, int y) {
	if (0 <= x && x < R && 0 <= y && y < C)
		return true;
	else return false;
}

void bfs(int x, int y) {
	queue<pair<int, int>> q;
	int vcnt = 0;
	int kcnt = 0;
	q.push(make_pair(x, y));
	c[x][y] = true;
	if (m[x][y] == 'v')
		vcnt++;
	else if (m[x][y] == 'o')
		kcnt++;

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (!isIn(nx, ny) || c[nx][ny]) continue;
			if (m[nx][ny] != '#') {
				if (m[nx][ny] == 'v') {//´Á´ë
					vcnt++;
				}
				else if (m[nx][ny] == 'o') {	//¾ç
					kcnt++;
				}

				q.push(make_pair(nx, ny));
				c[nx][ny] = true;
			}
		}
	}

	if (kcnt > vcnt)
		vcnt = 0;

	else kcnt = 0;

	wolf += vcnt;
	sheep += kcnt;
}

int main() {
	cin >> R >> C;

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> m[i][j];
		}
	}
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (!c[i][j] && m[i][j] != '#') {
				bfs(i, j);
			}
		}
	}

	cout << sheep << ' ' << wolf;

	return 0;
}