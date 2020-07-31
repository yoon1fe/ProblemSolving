#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;


int N, K, L;
int m[101][101] = { 0, };	//2: 사과 3: 뱀
int ans = 0;
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

pair<int, char> moving[100];

bool isIn(int y, int x) {
	if (1 <= y && y <= N && 1 <= x && x <= N) return true;
	else return false;
}

int bfs() {
	queue<pair<int, int>> q;
	queue<pair<int, int>> snake;
	int time = 0;
	q.push({ 1, 1, });
	snake.push({ 1, 1 });

	m[1][1] = 3;
	int curDir = 0;		//처음 이동할 방향: dydx = 0, 1
	int movingCount = 0;

	while (!q.empty()) {
		int cy = q.front().first;
		int cx = q.front().second;
		q.pop();

		int ny = cy + dy[curDir];
		int nx = cx + dx[curDir];
		snake.push({ ny, nx });

		time++;

		if (m[ny][nx] == 3 || !isIn(ny, nx))
			return time;
		
		if (m[ny][nx] != 2) {
			m[snake.front().first][snake.front().second] = 0;
			snake.pop();
		}
		m[ny][nx] = 3;
		q.push({ ny, nx });


		if (time == moving[movingCount].first) {
			switch (curDir) {
			case 0:
				if (moving[movingCount].second == 'L')
					curDir = 3;
				else if (moving[movingCount].second == 'D')
					curDir = 2;
				break;

			case 1:
				if (moving[movingCount].second == 'L')
					curDir = 2;
				else if (moving[movingCount].second == 'D')
					curDir = 3;
				break;

			case 2:
				if (moving[movingCount].second == 'L')
					curDir = 0;
				else if (moving[movingCount].second == 'D')
					curDir = 1;
				break;

			case 3:
				if (moving[movingCount].second == 'L')
					curDir = 1;
				else if (moving[movingCount].second == 'D')
					curDir = 0;
				break;
			}

			movingCount++;
		}
	}
}

int main() {
	cin >> N >> K;

	for (int i = 0; i < K; i++) {
		int t1, t2;
		cin >> t1 >> t2;
		m[t1][t2] = 2;
	}

	cin >> L;
	for (int i = 0; i < L; i++) {
		int t1;
		char t2;
		cin >> t1 >> t2;
		moving[i].first = t1;
		moving[i].second = t2;
	}


	cout << bfs();

	return 0;
}