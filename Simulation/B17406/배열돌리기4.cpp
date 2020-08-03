#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, M, K;
int m[51][51] = { 0, };
int r, c, s;
int tempMap[51][51] = { 0, };
int minAns = 99999;
int sum = 0;
bool check[7] = { 0, };
vector<int> order;	//내가 만드는 연산 순서
vector<pair<int, pair<int, int>>> v;	//연산 저장할 벡터

void rotate(int cnt) {
	int r = v.at(cnt - 1).first, c = v.at(cnt - 1).second.first, s = v.at(cnt - 1).second.second;
	
	//배열 돌리기
	for (int n = 0; n < s; n++) {
		int temp = tempMap[r - s + n][c - s + n];

		for (int i = r - s + n; i < r + s - n; i++)
			tempMap[i][c - s + n] = tempMap[i + 1][c - s + n];

		for (int i = c - s + n; i < c + s - n; i++)
			tempMap[r + s - n][i] = tempMap[r + s - n][i + 1];

		for (int i = r + s - n; i > r - s + n; i--)
			tempMap[i][c + s - n] = tempMap[i - 1][c + s - n];

		for (int i = c + s - n; i > c - s + n + 1; i--)
			tempMap[r - s + n][i] = tempMap[r - s + n][i - 1];

		tempMap[r - s + n][c - s + n + 1] = temp;
	}
}

void dfs(int cnt) {
	if (cnt == K) {	//순서 다 정했으면 rotate 하자
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				tempMap[i][j] = m[i][j];

		for (int i = 0; i < order.size(); i++)
			rotate(order.at(i));

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				sum += tempMap[i][j];		//배열의 값 구하기

			minAns = min(minAns, sum);
			sum = 0;
		}
	}

	for (int i = 1; i <= v.size(); i++) {	//백트래킹으로 순서 만들기
		if (check[i]) continue;
		check[i] = true;

		order.push_back(i);
		dfs(cnt + 1);
		order.pop_back();
		check[i] = false;
	}
}

int main() {
	cin >> N >> M >> K;

	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= M; j++)
			cin >> m[i][j];

	for (int i = 0; i < K; i++) {
		cin >> r >> c >> s;
		v.push_back({ r, {c, s} });
	}

	dfs(0);

	cout << minAns;

	return 0;
}