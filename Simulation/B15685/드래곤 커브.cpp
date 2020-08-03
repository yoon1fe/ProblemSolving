#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N;
bool m[101][101] = { 0, };	//[y][x]
int dy[4] = { 0, -1, 0, 1 };
int dx[4] = { 1, 0, -1, 0 };

bool isIn(int y, int x) {
	if (0 <= y && y <= 100 && 0 <= x && x <= 100) return true;
	else return false;
}

void makeCurve(int x, int y, int d, int g) {
	vector<int> dir;
	dir.push_back(d);
	m[y][x] = true;

	for (int i = 0; i < g; i++)
		for (int j = dir.size() - 1; j >= 0; j--)
			dir.push_back((dir.at(j) + 1) % 4);

	for (int i = 0; i < dir.size(); i++) {
		int k = dir.at(i);
		y += dy[k];
		x += dx[k];

		if (!isIn(y, x)) break;
		if(!m[y][x])
			m[y][x] = true;
	}
}
int main() {
	int x, y, d, g;	//좌표, 방향, 세대
	int ans = 0;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> x >> y >> d >> g;
		makeCurve(x, y, d, g);
	}

	for (int i = 0; i < 100; i++)
		for (int j = 0; j < 100; j++)
			if (m[i][j] && m[i + 1][j] && m[i + 1][j + 1] && m[i][j + 1])
				ans++;

	cout << ans;

	return 0;
}