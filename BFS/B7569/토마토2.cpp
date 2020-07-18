#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

typedef struct cs {
	int x;
	int y;
	int z;
}cs;

int m[100][100][100];
int c[100][100][100] = { 0, };

int dx[6] = { 1, -1, 0, 0, 0, 0 };
int dy[6] = { 0, 0, 1, -1, 0, 0 };
int dz[6] = { 0, 0, 0, 0, 1, -1 };
int M, N, H;

bool isIn(int z, int x, int y) {
	if (0 <= z && z < H && 0 <= x && x < N && 0 <= y && y < M)
		return true;
	else return false;
}

void bfs(void) {
	queue<cs> q;
	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (m[i][j][k] == 1) {
					cs ipt;
					ipt.x = j;
					ipt.y = k;
					ipt.z = i;
					q.push(ipt);
					c[i][j][k]++;
				}
					
			}
		}
	}
	

	while (!q.empty()) {
		int cx = q.front().x;
		int cy = q.front().y;
		int cz = q.front().z;
		q.pop();

		for (int i = 0; i < 6; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			int nz = cz + dz[i];

			if (isIn(nz, nx, ny) && c[nz][nx][ny] == 0 && m[nz][nx][ny] == 0 ) {
				cs next;
				next.x = nx;
				next.y = ny;
				next.z = nz;

				q.push(next);
				c[nz][nx][ny] = c[cz][cx][cy] + 1;
			}
		}

	}


}

int main() {
	cin >> M >> N >> H;
	int ans = 0;
	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				cin >> m[i][j][k];
				if (m[i][j][k] == 0)
					ans++;
			}
		}
	}


	if (ans == 0) {
		cout << ans;
		return 0;
	}

	bfs();

	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (m[i][j][k] == -1) {
					c[i][j][k] = -1;
				}
			}
		}
	}


	//for (int i = 0; i < H; i++) {
	//	for (int j = 0; j < N; j++) {
	//		for (int k = 0; k < M; k++) {
	//			cout << c[i][j][k];
	//		}
	//		cout << endl;
	//	}
	//	cout << endl;
	//}


	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (c[i][j][k] == 0) {
					cout << -1;
					return 0;
				}
			}
		}
	}

	ans = c[0][0][0];
	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (ans < c[i][j][k])
					ans = c[i][j][k];
			}
		}
	}

	cout << ans - 1;

	return 0;
}