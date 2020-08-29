#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

char map[5][9];
int dy[4] = { 1, -1, 0, 0 };
int dx[4] = { 0, 0, 1, -1 };
pair<int, int> ans = { 0, 0 };		//핀 개수, 움직인 회수

bool isIn(int y, int x) {
	if (0 <= y && y < 5 && 0 <= x && x < 9) return true;
	else return false;
}

void dfs(int y, int x, int pin, int move) {
	if (pin <= ans.first) {
		if (pin == ans.first) {
			if (ans.second != 0)
				ans.second = min(ans.second, move);
		}
		else {
			ans.first = pin;
			ans.second = move;
		}
	}

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (!isIn(ny, nx)) continue;
		if (map[ny][nx] != 'o') continue;

		int ny2 = ny + dy[i];
		int nx2 = nx + dx[i];

		if (!isIn(ny2, nx2)) continue;
		if (map[ny2][nx2] != '.') continue;


		map[y][x] = '.';
		map[ny][nx] = '.';
		map[ny2][nx2] = 'o';

		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 9; x++) {
				if (map[y][x] == 'o')
					dfs(y, x, pin - 1, move + 1);
			}
		}

		map[y][x] = 'o';
		map[ny][nx] = 'o';
		map[ny2][nx2] = '.';
	}
}

int main() {
	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		int pinN = 0;
		ans = { 0, 0 };

		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 9; x++) {
				cin >> map[y][x];
				if (map[y][x] == 'o') {
					pinN++;
				}
			}
		}

		ans.first = pinN;
		
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 9; x++) {
				if (map[y][x] == 'o') {
					dfs(y, x, pinN, 0);
				}
			}
		}

		cout << ans.first << ' ' << ans.second << "\n";
	}


	return 0;
}