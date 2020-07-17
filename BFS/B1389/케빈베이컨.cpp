#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;
int N, M;
vector<int> v[101];

int bfs(int s) {
	int c[101];
	int sum = 0;
	fill(c, c + 101, -1);

	queue<int> q;
	q.push(s);
	c[s] = 0;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur].at(i);

			if (c[next] == -1) {
				q.push(next);
				c[next] = c[cur] + 1;
			}
		}
	}

	for (int i = 1; i <= N; i++)
		sum += c[i];

	return sum;
}

bool compare(pair<int, int> a, pair<int, int> b) {
	return a.second < b.second;
}

int main() {
	int a, b;
	vector <pair<int, int>> ans;
	int t;
	cin >> N >> M;
	
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	for (int i = 1; i <= N; i++) {
		t = bfs(i);
		ans.push_back(make_pair(i, t));
	}

	sort(ans.begin(), ans.end(), compare);

	cout << ans.at(0).first;

	return 0;
}