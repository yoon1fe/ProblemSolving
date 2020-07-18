#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N;
int s, d;
int M;
vector<int>* v;
int c[101] = { 0, };

int bfs(int s) {
	queue<int> q;
	q.push(s);
	c[s] = true;
	int cnt = 0;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur].at(i);
			

			if (c[next] == 0) {
				q.push(next);
				c[next] = c[cur] + 1;
			}
			if (next == d)
				return c[next] - 1;
		}
	}

	return -1;
}
int main() {
	cin >> N;
	cin >> s >> d;
	cin >> M;
	int a, b;

	v = new vector<int>[N+1];

	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	
	cout << bfs(s);

	delete[] v;
	return 0;
}