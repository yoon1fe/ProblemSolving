#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N, M;
int ans = 0;
int m[8][8];
int temp[8][8];
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
bool c[8][8] = { 0, };

bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < M) return true;
	else return false;
}

void bfs() {
	int safe = 0;
	int t[8][8];
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			t[i][j] = temp[i][j];

	queue<pair<int, int>> q;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (t[i][j] == 2) {
				q.push({ i, j });
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

			if (isIn(nx, ny) && t[nx][ny] == 0 ) {
				q.push({ nx, ny });
				t[nx][ny] = 2;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (t[i][j] == 0)
				safe++;
		}
	}

	ans = max(safe, ans);
}

void makeWall(int cnt) {
	if (cnt == 3) {
		bfs();
		return;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (temp[i][j] == 0) {
				temp[i][j] = 1;
				makeWall(cnt + 1);
				temp[i][j] = 0;
			}
		}
	}
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> m[i][j];
			temp[i][j] = m[i][j];
		}
	}
	//벽세우기
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (temp[i][j] == 0) {
				temp[i][j] = 1;
				makeWall(1);
				temp[i][j] = 0;
			}
		}
	}

	cout << ans;

	return 0;
}