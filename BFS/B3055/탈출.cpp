#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;


int R, C;
char m[50][50];
int c[50][50];
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

bool isIn(int x, int y) {
	if (0 <= x && x < R && 0 <= y && y < C) return true;
	else return false;
}

int bfs(void) {
	queue<pair<int, int>> q;

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (m[i][j] == '*') {
				q.push(make_pair(i, j));
				c[i][j] = 0;
			}
		}
	}


	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (m[i][j] == 'S') {
				q.push(make_pair(i, j));
				c[i][j] = 0;
			}
		}
	}

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (isIn(nx, ny) && m[cx][cy] == '*' && m[nx][ny] == '.' && c[nx][ny] == -1) {
				q.push(make_pair(nx, ny));
				m[nx][ny] = '*';
				c[nx][ny] = -2;
			}

			if (isIn(nx, ny) && m[cx][cy] == 'S' && m[nx][ny] != '*' && m[nx][ny] != 'X' && c[nx][ny] == -1) {
				q.push(make_pair(nx, ny));
				c[nx][ny] = c[cx][cy] + 1;

				if (m[nx][ny] == 'D')
					return c[nx][ny];

				m[nx][ny] = 'S';
			}
		}
	}

	return -1;
}

int main() {
	cin >> R >> C;
	int ans = 0;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> m[i][j];
		}
	}

	fill(&c[0][0], &c[R - 1][C], -1);

	ans = bfs();

	if (ans == -1)
		cout << "KAKTUS";
	else
		cout << ans;
	
	return 0;
}