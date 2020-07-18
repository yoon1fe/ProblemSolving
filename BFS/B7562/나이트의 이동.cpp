#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N;	// 테스트 케이스 수
int I; // 체스판 한 변의 길이
pair<int, int> s;
pair<int, int> goal;
int dx[8] = { -1, -2, -2, -1, 1, 2, 2, 1 };
int dy[8] = { -2, -1, 1, 2, 2, 1, -1, -2 };
vector<int> ans;

bool isIn(int x, int y) {
	if (0 <= x && x < I && 0 <= y && y < I)
		return true;
	else return false;
}

void bfs(void) {
	queue<pair<int, int>> q;
	q.push(s);
	int x = s.first;
	int y = s.second;
	int c[301][301] = { 0, };

	c[x][y] = 1;

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;

		q.pop();

		for (int i = 0; i < 8; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (isIn(nx, ny) && c[nx][ny] == 0) {
				q.push(make_pair(nx, ny));
				c[nx][ny] = c[cx][cy] + 1;
			}
		}

		if (c[goal.first][goal.second] != 0) {
			ans.push_back(c[goal.first][goal.second] - 1);
			return;
		}
	}
}

int main() {
	cin >> N;
	int t1, t2;
	for (int i = 0; i < N; i++) {
		cin >> I;
		cin >> t1 >> t2;
		s = make_pair(t1, t2);
		cin >> t1 >> t2;
		goal = make_pair(t1, t2);

		bfs();
	}

	for (int i = 0; i < N; i++)
		cout << ans.at(i) << endl;

	return 0;
}