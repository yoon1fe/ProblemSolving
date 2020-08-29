#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;


int map[100][100] = { 0, };
int t[100][100];
int dy[4] = { 1, -1, 0, 0 };
int dx[4] = { 0, 0, 1, -1 };
int N, M;
int cheeseNum = 0;

bool isIn(int y, int x) {
	if (0 <= y && y < N && 0 <= x && x < M) return true;
	else return false;
}

void air(int y, int x) {
	queue<pair<int, int>> q;
	q.push({ y, x });
	map[y][x] = -1;
	bool c[100][100] = { 0, };
	c[y][x] = true;

	while (!q.empty()) {
		int cy = q.front().first;
		int cx = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			
			if (!isIn(ny, nx)) continue;

			if (!c[ny][nx] && map[ny][nx] == 0) {
				q.push({ ny, nx });
				c[ny][nx] = true;
				map[ny][nx] = -1;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] == 1) {
				int airN = 0;
				for (int k = 0; k < 4; k++ ) {
					int ny = i + dy[k];
					int nx = j + dx[k];

					if (map[ny][nx] == -1) {
						airN++;
					}
				}
				if (airN > 1) {
					map[i][j] = 0;
					cheeseNum--;
				}
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] == -1) {
				map[i][j] = 0;
			}
		}
	}

}


int main() {
	cin >> N >> M;
	int time = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) cheeseNum++;
		}
	}


	while (cheeseNum > 0) {
		time++;
		bool flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					air(i, j);
					flag = true;
					break;
				}
			}
			if (flag) break;
		}

	}


	cout << time;

	return 0;
}