#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef struct shark {
	int speed;
	int dir;	//1: 위 2: 아래 3: 오른쪽 4: 왼쪽
	int size;
}shark;
typedef struct newshark {
	int y, x;
	int speed;
	int dir;	//1: 위 2: 아래 3: 오른쪽 4: 왼쪽
	int size;
}newShark;
vector<shark> m[101][101];
int R, C, M;
int x, y, s, d, z;
int dy[5] = { 0, -1, 1, 0, 0 };
int dx[5] = { 0, 0, 0, 1, -1 };

bool isIn(int y, int x) {
	if (0 < y && y <= R && 0 < x && x <= C) return true;
	else return false;
}

int main() {
	int ans = 0;
	cin >> R >> C >> M;
	for (int i = 0; i < M; i++) {
		cin >> y >> x >> s >> d >> z;
		m[y][x].push_back({ s, d, z });
	}

	for (int i = 1; i <= C; i++) {
		for (int j = 1; j <= R; j++) {
			if (!m[j][i].empty()) {
				ans += m[j][i][0].size;
				m[j][i].clear();
				break;
			}
		}
		vector<newShark> temp;

		for (int y = 1; y <= R; y++) {
			for (int x = 1; x <= C; x++) {
				if (!m[y][x].empty()) {
					int ny = y;
					int nx = x;
					int nspeed = m[y][x][0].speed;
					int ndir = m[y][x][0].dir;
					int rotate;

					if (ndir == 1 || ndir == 2) {
						rotate = (R - 1) * 2;
						if (nspeed > rotate) nspeed %= rotate;
					}

					else if (ndir == 3 || ndir == 4) {
						rotate = (C - 1) * 2;
						if (nspeed > rotate) nspeed %= rotate;
					}

					for (int moveCnt = 0; moveCnt < nspeed; moveCnt++) {
						ny += dy[ndir];
						nx += dx[ndir];
						if (!isIn(ny, nx)) {
							if (ndir == 1) ndir = 2;
							else if (ndir == 2) ndir = 1;
							else if (ndir == 3) ndir = 4;
							else if (ndir == 4) ndir = 3;

							ny += dy[ndir];
							nx += dx[ndir];
							ny += dy[ndir];
							nx += dx[ndir];
						}

					}
					
					temp.push_back({ ny, nx, m[y][x][0].speed, ndir, m[y][x][0].size });
					m[y][x].clear();
				}
			}
		}

		for (int k = 0; k < temp.size(); k++) {
			if (m[temp[k].y][temp[k].x].empty()) {
				m[temp[k].y][temp[k].x].push_back({ temp[k].speed, temp[k].dir, temp[k].size });
			}
			else {
				if (m[temp[k].y][temp[k].x][0].size < temp[k].size) {
					m[temp[k].y][temp[k].x].clear();
					m[temp[k].y][temp[k].x].push_back({ temp[k].speed, temp[k].dir, temp[k].size });
				}
			}
		}
	}

	cout << ans;

	return 0;
}