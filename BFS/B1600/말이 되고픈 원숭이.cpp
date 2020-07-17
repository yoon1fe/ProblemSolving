#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int K, W, H;

int m[200][200];
int c[200][200][30];
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
int hx[8] = { 1, 1, -1, -1, 2, 2, -2, -2 };
int hy[8] = { 2, -2, 2, -2, 1, -1, 1, -1 };

bool isIn(int x, int y) {
	if (0 <= x && x < H && 0 <= y && y < W) return true;
	else return false;
}

int bfs() {
	queue<pair<pair<int, int>, int>> q;		//좌표, k 사용 횟수
	q.push(make_pair(make_pair(0, 0), 0));
	c[0][0][0] = true;

	while (!q.empty()) {
		int cx = q.front().first.first;
		int cy = q.front().first.second;
		int ck = q.front().second;
		q.pop();

		if (cx == H - 1 && cy == W - 1)
			return c[cx][cy][ck] - 1;

		if (ck < K) {		//말처럼 이동하는 경우
			for (int i = 0; i < 8; i++) {
				int nx = cx + hx[i];
				int ny = cy + hy[i];
				int nk = ck + 1;

				if (isIn(nx, ny) && !c[nx][ny][nk] && !m[nx][ny]) {
					q.push(make_pair(make_pair(nx, ny), nk));
					c[nx][ny][nk] = c[cx][cy][ck] + 1;
				}
			}
		}
		//그냥 이동하는 경우
		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			int nk = ck;

			if (isIn(nx, ny) && !c[nx][ny][nk] && !m[nx][ny]) {
				q.push(make_pair(make_pair(nx, ny), nk));
				c[nx][ny][nk] = c[cx][cy][ck] + 1;
			}
		}
	}

	return -1;
}
int main() {
	cin >> K >> W >> H;

	for (int i = 0; i < H; i++)
		for (int j = 0; j < W; j++)
			cin >> m[i][j];

	cout << bfs();


	return 0;
}