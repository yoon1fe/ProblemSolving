#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int T, N, M, c;
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
int map[51][51];

bool isIn(int x, int y) {
	if (0 <= x && x < M && 0 <= y && y < N)
		return true;
	else return false;
}

void bfs(int x, int y) {
	map[x][y] = 0;
	queue<pair<int, int>> q;
	q.push(pair<int, int>(x, y));
	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ax = cx + dx[i];
			int ay = cy + dy[i];
			if (isIn(ax, ay) && map[ax][ay] == 1) {
				map[ax][ay] = 0;
				q.push(pair<int, int>(ax, ay));
			}
		}
	}
}

int main() {
	cin >> T;
	int cnt;

	for (int i = 0; i < T; i++) {
		cin >> M >> N >> c;
		cnt = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 0;
			}
		}

		int x, y;
		for (int j = 0; j < c; j++) {
			cin >> x >> y;
			map[x][y] = 1;
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}

		cout << cnt << endl;
	}

	return 0;
}