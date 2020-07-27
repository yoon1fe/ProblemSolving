#include <iostream>
#include <algorithm>

using namespace std;

int N, M;
bool map[50][50];

int solve(int y, int x) {
	int cnt1 = 0;
	int cnt2 = 0;

	bool mark = true;
	for (int i = y; i < y + 8; i++) {
		for (int j = x; j < x + 8; j++) {
			if (map[i][j] != mark)
				cnt1++;
			mark = !mark;
		}
		mark = !mark;
	}
	mark = false;
	for (int i = y; i < y + 8; i++) {
		for (int j = x; j < x + 8; j++) {
			if (map[i][j] != mark)
				cnt2++;
			mark = !mark;
		}
		mark = !mark;
	}

	return min(cnt1, cnt2);
}

int main() {
	int arr[10] = { 0, };
	arr[100] = { 0, };
	arr[9] = 1;
	cout << arr[19];
	/*cin >> N >> M;
	int minVal = 99;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			char t;
			cin >> t;
			if (t == 'B')
				map[i][j] = 1;
			else map[i][j] = 0;
		}
	}

	for (int i = 0; i <= N - 8; i++)
		for (int j = 0; j <= M - 8; j++)
			minVal = min(solve(i, j), minVal);

	cout << minVal;*/
	return 0;
}