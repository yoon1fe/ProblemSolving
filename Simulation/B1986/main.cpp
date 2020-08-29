#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef struct dir {
	int y;
	int x;
}dir;

int n, m;
dir qMove[8] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };
dir kMove[8] = { {1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1} };
int map[1001][1001] = { 0, };		//1: Q 2: K 3: P
bool isUnsafe[1001][1001] = { 0, };
vector<pair<int, int>> queen;
vector<pair<int, int>> knight;

bool isIn(int y, int x) {
	if (1 <= y && y <= n && 1 <= x && x <= m) return true;
	else return false;
}

void input() {
	int tn;
	cin >> tn;
	for (register int i = 0; i < tn; i++) {
		int y, x;
		cin >> y >> x;
		map[y][x] = 1;
		isUnsafe[y][x] = true;
		queen.push_back({ y, x });
	}
	cin >> tn;
	for (register int i = 0; i < tn; i++) {
		int y, x;
		cin >> y >> x;
		map[y][x] = 2;
		isUnsafe[y][x] = true;
		knight.push_back({ y, x });
	}
	cin >> tn;
	for (register int i = 0; i < tn; i++) {
		int y, x;
		cin >> y >> x;
		map[y][x] = 3;
		isUnsafe[y][x] = true;
	}
}

void queenMove() {
	for (register int i = 0; i < queen.size(); i++) {
		int cy = queen[i].first;
		int cx = queen[i].second;

		for (register int j = 0; j < 8; j++) {
			int ny = cy + qMove[j].y;
			int nx = cx + qMove[j].x;
			while (map[ny][nx] == 0 && isIn(ny, nx)) {
				isUnsafe[ny][nx] = true;
				ny += qMove[j].y;
				nx += qMove[j].x;
			}
		}
	}
}

void knightMove() {
	for (register int i = 0; i < knight.size(); i++) {
		int cy = knight[i].first;
		int cx = knight[i].second;

		for (register int j = 0; j < 8; j++) {
			int ny = cy + kMove[j].y;
			int nx = cx + kMove[j].x;
			if (isIn(ny, nx) && isUnsafe[ny][nx] == false) {
				isUnsafe[ny][nx] = true;
			}
		}
	}
}
int main() {
	cin >> n >> m;
	int answer = 0;
	input();

	queenMove();
	knightMove();

	for (register int i = 1; i <= n; i++) {
		for (register int j = 1; j <= m; j++) {
			if (isUnsafe[i][j] == false) {
				answer++;
			}
		}
	}

	cout << answer;

	return 0;
}