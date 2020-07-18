#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>
using namespace std;


int T, w, h;
char m[1000][1000];
int c[1000][1000] = { 0, };
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

bool isIn(int x, int y) {
	if (0 <= x && x < h && 0 <= y && y < w) return true;
	else return false;
}

int bfs() {
	queue<pair<int, int>> q;
	vector<int> v;

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			if (m[i][j] == '@') {
				q.push({ i, j });
				c[i][j] = 2;
			}
		}
	}
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			if (m[i][j] == '*') {
				q.push({ i, j });
				c[i][j] = 1;
			}
		}
	}

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		if (m[cx][cy] == '@' && (cx == 0 || cx == h - 1 || cy == 0 || cy == w - 1))
			return c[cx][cy] - 1;

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (!isIn(nx, ny)) continue;

			if (m[cx][cy] == '*' && m[nx][ny] != '#' && m[nx][ny] != '*' && c[nx][ny] != 1) {	//불 퍼지는거
				q.push({ nx, ny });
				m[nx][ny] = '*';
				c[nx][ny] = 1;
			}

			else if (m[cx][cy] == '@' && !c[nx][ny] && m[nx][ny] == '.') {	//상근이 도망가
				q.push({ nx, ny });
				m[nx][ny] = '@';
				c[nx][ny] = c[cx][cy] + 1;
			}

		}
	}

	return -1;
}
int main() {
	cin >> T;
	int ans = 0;
	for (int n = 0; n < T; n++) {
		cin >> w >> h;
		int x, y;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				cin >> m[i][j];
			}
		}
		ans = bfs();
		(ans > 0) ? cout << ans << endl : cout << "IMPOSSIBLE" << endl;
		//cout << bfs() << endl;

		memset(c, 0, sizeof(c));
		memset(m, NULL, sizeof(m));
	}
	return 0;
}