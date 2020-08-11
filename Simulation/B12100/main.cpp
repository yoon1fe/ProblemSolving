#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;


int N;

int board[20][20] = { 0, };
int ans = -1;
vector<int> order;


int move() {
	int temp[20][20] = { 0, };
	memcpy(temp, board, sizeof(temp));
	int maxVal = -1;

	for (int i = 0; i < order.size(); i++) {
		int newB[20][20] = { 0, };
		switch (order[i]) {
		case 1:
			for (int x = 0; x < N; x++) {
				queue<int> q;
				
				for (int y = 0; y < N; y++)
					if (temp[y][x])
						q.push(temp[y][x]);

				int y = 0;
				while (!q.empty()) {
					int curN = q.front();
					int nextN = 0;
					q.pop();
					if (!q.empty()) {
						nextN = q.front();
					}

					if (curN == nextN) {
						newB[y++][x] = curN + nextN;
						q.pop();
					}
					else {
						newB[y++][x] = curN;
					}
				}
			}


			break;

		case 2:
			for (int x = 0; x < N; x++) {
				queue<int> q;

				for (int y = N - 1; y >= 0; y--)
					if (temp[y][x])
						q.push(temp[y][x]);

				int y = N - 1;
				while (!q.empty()) {
					int curN = q.front();
					int nextN = 0;
					q.pop();
					if (!q.empty()) {
						nextN = q.front();
					}

					if (curN == nextN) {
						newB[y--][x] = curN + nextN;
						q.pop();
					}
					else {
						newB[y--][x] = curN;
					}
				}
			}

			break;

		case 3:
			for (int y = 0; y < N; y++) {
				queue<int> q;

				for (int x = 0; x < N; x++)
					if (temp[y][x])
						q.push(temp[y][x]);

				int x = 0;
				while (!q.empty()) {
					int curN = q.front();
					int nextN = 0;
					q.pop();
					if (!q.empty()) {
						nextN = q.front();
					}

					if (curN == nextN) {
						newB[y][x++] = curN + nextN;
						q.pop();
					}
					else {
						newB[y][x++] = curN;
					}
				}
			}

			break;

		case 4:
			for (int y = 0; y < N; y++) {
				queue<int> q;

				for (int x = N - 1; x >= 0; x--)
					if (temp[y][x])
						q.push(temp[y][x]);

				int x = N - 1;
				while (!q.empty()) {
					int curN = q.front();
					int nextN = 0;
					q.pop();
					if (!q.empty()) {
						nextN = q.front();
					}

					if (curN == nextN) {
						newB[y][x--] = curN + nextN;
						q.pop();
					}
					else {
						newB[y][x--] = curN;
					}
				}
			}

			break;
		}

		
		memcpy(temp, newB, sizeof(temp));
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			maxVal = max(maxVal, temp[i][j]);
		}
	}
	return maxVal;
}

void makeOrder(int cnt) {
	if (cnt == 5) {
		ans = max(ans, move());

		return;
	}

	for (int i = 1; i < 5; i++) {
		order.push_back(i);
		makeOrder(cnt + 1);
		order.pop_back();
	}
}
int main() {
	cin >> N;

	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			cin >> board[i][j];


	for (int i = 1; i < 5; i++) {
		order.push_back(i);
		makeOrder(1);
		order.pop_back();
	}


	cout << ans;
	return 0;
}