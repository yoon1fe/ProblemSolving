#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N, M;
char map[51][51];
int c[50][50];
int dx[4] = { 1, -1, 0 ,0 };
int dy[4] = { 0, 0, 1, -1 };

bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < M)
		return true;
	else return false;
}

int bfs(int x, int y) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	c[x][y] = 0;

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (isIn(nx, ny) && map[nx][ny] == 'L' && c[nx][ny] == -1) {
				q.push(make_pair(nx, ny));
				c[nx][ny] = c[cx][cy] + 1;
			}
		}
	}

	int max = -2;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (max < c[i][j])
				max = c[i][j];
		}
	}

	fill(&c[0][0], &c[N - 1][M], -1);
	
	return max;
}
int main() {
	cin >> N >> M;
	vector<int> v;
	int t;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}

	fill(&c[0][0], &c[N-1][M], -1);

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] == 'L' && c[i][j] == -1) {
				t = bfs(i, j);
				v.push_back(t);
			}
		}
	}
	sort(v.begin(), v.end());

	cout << v.at(v.size()-1);



	return 0;
}