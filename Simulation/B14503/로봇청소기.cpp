#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>
using namespace std;

int N, M;
int r, c, d;	//로봇 청소기 좌표, 방향
int m[50][50] = { 0, };
bool visited[50][50] = { 0 , };
int dx[4] = { 0, -1, 0, 1 };
int dy[4] = { -1, 0, 1, 0 };

bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < M) return true;
	else return false;
}

int bfs(void) {
	queue<pair<pair<int, int>, int>> q;		//좌표, 방향
	q.push({ { r, c }, d });
	visited[r][c] = true;
	int cnt = 0;
	int ans = 1;

	while (!q.empty()) {
		int cx = q.front().first.first;
		int cy = q.front().first.second;
		int cd = q.front().second;
		q.pop();

		int nx = cx + dx[cd];
		int ny = cy + dy[cd];
		int nd;

		if (!isIn(nx, ny)) continue;

		if (m[nx][ny] == 0 && !visited[nx][ny]) {	//청소할 거 있을 때
			nd = (cd + 3) % 4;
			q.push(make_pair(make_pair(nx, ny), nd));
			visited[nx][ny] = true;
			ans++;
			cnt = 0;
		}

		else if (m[nx][ny] || visited[nx][ny]) {	//청소할거 없을 때

			nd = (cd + 3) % 4;
			q.push(make_pair(make_pair(cx, cy), nd));
			cnt++;

		}

		if (cnt == 4) {
			cnt = 0;
			q.pop();
			nx = cx;
			ny = cy;

			switch (nd) {	//후진 방향
			case 0:
				nx = cx + 1;
				break;

			case 1:
				ny = cy - 1;
				break;

			case 2:
				nx = cx - 1;
				break;

			case 3:
				ny = cy + 1;
				break;
			}

			if (m[nx][ny] == 0) {	//뒤로 후진
				q.push({ {nx, ny}, nd });
				cnt = 0;
				continue;
			}
			else if (m[nx][ny] == 1) {
				return ans;
			}
		}


	}
}
int main() {
	cin >> N >> M;
	cin >> r >> c >> d;

	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> m[i][j];

	cout << bfs();

	return 0;
}