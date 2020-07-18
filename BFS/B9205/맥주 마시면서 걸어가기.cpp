#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int t, n;
int map[65536][65536] = { 0, };
int check[65536][65536] = { 0, };
pair<int, int> start, dest;
vector<pair<int, int>> conv;
int dy[4] = { 0, 0, 1, -1 };
int dx[4] = { 1, -1, 0, 0 };
int beer = 20;

bool isIn(int y, int x) {
	if (start.first <= y && y <= dest.first && start.second <= x && x <= dest.second) return true;
	else return false;
}

string bfs() {
	queue<pair<int, int>> q;
	q.push(start);
	check[start.first][start.second] = true;

	while (!q.empty()) {
		int cy = q.front().first;
		int cx = q.front().second;
		q.pop();

		if (cy == dest.first && cx == dest.second)
			return "happy";
		for (int i = 0; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];


			if (!isIn(ny, nx) || check[ny][nx]) continue;

			if (check[ny][nx] == 2) {
				beer = 20;
			}

			check[ny][nx] = 1;
			q.push({ ny, nx });

			if (abs(ny - start.first) + abs(nx - start.second) % 50 == 0) {
				beer--;
			}


		}
	}

	return "sad";

}
int main() {
	cin >> t;


	for (int i = 0; i < t; i++) {
		cin >> n;
		
		int a, b;
		cin >> a >> b;
		start = { a + 32768, b + 32768 };

		for (int j = 0; j < n; j++) {
			cin >> a >> b;
			conv.push_back({ a + 32768, b + 32768 });
			check[a + 32768][b + 32768] = 2;
		}
		cin >> a >> b;
		dest = { a + 32768, b + 32768 };


		cout << bfs() << "\n";

	}


	return 0;
}