#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

int N, M;
int x, y;
int T;
int map[20][20];
vector<int> tcase;
vector<int> ans;

typedef struct dir {
	int x;
	int y;
}dir;
dir direction[5] = { {0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0} };



bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < M) return true;
	else return false;
}

void solve(int x, int y) {
	queue<pair<int, int>> q;
	int dice[7] = { 0, 0, 0, 0, 0, 0, 0 };
	int ndice[7] = { 0, 0, 0, 0, 0, 0, 0 };
	q.push({ x, y });
	
	for (int i = 0; i < T; i++) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		int nx = cx + direction[tcase.at(i)].x;
		int ny = cy + direction[tcase.at(i)].y;
		q.push({ nx, ny });

		if (!isIn(nx, ny)) {
			q.pop();
			q.push({ cx, cy });
			continue;
		}

		switch (tcase.at(i)) {
		case 1:	//µ¿
			ndice[1] = dice[4];
			ndice[2] = dice[2];
			ndice[3] = dice[1];
			ndice[4] = dice[6];
			ndice[5] = dice[5];
			ndice[6] = dice[3];
			break;

		case 2:	//¼­
			ndice[1] = dice[3];
			ndice[2] = dice[2];
			ndice[3] = dice[6];
			ndice[4] = dice[1];
			ndice[5] = dice[5];
			ndice[6] = dice[4];
			break;

		case 3:	//ºÏ
			ndice[1] = dice[5];
			ndice[2] = dice[1];
			ndice[3] = dice[3];
			ndice[4] = dice[4];
			ndice[5] = dice[6];
			ndice[6] = dice[2];
			break;

		case 4:	//³²
			ndice[1] = dice[2];
			ndice[2] = dice[6];
			ndice[3] = dice[3];
			ndice[4] = dice[4];
			ndice[5] = dice[1];
			ndice[6] = dice[5];
			break;
		}

		if (map[nx][ny] == 0) {
			map[nx][ny] = ndice[6];
		}
		else {
			ndice[6] = map[nx][ny];
			map[nx][ny] = 0;
		}

		ans.push_back(ndice[1]);
		for (int i = 1; i < 7; i++) {
			dice[i] = ndice[i];
		}
	}
	
}

int main() {
	cin >> N >> M >> x >> y >> T;
	int temp;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> map[i][j];

	for (int i = 0; i < T; i++) {
		cin >> temp;
		tcase.push_back(temp);
	}

	solve(x, y);

	for (int i = 0; i < ans.size(); i++)
		cout << ans.at(i)<< "\n";


	return 0;
}