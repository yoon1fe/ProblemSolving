#include <iostream>
#include <algorithm>
using namespace std;

int R, C, T;
int m[50][50] = { 0, };
int dy[4] = { 0, 0, 1, -1 };
int dx[4] = { 1, -1, 0, 0 };
pair<int, int> uCleaner;
pair<int, int> dCleaner;

bool isIn(int y, int x) {
	if (0 <= y && y < R && 0 <= x && x < C) return true;
	else return false;
}

void dust() {
	int nm[50][50] = { 0, };
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (m[i][j] > 0) {
				int nextCnt = 0;
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if (isIn(ny, nx) && m[ny][nx] != -1 && m[i][j] / 5 > 0) {	//4방향 봐주면서 체크
						nextCnt++;
						nm[ny][nx] += m[i][j] / 5;
					}
				}
				nm[i][j] += -((m[i][j] / 5) * nextCnt);
			}
		}
	}

	for (int i = 0; i < R; i++)
		for (int j = 0; j < C; j++)
			m[i][j] += nm[i][j];
}

void airCleaner() {
	//위
	for (int i = uCleaner.first - 1; i > 0; i--)
		m[i][0] = m[i - 1][0];
	for (int i = 0; i < C - 1; i++)
		m[0][i] = m[0][i + 1];
	for (int i = 0; i < uCleaner.first; i++)
		m[i][C - 1] = m[i + 1][C - 1];
	for (int i = C - 1; i > 1; i--)
		m[uCleaner.first][i] = m[uCleaner.first][i - 1];
	//아래
	for (int i = dCleaner.first + 1; i < R - 1; i++)
		m[i][0] = m[i + 1][0];
	for (int i = 0; i < C - 1; i++)
		m[R - 1][i] = m[R - 1][i + 1];
	for (int i = R - 1; i > dCleaner.first - 1; i--)
		m[i][C - 1] = m[i - 1][C - 1];
	for (int i = C - 1; i > 1; i--)
		m[dCleaner.first][i] = m[dCleaner.first][i - 1];

	m[uCleaner.first][uCleaner.second + 1] = 0;
	m[dCleaner.first][dCleaner.second + 1] = 0;
}

int main() {
	cin >> R >> C >> T;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> m[i][j];
			if (m[i][j] == -1)
				dCleaner = { i, j };
		}
	}
	uCleaner = { dCleaner.first - 1, dCleaner.second };

	for (int i = 0; i < T; i++) {
		dust();
		airCleaner();
	}

	int ans = 0;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (!m[i][j]) continue;
			ans += m[i][j];
		}
	}

	cout << ans + 2;	//공기청정기 -1 두개

	return 0;
}