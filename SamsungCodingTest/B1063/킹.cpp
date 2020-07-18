#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

typedef struct {
	int y;
	int x;
}pos;

int N;
pos king, stone;

int dy[8] = { 0, 0, 1, -1, -1, -1, 1, 1 };
int dx[8] = { 1, -1, 0, 0, 1, -1, 1, -1 };

bool isIn(int y, int x) {
	if (0 <= y && y < 8 && 0 <= x && x < 8) return true;
	else return false;
}

void moving(string moves) {
	int dir = 0;
	if (moves == "R") dir = 0;
	else if (moves == "L") dir = 1;
	else if (moves == "B") dir = 2;
	else if (moves == "T") dir = 3;
	else if (moves == "RT") dir = 4;
	else if (moves == "LT") dir = 5;
	else if (moves == "RB") dir = 6;
	else if (moves == "LB") dir = 7;

	int ny = king.y + dy[dir];
	int nx = king.x + dx[dir];

	if (!isIn(ny, nx)) return;

	if (ny == stone.y && nx == stone.x) {
		int sNy = stone.y + dy[dir];
		int sNx = stone.x + dx[dir];

		if (!isIn(sNy, sNx)) return;

		king.y = ny;
		king.x = nx;
		stone.y = sNy;
		stone.x = sNx;
	}

	else {
		king.y = ny;
		king.x = nx;
	}
}

int main() {
	string k, s;

	cin >> k >> s >> N;
	king.x = k[0] - 65;
	king.y = 8 - (k[1] - '0');
	stone.x = s[0] - 65;
	stone.y =8 - (s[1] - '0');

	for (int i = 0; i < N; i++) {
		string t;
		cin >> t;
		moving(t);
	}

	char kx = king.x + 65;
	char ky = (8 - king.y) + '0';
	char sx = stone.x + 65;
	char sy = (8 - stone.y) + '0';

	cout << kx << ky << "\n" << sx << sy;

	return 0;
} 