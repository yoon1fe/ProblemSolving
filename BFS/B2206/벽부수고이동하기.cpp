#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;
typedef struct coord {
	int x;
	int y;
	bool breakwall;
}coord;

int N, M;
int m[1001][1001];
int c[1001][1001][2] = { 0, };
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < M) return true;
	else return false;
}

int bfs(void) {
	queue<coord> q;
	q.push({0, 0, false});
	c[0][0][0] = 1;

	while (!q.empty()) {
		int cx = q.front().x;
		int cy = q.front().y;
		bool cbool = q.front().breakwall;
		q.pop();

		if (cx == N - 1 && cy == M - 1)
			return c[cx][cy][cbool];

		if (!cbool) {		//벽 안 뿌섰을때
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				bool nbool = true;
				
				if (isIn(nx, ny) && !c[nx][ny][nbool] && m[nx][ny] == 1) {
					q.push({ nx, ny, nbool });
					c[nx][ny][nbool] = c[cx][cy][cbool] + 1;
				}
			}
		}
		for (int i = 0; i < 4; i++) {		//벽 부수었을 때
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			bool nbool = cbool;

			if (isIn(nx, ny) && !c[nx][ny][nbool] && m[nx][ny] == 0) {
				q.push({ nx, ny, nbool });
				c[nx][ny][nbool] = c[cx][cy][cbool] + 1;
			}
		}

	}

	return -1;
}

int main() {
	int t;
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &t);
			m[i][j] = t;
		}
	}

	cout << bfs();

	/*cout << endl;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			for(int k=0;k<2;k++)
				cout << c[i][j][k] << ' ';
			cout << ' ';
		}
		cout << endl;
	}*/

	return 0;
}