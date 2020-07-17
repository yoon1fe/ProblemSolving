#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int N, M;
int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };
int m[100][100] = { 0, };
int c[100][100] = { 0, };
bool isIn(int x, int y) {
	if (x >= 0 && x < N && y >= 0 && y < M)
		return true;
	else false;
}

void bfs(void) {
	queue<pair<int, int> > q;
	q.push(make_pair(0, 0));
	c[0][0] = true;

	while (!q.empty()) {
		pair<int, int> cur = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			pair<int, int> next = make_pair(cur.first + dx[i], cur.second + dy[i]);

			if (isIn(next.first, next.second) && c[next.first][next.second] == 0 && m[next.first][next.second] == 1) {
				q.push(next);
				c[next.first][next.second] = 1 + c[cur.first][cur.second];
			}
			
		}
	}
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &m[i][j]);
		}
	}

	bfs();
	cout << c[N-1][M-1] << endl;


	return 0;
}