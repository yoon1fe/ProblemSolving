#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>
using namespace std;

typedef struct coord {
	int z;
	int x;
	int y;
	
}coord;
int L, R, C;

char m[30][30][30];
int c[30][30][30] = { 0, };
int dz[6] = { 0, 0, 0, 0, 1, -1 };
int dx[6] = { 1, -1, 0, 0, 0, 0 };
int dy[6] = { 0, 0, 1, -1, 0, 0 };

bool isIn(int z, int x, int y) {
	if (0 <= x && x < R && 0 <= y && y < C && 0 <= z && z < L) return true;
	else return false;
}

int bfs(coord s) {
	queue<coord> q;
	q.push(s);
	c[s.z][s.x][s.y] = 1;

	while (!q.empty()) {
		int cz = q.front().z;
		int cx = q.front().x;
		int cy = q.front().y;
		q.pop();

		if (m[cz][cx][cy] == 'E')
			return c[cz][cx][cy] - 1;

		for (int i = 0; i < 6; i++) {
			int nz = cz + dz[i];
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (isIn(nz, nx, ny) && m[nz][nx][ny] != '#' && !c[nz][nx][ny]) {
				q.push({ nz, nx, ny });
				c[nz][nx][ny] = c[cz][cx][cy] + 1;
			}
		}
	}

	return -1;
}

int main() {
	int ans = 0;

	while (1) {
		cin >> L >> R >> C;
		if (!L && !R && !C)
			break;
		coord s;
		for (int k = 0; k < L; k++) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					cin >> m[k][i][j];
					if (m[k][i][j] == 'S')
						s = { k, i, j };
				}
			}
		}

		ans = bfs(s);
		(ans > 0) ? (cout << "Escaped in" << " " << ans << " minute(s)." << endl) : (cout << "Trapped!" << endl);

		memset(c, 0, sizeof(c));
		memset(m, NULL, sizeof(m));
	}
	return 0;
}