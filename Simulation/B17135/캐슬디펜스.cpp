#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N, M, D;
int maxAttack = 0;
int map[16][15] = { 0, };
int dx[3] = { -1 , 0, 0 };
int dy[3] = { 0, 1, -1 };

bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < M) return true;
	else return false;
}

void bfs(void) {
	int tMap[16][15] = { 0, };
	for (int i = 0; i <= N; i++) {
		for (int j = 0; j < M; j++) {
			tMap[i][j] = map[i][j];
		}
	}
	queue<pair<int, int>> q;
	vector<pair<int, int>> attack;
	int attackNum = 0;
	bool flag = false;


	while (!flag) {
		for (int i = 0; i < M; i++) {
			if (tMap[N][i] == 2) {
				q.push(make_pair(N, i));
				int c[16][15] = { 0, };
				c[N][i] = 1;
				int minDist = 999;
				pair<int, int> attackPos = { -1, -1 };

				while (!q.empty()) {
					int cx = q.front().first;
					int cy = q.front().second;
					q.pop();

					for (int i = 0; i < 3; i++) {
						int nx = cx + dx[i];
						int ny = cy + dy[i];

						if (!isIn(nx, ny) || nx == N) continue;
						if (c[nx][ny]) continue;
						if (c[cx][cy] > D)
							continue;
						c[nx][ny] = c[cx][cy] + 1;
						q.push({ nx, ny });

						if (tMap[nx][ny] == 1 && c[nx][ny] <= D + 1) {
							if (c[nx][ny] < minDist) {
								minDist = c[nx][ny];
							}
						}
					}

				}
				bool tflag = false;
				for (int j =0; j < M; j++) {
					for (int i = N - 1; i >= 0; i--) {
						if (c[i][j] == minDist && tMap[i][j] == 1) {
							attackPos = { i, j };
							tflag = true;
							break;
						}
					}
					if (tflag)
						break;
				}
				attack.push_back(attackPos);
			}
		}

		for (pair<int, int> temp : attack) {
			if (!isIn(temp.first, temp.second)) continue;
			if (tMap[temp.first][temp.second] == 1) {
				attackNum++;
				tMap[temp.first][temp.second] = 0;
			}
		}
		attack.clear();
		flag = true;
		for (int i = N - 1; i >= 0; i--) {	//적 내리기
			for (int j = 0; j < M; j++) {
				if (i == 0)
					tMap[i][j] = 0;
				else
					tMap[i][j] = tMap[i - 1][j];

				if (tMap[i][j] == 1)
					flag = false;
			}
		}
	}
	
	if (maxAttack < attackNum) {
		maxAttack = attackNum;
	}

}

void setArcher(int cnt) {
	if (cnt == 3) {
		bfs();
		return;
	}

	for (int i = 0; i < M; i++) {
		if (map[N][i] == 0) {
			map[N][i] = 2;
			setArcher(cnt + 1);


			map[N][i] = 0;
		}
	}
}

int main() {
	cin >> N >> M >> D;

	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> map[i][j];

	for (int i = 0; i < M; i++) {
		map[N][i] = 2;	//궁수
		setArcher(1);
		map[N][i] = 0;
	}

	cout << maxAttack;

	return 0;
}