#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int c[1000001] = { 0, };
int dx[3] = { 1, -1, 2 };
int N, K;

void bfs(int s) {
	queue<int> q;
	int nx = 0;
	q.push(s);
	c[s] = 1;
	
	while (!q.empty()) {
		int cx = q.front();
		q.pop();

		for (int i = 0; i < 3; i++) {
			if (i < 2)
				nx = cx + dx[i];
			else
				nx = cx  * dx[i];

			if (!c[nx] && nx >= 0 && nx <= 1000001 ) {
				q.push(nx);
				c[nx] = c[cx] + 1;
			}
		}
	}
}
int main() {
	cin >> N >> K;
	bfs(N);
	cout << c[K]-1 << endl;

	return 0;
}