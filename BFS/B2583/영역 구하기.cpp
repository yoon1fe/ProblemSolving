#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int M, N, K;
int map[100][100] = { 0, };
int c[100][100] = { 0, };
int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };
int area[100];
int num = 0;
bool isIn(int x, int y) {
	if (0 <= x && x < M && 0 <= y && y < N)
		return true;
	else return false;
}

void bfs(int x, int y) {
	queue<pair<int, int>> q;
	pair<int, int> cur;
	pair<int, int> next;

	q.push(make_pair(x, y));
	c[x][y] = true;

	while (!q.empty()) {
		cur = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			next.first = cur.first + dx[i];
			next.second = cur.second + dy[i];

			if (!map[next.first][next.second] && !c[next.first][next.second] && isIn(next.first, next.second)) {
				q.push(next);
				c[next.first][next.second] = true;
				area[num]++;
			}
		}
	}


}
int main() {
	fill(area, area + 100, 1);
	cin >> M >> N >> K;
	int x1, y1, x2, y2;
	int ans = 0;
	for (int i = 0; i < K; i++) {
		cin >> x1 >> y1 >> x2 >> y2;


		for (int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++) {
				map[i][j] = 1;
			}
		}
	}

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (!c[i][j] && !map[i][j]) {
				bfs(i, j);
				ans++;
				num++;
			}
		}
	}

	sort(area, area + ans);
	cout << ans << endl;
	for (int i = 0; i < ans; i++)
		cout << area[i] << ' ';

	return 0;
}