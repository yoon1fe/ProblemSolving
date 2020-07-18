#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>

using namespace std;

int N;
int island = 1;

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
int m[100][100];
int c[100][100] = { 0, };

bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < N)
		return true;
	else return false;
}

void bfs(int x, int y) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	c[x][y] = true;
	m[x][y] = island;
	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (isIn(nx, ny) && !c[nx][ny] && m[nx][ny] == 1) {
				q.push(make_pair(nx, ny));
				m[nx][ny] = island;
				c[nx][ny] = true;
			}
		}
	}
}

int bfs_for_solve(int island) {
	queue<pair<int, int>> q;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (m[i][j] == island) {
				q.push(make_pair(i, j));
			}
		}
	}

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (isIn(nx, ny) && !c[nx][ny] && m[nx][ny] != island) {
				q.push(make_pair(nx, ny));
				c[nx][ny] = c[cx][cy] + 1;
			}
			if (isIn(nx, ny) && m[nx][ny] != 0 && m[nx][ny] != island)
				return c[nx][ny] - 1;
		}
	}
}

int main() {
	cin >> N;
	vector<int> v;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> m[i][j];
		}
	}


	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!c[i][j] && m[i][j] == 1) {
				bfs(i, j);
				island++;
			}
		}
	}

	/*for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << c[i][j] << ' ';
		}
		cout << endl;
	}*/

	for (int k = 1; k < island; k++) {
		memset(c, 0, sizeof(c));
		v.push_back(bfs_for_solve(k));

		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cout << c[i][j] << ' ';
			}
			cout << endl;
		}*/
	}
	sort(v.begin(), v.end());
	cout << v.at(0);


	return 0;
}