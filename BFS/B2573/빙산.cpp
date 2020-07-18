#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N, M;
int m[300][300];
int melt[300][300];
int c[300][300];
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };


void melting(int x, int y) {
	int cnt = 0;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (m[nx][ny] == 0)
			cnt++;
	}

	melt[x][y] = cnt;
}

void bfs(int x, int y) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	
	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (m[nx][ny] != 0 && !c[nx][ny]) {
				q.push(make_pair(nx, ny));
				c[nx][ny] = 1;
			}
		}

	}
}

int main() {
	cin >> N >> M;
	int daycnt = 0;
	int zcnt = 0;
	int icecnt = 0;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> m[i][j];

	while (1) {
		daycnt++;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] != 0) {
					melting(i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				m[i][j] -= melt[i][j];
				if (m[i][j] < 0)
					m[i][j] = 0;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] != 0)
					zcnt++;
			}
		}

		if (zcnt == 0) {
			cout << 0;
			return 0;
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] != 0 && !c[i][j]) {
					bfs(i, j);
					icecnt++;
				}
			}
		}
		fill(&c[0][0], &c[N - 1][M], 0);

		if (icecnt > 1) {
			cout << daycnt;
			return 0;
		}
		else
			icecnt = 0;


		//for (int i = 0; i < N; i++) {
		//	for (int j = 0; j < M; j++) {
		//		cout << m[i][j] << ' ';
		//	}
		//	cout << endl;
		//}
		//cout << endl;

		zcnt = 0;
	}


	return 0;
}