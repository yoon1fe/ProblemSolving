#include <iostream>
#include <algorithm>

using namespace std;


int N, M, H;
int lineCnt = 0;
bool ladder[31][11] = { 0, };
int ans = 0;

int moveLadder() {
	int curLine;

	for (int i = 1; i <= N; i++) {
		curLine = i;
		for (int j = 1; j <= H; j++) {
			if (ladder[j][curLine - 1])
				curLine--;
			else if (ladder[j][curLine])
				curLine++;
		}

		if (i != curLine)
			return -1;
	}

	return lineCnt;
}

void makeLine(int cnt, int ni, int nj) {
	if (cnt == lineCnt) {
		int temp;
		temp = moveLadder();
		if (temp == lineCnt)
			ans = temp;
		return;
	}

	for (int i = ni; i <= H; i++) {
		for (int j = 1; j <= N; j++) {
			if (ladder[i][j - 1]) continue;
			if (ladder[i][j]) continue;
			if (ladder[i][j + 1]) continue;
			ladder[i][j] = true;
			makeLine(cnt + 1, i, j);
			ladder[i][j] = false;
		}
	}
}
int main() {
	int a, b;
	cin >> N >> M >> H;

	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		ladder[a][b] = true;
	}
	//선 하나도 안 놓았을 때 검사
	ans = moveLadder();
	if (ans == lineCnt) {
		cout << ans;
		return 0;
	}

	lineCnt++;
	//선 한개 놓을 경우
	for (int i = 1; i <= H; i++) {
		for (int j = 1; j <= N; j++) {
			if (ladder[i][j - 1]) continue;
			if (ladder[i][j]) continue;
			if (ladder[i][j + 1]) continue;
			ladder[i][j] = true;
			ans = moveLadder();
			if (ans == lineCnt) {
				cout << ans;
				return 0;
			}
			ladder[i][j] = false;
		}
	}


	lineCnt++;
	//선 두개 놓을 경우
	for (int i = 1; i <= H; i++) {
		for (int j = 1; j <= N; j++) {
			if (ladder[i][j - 1]) continue;
			if (ladder[i][j]) continue;
			if (ladder[i][j + 1]) continue;
			ladder[i][j] = true;
			makeLine(1, i, j);
			ladder[i][j] = false;
		}
	}

	lineCnt++;
	//선 세개 놓을 경우
	for (int i = 1; i <= H; i++) {
		for (int j = 1; j <= N; j++) {
			if (ladder[i][j - 1]) continue;
			if (ladder[i][j]) continue;
			if (ladder[i][j + 1]) continue;
			ladder[i][j] = true;
			makeLine(1, i, j);
			ladder[i][j] = false;
		}
	}


	cout << ans;

	return 0;
}