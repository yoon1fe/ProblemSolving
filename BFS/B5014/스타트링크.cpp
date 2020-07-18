#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int F, S, G, U, D;
int elevator[1000001];
int c[1000001];
int dx[2];

bool isIn(int x) {
	if (0 < x && x <= F) return true;
	else return false;
}

int bfs(int s) {
	queue<int> q;
	q.push(s);
	c[s] = 0;

	while (!q.empty()) {
		int cx = q.front();
		q.pop();

		if (cx == G)
			return c[cx];

		for (int i = 0; i < 2; i++) {
			int nx = cx + dx[i];

			if (isIn(nx) && c[nx] == -1) {
				q.push(nx);
				c[nx] = c[cx] + 1;
			}
		}
	}

	return -1;
}

int main() {
	cin >> F >> S >> G >> U >> D;
	int ans = 0;

	fill(c, c + F + 1, -1);

	dx[0] = U;
	dx[1] = D * -1;

	ans = bfs(S);
	if (S == G)
		ans = 0;

	if (ans == -1)
		cout << "use the stairs";
	else
		cout << ans;
	
	return 0;
}