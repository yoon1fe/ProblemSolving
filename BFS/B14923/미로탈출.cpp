#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N, M;

int m[1001][1001] = { 0, };
int c[1001][1001][2] = { 0, };
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
pair<int, int> s, e;

bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < M) return true;
	else return false;
}

int bfs(int x, int y) {
	queue<pair<pair<int, int>, int>> q;
	q.push({ {x, y}, 0 });
	c[x][y][0] = 1;	//¹Ù²Û È½¼ö 0


	while (!q.empty()) {
		int cx = q.front().first.first;
		int cy = q.front().first.second;
		int ccnt = q.front().second;
		q.pop();

		if (cx == e.first && cy == e.second)
			return c[cx][cy][ccnt] - 1;

		if (!ccnt) {	//º® ¾È¹Ù²åÀ»¶§
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (!isIn(nx, ny)) continue;

				if (m[nx][ny] && !c[nx][ny][1]) {
					q.push({ {nx, ny}, 1 });
					c[nx][ny][1] = c[cx][cy][ccnt] + 1;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			if (!isIn(nx, ny)) continue;

			if (!m[nx][ny] && !c[nx][ny][ccnt]) {
				q.push({ {nx, ny}, ccnt });
				c[nx][ny][ccnt] = c[cx][cy][ccnt] + 1;
			}
		}
	}

	return -1;
}

int main() {
	cin >> N >> M;

	cin >> s.first >> s.second;
	s.first--; s.second--;
	cin >> e.first >> e.second;
	e.first--; e.second--;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> m[i][j];
		}
	}

	cout << bfs(s.first, s.second);


	return 0;
}