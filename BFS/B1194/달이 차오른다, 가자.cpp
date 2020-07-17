#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N, M;
char map[50][50];
int check[50][50][32];		//[y][x] ÁÂÇ¥¿¡¼­ a~f ¿­¼è À¯¹«
pair<int, int> start;
int dy[4] = { 0, 0, 1, -1 };
int dx[4] = { 1, -1, 0, 0 };

bool isIn(int y, int x) {
	if (0 <= y && y < N && 0 <= x && x < M) return true;
	else return false;
}

void bfs() {
	queue<pair<int, int>> q;
	q.push(start);
	check[start.first][start.second][0] = 1;

	while (!q.empty()) {
		int cy = q.front().first;
		int cx = q.front().second;
		q.pop();


		for (int i = 0; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];

			if (!isIn(ny, nx) || map[ny][nx] == '#') continue;

			if (map[ny][nx] == 'a') {
				q.push({ ny, nx });
				check[ny][nx][0] = 
			}
		}
	}
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] == '0')
				start = { i, j };
		}
	}




	return 0;
}