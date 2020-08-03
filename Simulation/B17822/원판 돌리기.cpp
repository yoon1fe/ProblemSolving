#include <iostream>
#include <algorithm>
#include <deque>
#include <queue>

using namespace std;

int N, M, T;
int x, d, k;
int deleteNum = 0;
int sum = 0;
deque<int> circles[51];


void solve(int x, int d, int k) {
	for (int i = 1; i <= N; i++){
		int idx = i * x;//원판 돌리기
		if (idx > N)
			break;

		if (d == 0) {
			for (int j = 0; j < k; j++) {
				circles[idx].push_front(circles[idx][circles[idx].size()-1]);
				circles[idx].pop_back();
			}
			
		}
		else {
			for (int j = 0; j < k; j++) {
				circles[idx].push_back(circles[idx][0]);
				circles[idx].pop_front();
			}

		}
	}

	bool check[51][51] = { 0, };
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < M; j++) {
			
			int curN = circles[i][j];
			if (curN == 0)
				continue;
			if (circles[i][(j + M + 1) % M] == curN) {
				check[i][j] = true;
				check[i][(j + M + 1) % M] = true;
			}
			if (circles[i][(j + M - 1) % M] == curN) {
				check[i][j] = true;
				check[i][(j + M - 1) % M] = true;
			}
			if (i == N)
				continue;
			if (circles[i+1][j] == curN) {
				check[i][j] = true;
				check[i+1][j] = true;
			}
		}
	}
	bool flag = false;
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < M; j++) {
			if (check[i][j]) {
				flag = true;
				sum -= circles[i][j];
				circles[i][j] = 0;
				deleteNum++;
			}
		}
	}

	if (!flag) {
		double avg = (double)sum / (double)((N * M) - deleteNum);
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (circles[i][j] != 0) {
					if ((double)circles[i][j] > avg) {
						circles[i][j]--;
						sum--;
					}
					else if ((double)circles[i][j] < avg) {
						circles[i][j]++;
						sum++;
					}
				}
			}
		}
	}

	
}

int main() {
	cin >> N >> M >> T;

	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < M; j++) {
			int a;
			cin >> a;
			circles[i].push_back(a);
			sum += a;
		}
	}

	for (int i = 0; i < T; i++) {
		cin >> x >> d >> k;
		solve(x, d, k);
	}


	cout << sum;
	return 0;
}