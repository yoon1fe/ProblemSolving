#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N;
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
int m[25][25] = { 0, };
bool c[25][25];
int cnt = 0;
vector<int> v;

bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < N)
		return true;
	else return false;
}

void bfs(int x, int y) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	c[x][y] = true;
	int apt = 1;
	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (isIn(nx, ny) && !c[nx][ny] && m[nx][ny] == 1) {
				q.push(make_pair(nx, ny));
				c[nx][ny] = true;
				apt++;
			}
		}
	}

	v.push_back(apt);
}

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++)
			scanf("%1d", &m[i][j]);
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!c[i][j] && m[i][j] == 1) {
				cnt++;
				bfs(i, j);
			}
		}
	}

	sort(v.begin(), v.end());

	cout << cnt << endl;
	for (int i = 0; i < v.size(); i++)
		cout << v.at(i) << endl;

	return 0;
}