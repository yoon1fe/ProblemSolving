#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int N;
char m[100][100];
bool c_weak[100][100];
bool c_normal[100][100];
int dx[4] = { 1, -1, 0 ,0 };
int dy[4] = { 0, 0, 1, -1 };

bool isIn(int x, int y) {
	if (0 <= x && x < 100 && 0 <= y && y < 100)
		return true;
	else return false;
}

void bfs_normal(int x, int y) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	c_normal[x][y] = true;

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;

		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (isIn(nx, ny) && !c_normal[nx][ny] && m[nx][ny] == m[cx][cy]) {
				q.push(make_pair(nx, ny));
				c_normal[nx][ny] = true;
			}
		}
	}
}

int main() {
	cin >> N;
	int ncnt = 0;
	int wcnt = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> m[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!c_normal[i][j]) {
				bfs_normal(i, j);
				ncnt++;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			c_normal[i][j] = false;
			if (m[i][j] == 'G') {
				m[i][j] = 'R';
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!c_normal[i][j]) {
				bfs_normal(i, j);
				wcnt++;
			}
		}
	}
	cout << ncnt << ' ' << wcnt << endl;

	return 0;
}