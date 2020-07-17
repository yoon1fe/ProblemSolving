#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N, M;
vector<int> v[10001];

int bfs(int s) {		//각 컴퓨터에서 해킹할수 있는 컴퓨터 수 리턴
	queue<int> q;
	bool c[10001] = { 0, };
	q.push(s);
	c[s] = true;
	int cnt = 1;

	while (!q.empty()) {
		int cx = q.front();
		q.pop();

		for (int i = 0; i < v[cx].size(); i++) {
			int nx = v[cx].at(i);
			if (!c[nx]) {
				q.push(nx);
				c[nx] = true;
				cnt++;
			}
		}
	}

	return cnt;
}

int main() {
	cin >> N >> M;
	int a, b, t;
	vector<int> ans;
	int max = 0;

	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		v[b].push_back(a);
	}

	for (int i = 1; i <= N; i++) {
		t = bfs(i);
		if (t > max) {
			max = t;
			ans.erase(ans.begin(), ans.end());
			ans.push_back(i);
		}

		else if (t == max)
			ans.push_back(i);
	}
	for (int i = 0; i < ans.size(); i++)
		cout << ans.at(i) << ' ';

	return 0;
}