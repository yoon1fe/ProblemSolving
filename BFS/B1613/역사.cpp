//BFS로 풀면 시간초과가 뜬다. 플로이드 와샬 알고리즘 이용

#include <iostream>

using namespace std;

int n, k, s;
int start, dest;
int d[401][401];

void floyd() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			for (int k = 1; k <= n; k++) {
				if (i == j || j == k || k == i) continue;

				if (d[j][k] == 0) {
					if (d[j][i] == 1 && d[i][k] == 1)
						d[j][k] = 1;
					if (d[j][i] == -1 && d[i][k] == -1)
						d[j][k] = -1;
				}
			}
		}
	}
}
int main() {
	cin >> n >> k;
	int a, b;

	for (int i = 0; i < k; i++) {
		cin >> a >> b;
		d[a][b] = -1;
		d[b][a] = 1;
	}

	floyd();

	cin >> s;

	for (int i = 0; i < s; i++) {
		cin >> start >> dest;
		cout << d[start][dest] << "\n";
	}

	return 0;
}


//#include <iostream>
//#include <algorithm>
//#include <vector>
//#include <queue>
//#include <cstring>
//using namespace std;
//
//int n, k, s;
//int start, dest;
//vector<int> v[401];
//vector<int> r[401];
//bool c[401] = { 0, };
//
//int bfs(int s, vector<int> v[]) {
//	queue<int> q;
//	q.push(s);
//	c[s] = true;
//
//	while (!q.empty()) {
//		int cur = q.front();
//		q.pop();
//		if (cur == dest)
//			return 1;
//
//		for (int i = 0; i < v[cur].size(); i++) {
//			int next = v[cur].at(i);
//			if (!c[next]) {
//				q.push(next);
//				c[next] = true;
//			}
//		}
//	}
//
//	return -1;
//}
//int main() {
//	int a, b, ans1, ans2;
//	cin >> n >> k;
//	for (int i = 0; i < k; i++) {
//		cin >> a >> b;
//		v[a].push_back(b);
//		r[b].push_back(a);
//	}
//
//	cin >> s;
//
//	for (int i = 0; i < s; i++) {
//		cin >> start >> dest;
//		ans1 = bfs(start, v);
//		ans2 = bfs(start, r);
//		if (ans1 == ans2)
//			cout << 0 << "\n";
//		else 
//			(ans1 > ans2) ? (cout << -1 << "\n") : (cout << 1 << "\n");
//
//		memset(c, false, sizeof(c));
//	}
//
//	return 0;
//}