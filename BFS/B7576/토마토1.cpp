#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
int box[1000][1000] = { 0, };
int d[1000][1000] = { 0, };
int N, M;
int day = 0;

bool inIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < M)
		return true;
	else return false;
}

void bfs(void) {
	queue<pair<int, int>> q;
	int nx;
	int ny;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (box[i][j] == 1) {
				q.push(make_pair(i, j));
			}
		}
	}

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();
		
		for (int i = 0; i < 4; i++) {
			nx = cx + dx[i];
			ny = cy + dy[i];

			if (inIn(nx, ny) && !d[nx][ny] && box[nx][ny] == 0) {
				d[nx][ny] = d[cx][cy] + 1;
				q.push(make_pair(nx, ny));
			}
		}
	}
}

int main() {
	cin >> M >> N;
	int unripen = 0;
	int result = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &box[i][j]);
			if (box[i][j] == 0)
				unripen++;
		}
	}

	if (unripen == 0) {
		cout << 0 << endl;
		return 0;
	}

	bfs();

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (box[i][j] != 0)
				d[i][j] = box[i][j];
		}
	}
	result = d[0][0];
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (d[i][j] == 0) {
				cout << -1 << endl;
				return 0;
			}
			else if(d[i][j] > result){
				result = d[i][j];
			}
		}
	}

	cout << result << endl;

	return 0;
}