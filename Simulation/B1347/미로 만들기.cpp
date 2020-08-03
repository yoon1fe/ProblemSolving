#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

typedef struct {
	int y;
	int x;
}cord;

int N;
string input;
int map[102][102] = { 0, };
cord moves[4] = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };

void solve(string m) {
	int dir = 0;
	int cx = 50;
	int cy = 50;
	cord minCor = { cy, cx };
	cord maxCor = { cy, cx };
	map[cy][cx] = 1;	//이동할 수 있는 곳 1
	for (int i = 0; i < m.size(); i++) {
		if (m[i] == 'L') {
			dir = (dir - 1 + 4) % 4;
		}
		else if (m[i] == 'R') {
			dir = (dir + 1 + 4) % 4;
		}
		else {
			int ny = cy + moves[dir].y;
			int nx = cx + moves[dir].x;

			minCor.y = min(minCor.y, ny);
			minCor.x = min(minCor.x, nx);
			maxCor.y = max(maxCor.y, ny);
			maxCor.x = max(maxCor.x, nx);

			map[ny][nx] = 1;
			cy = ny;
			cx = nx;
		}
	}

	for (int i = minCor.y; i <= maxCor.y; i++) {
		for (int j = minCor.x; j <= maxCor.x; j++) {
			if (map[i][j] == 0) cout << '#';
			else cout << '.';
		}
		cout << "\n";
	}
}

int main() {
	cin >> N;
	cin >> input;

	solve(input);
	
	return 0;
}