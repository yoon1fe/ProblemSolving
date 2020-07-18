#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int N;
int m[101][101] = { 0, };
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
bool c[101][101];

bool isIn(int x, int y) {
	if (0 <= x && x <= 100 && 0 <= y && y <= 100)
		return true;
	else return false;
}

void bfs(int x, int y, int depth) {
	queue<pair<int, int>> q;

	q.push(make_pair(x, y));
	c[x][y] = true;

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (isIn(nx, ny) && m[nx][ny] > depth&& c[nx][ny] == false) {
				q.push(make_pair(nx, ny));
				c[nx][ny] = true;
			}
		}
	}

}
int main() {
	cin >> N;
	vector<int> v;
	int cnt = 0;
	int maxlen = 0;
	bool s = true;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			cin >> m[i][j];
	maxlen = m[0][0];

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (maxlen < m[i][j])
				maxlen = m[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (maxlen != m[i][j])
				s = false;
		}
	}
	if (s) {
		cout << 1 << endl;
		return 0;
	}
	for (int k = 1; k < maxlen; k++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (m[i][j] > k && !c[i][j]) {
					cnt++;
					bfs(i, j, k);
				}
			}
		}
		v.push_back(cnt);
		cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				c[i][j] = false;
	}


	cout << *max_element(v.begin(), v.end()) << endl;

	return 0;
}