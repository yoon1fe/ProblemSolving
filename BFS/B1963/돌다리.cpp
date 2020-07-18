#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

int A, B, N, M;

int m[100001];
int c[100001] = { 0, };
vector<int> dx;

bool isIn(int x) {
	if (0 <= x && x <= 100000)
		return true;
	else return false;
}

int bfs() {
	queue<int> q;
	q.push(N);
	c[N] = 1;

	while (!q.empty()) {
		int cx = q.front();
		q.pop();

		if (cx == M)
			return c[cx] - 1;

		for (int i = 0; i < 8; i++) {
			int nx;
			if (i < 6)
				nx = cx + dx.at(i);
			else if (i == 6)
				nx = cx * A;
			else if (i == 7)
				nx = cx * B;

			if (isIn(nx) && !c[nx]) {
				q.push(nx);
				c[nx] = c[cx] + 1;
			}
		}
	}
}

int main() {
	cin >> A >> B >> N >> M;
	dx.push_back(1);
	dx.push_back(-1);
	dx.push_back(A);
	dx.push_back(A * -1);
	dx.push_back(B);
	dx.push_back(B * -1);

	cout << bfs();
	return 0;
}