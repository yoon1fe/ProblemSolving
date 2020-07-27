#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, M;
int m[505][505] = { 0, };
int ans = 0;

bool isIn(int x, int y) {
	if (0 <= x && x < N && 0 <= y && y < M) return true;
	else return false;
}

void solve(int x, int y) {
	int maxVal = 0;

	for (int i = 0; i < 19; i++) {
		switch (i) {
		case 0:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x][y + 2] + m[x][y + 3]);
			break;
		case 1:
			maxVal = max(maxVal, m[x][y] + m[x + 1][y] + m[x + 2][y] + m[x + 3][y]);

			break;
		case 2:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x + 1][y] + m[x + 1][y + 1]);

			break;
		case 3:
			maxVal = max(maxVal, m[x][y] + m[x + 1][y] + m[x + 2][y] + m[x + 2][y + 1]);

			break;
		case 4:
			maxVal = max(maxVal, m[x][y] + m[x + 1][y] + m[x + 2][y] + m[x + 2][y - 1]);

			break;
		case 5:
			maxVal = max(maxVal, m[x][y] + m[x + 1][y] + m[x + 2][y] + m[x][y + 1]);

			break;
		case 6:
			maxVal = max(maxVal, m[x][y] + m[x + 1][y] + m[x + 2][y] + m[x][y - 1]);

			break;
		case 7:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x][y + 2] + m[x - 1][y + 2]);

			break;
		case 8:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x][y + 2] + m[x + 1][y]);

			break;
		case 9:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x][y + 2] + m[x + 1][y + 2]);

			break;
		case 10:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x][y + 2] + m[x - 1][y]);

			break;
		case 11:
			maxVal = max(maxVal, m[x][y] + m[x + 1][y] + m[x + 1][y + 1] + m[x + 2][y + 1]);

			break;
		case 12:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x - 1][y + 1] + m[x - 1][y + 2]);

			break;
		case 13:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x - 1][y + 1] + m[x + 1][y]);

			break;
		case 14:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x + 1][y + 1] + m[x + 1][y + 2]);

			break;
		case 15:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x][y + 2] + m[x + 1][y + 1]);

			break;
		case 16:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x - 1][y + 1] + m[x + 1][y + 1]);

			break;
		case 17:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x][y + 2] + m[x - 1][y + 1]);

			break;
		case 18:
			maxVal = max(maxVal, m[x][y] + m[x][y + 1] + m[x - 1][y] + m[x + 1][y]);

			break;

		}
	}

	ans = max(ans, maxVal);
}


int main() {
	cin >> N >> M;

	
	for (int i = 1; i < N + 1; i++)
		for (int j = 1; j < M + 1; j++)
			cin >> m[i][j];



	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < M + 1; j++) {
			solve(i, j);
		}
	}

	cout << ans;

	return 0;
}