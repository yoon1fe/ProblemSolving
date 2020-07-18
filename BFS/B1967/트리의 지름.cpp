#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <cstring>
using namespace std;

int n;
vector<pair<int, int>> v[10001];
bool c[10001] = { 0, };

int bfs(int s, int length) {
	vector<int> ans;
	queue<pair<int, int>> q;
	q.push(make_pair(s, length));
	c[s] = true;

	while (!q.empty()) {
		int cx = q.front().first;
		int clen = q.front().second;
		q.pop();
		if (cx != s)
			ans.push_back(clen);

		for (int i = 0; i < v[cx].size(); i++) {
			int nx = v[cx].at(i).first;
			int nlen = v[cx].at(i).second;

			if (!c[nx]) {
				q.push(make_pair(nx, nlen + clen));
				c[cx] = true;
			}
		}
	}

	sort(ans.begin(), ans.end());

	return ans.at(ans.size() - 1);
}


int main() {
	cin >> n;
	vector<int> ans;
	int a, b, l;
	for (int i = 0; i < n - 1; i++) {
		cin >> a >> b >> l;
		v[a].push_back(make_pair(b, l));
		v[b].push_back(make_pair(a, l));
	}

	for (int i = n / 2 + 1; i <= n; i++) {
		ans.push_back(bfs(i, 0));
		memset(c, false, sizeof(c));
	}

	cout <<*max_element(ans.begin(), ans.end());

	return 0;
}