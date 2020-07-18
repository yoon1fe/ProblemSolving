#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int R, C;
vector<pair<int, int>> swan;
int visited[1500][1500] = { 0, };
char map[1500][1500];
int dy[4] = { 0, 0, 1, -1 };
int dx[4] = { 1, -1, 0, 0 };

bool isIn(int y, int x) {
	if (0 <= y && y < R && 0 <= x && x < C) return true;
	else return false;
}

void bfs() {
	int day = 1;

	//while (1) {
		queue<pair<int, int>> q;

		q.push(swan[0]);
		q.push(swan[1]);
		visited[swan[0].first][swan[0].second] = day;
		visited[swan[1].first][swan[1].second] = day;

		while (!q.empty()) {
			int cy = q.front().first;
			int cx = q.front().second;
			q.pop();


			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (!isIn(ny, nx) || visited[ny][nx]) continue;
				if (map[ny][nx] == 'X') visited[ny][nx] = visited[cy][cx] + 1;
				else visited[ny][nx] = day;
				q.push({ ny, nx });
			}

			//day++;
		}

		/*bool check[1500][1500] = { 0, };
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X') check[i][j] = true;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '.') continue;
				if (check[i][j]) continue;
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];

					if (!isIn(ny, nx) || map[ny][nx] != 'X') continue;
					map[ny][nx] = '.';
				}
			}
		}*/
	//	day++;
//	}

}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio();

	cin >> R >> C;

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> map[i][j];
			if (map[i][j] == 'L') swan.push_back({ i, j });
		}
	}

	bfs();

	return 0;
}