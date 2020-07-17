#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

vector<int> graph[1000];

bool Bcheck[1001];
bool Dcheck[1001];

void dfs(int s) {
	if (Dcheck[s])
		return;

	Dcheck[s] = true;
	cout << s << ' ';

	for (int i = 0; i < graph[s].size(); i++) {
		int next = graph[s].at(i);
		dfs(next);
	}
}

void bfs(int s) {
	queue<int> q;
	q.push(s);
	Bcheck[s] = true;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		cout << cur << ' ';
		for (int i = 0; i < graph[cur].size(); i++) {
			int next = graph[cur].at(i);
			if (!Bcheck[next]) {
				q.push(next);
				Bcheck[next] = true;
			}
		}
	}
}

int main() {
	int N, M, start;
	int u, v;
	cin >> N >> M >> start;


	for (int i = 0; i < M; i++) {
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	for (int i = 1; i <= N; i++)
		sort(graph[i].begin(), graph[i].end());

	dfs(start);
	cout << endl;

	bfs(start);
	cout << endl;
	return 0;
}