#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef struct info {
	int camera;
	int y;
	int x;
}info;
int N, M;
int cameraCnt = 0;
vector <info> cameras;
vector<int> order;
int m[8][8] = { 0, };
int t[8][8] = { 0, };
int camera[6] = { 0, };
int dir[2] = { 1, -1 };
int minVal = 9999;
bool isIn(int y, int x) {
	if (0 <= y && y < N && 0 <= x && x < M) return true;
	else return false;
}

void surveillance(int camera, int n, int y, int x) {
	switch(camera) {
		case 1:
			if (n == 0) {
				int ny = y;
				int nx = x + dir[0];

				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[0];
				}
			}

			else if (n == 1) {
				int ny = y + dir[0];
				int nx = x;

				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[0];
				}
			}
			else if (n == 2) {
				int ny = y;
				int nx = x + dir[1];

				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[1];
				}
			}
			else if (n == 3) {
				int ny = y + dir[1];
				int nx = x;

				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[1];
				}
			}
			break;

		case 2:
			if (n == 0) {
				int ny = y;
				int nx = x + dir[0];
				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[0];
				}
				nx = x + dir[1];
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[1];
				}
			}
			else if (n == 1) {
				int ny = y + dir[0];
				int nx = x;
				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[0];
				}
				ny = y + dir[1];
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[1];
				}
			}
			break;

		case 3:
			if (n == 0) {
				int ny = y;
				int nx = x + dir[0];
				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[0];
				}
				ny = y + dir[1];
				nx = x;
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[1];
				} 
			}
			else if (n == 1) {
				int ny = y;
				int nx = x + dir[0];
				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[0];
				}
				ny = y + dir[0];
				nx = x;
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[0];
				} 
			}
			else if (n == 2) {
				int ny = y;
				int nx = x + dir[1];
				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[1];
				}
				ny = y + dir[0];
				nx = x;
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[0];
				}
			}
			else if (n == 3) {
				int ny = y;
				int nx = x + dir[1];
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[1];
				}
				ny = y + dir[1];
				nx = x;
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[1];
				}
			}
			break;

		case 4:
			if (n == 0) {
				int ny = y;
				int nx = x + dir[0];
				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[0];
				}
				ny = y + dir[1];
				nx = x;
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[1];
				}
				ny = y;
				nx = x + dir[1];
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[1];
				}
			}
			else if (n == 1) {
				int ny = y;
				int nx = x + dir[0];
				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[0];
				}
				ny = y + dir[1];
				nx = x;
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[1];
				}
				ny = y + dir[0];
				nx = x;
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[0];
				}
			}
			else if (n == 2) {
				int ny = y;
				int nx = x + dir[0];
				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[0];
				}
				ny = y + dir[0];
				nx = x;
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[0];
				}
				ny = y;
				nx = x + dir[1];
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[1];
				}
			}
			else if (n == 3) {
				int ny = y + dir[1];
				int nx = x;
				while (t[ny][nx] !=  6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[1];
				}
				ny = y + dir[0];
				nx = x;
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					ny += dir[0];
				}
				ny = y;
				nx = x + dir[1];
				while (t[ny][nx] != 6 && isIn(ny, nx)) {
					t[ny][nx] = 7;
					nx += dir[1];
				}
			}
			break; 

		case 5:
			int ny = y + dir[1];
			int nx = x;
			while (m[ny][nx] != 6 && isIn(ny, nx)) {
				m[ny][nx] = 7;
				ny += dir[1];
			}
			ny = y + dir[0];
			nx = x;
			while (m[ny][nx] != 6 && isIn(ny, nx)) {
				m[ny][nx] = 7;
				ny += dir[0];
			}
			ny = y;
			nx = x + dir[1];
			while (m[ny][nx] != 6 && isIn(ny, nx)) {
				m[ny][nx] = 7;
				nx += dir[1];
			}
			ny = y;
			nx = x + dir[0];
			while (m[ny][nx] != 6 && isIn(ny, nx)) {
				m[ny][nx] = 7;
				nx += dir[0];
			}
			break;
	}
}

void solve() {
	int tVal = 0;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			t[i][j] = m[i][j];


	for (int i = 0; i < cameras.size(); i++) {
		if (cameras.at(i).camera == 5) continue;
		surveillance(cameras.at(i).camera, order.at(i), cameras.at(i).y, cameras.at(i).x);
	}
		

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (t[i][j] == 0)
				tVal++;
		}
	}


	if (minVal > tVal)
		minVal = tVal;
}

void makePerm(int cnt) {
	if (cnt == cameras.size()) {
		solve();

		return;
	}

	int size = 0;

	if (cameras.at(cnt).camera == 2)
		size = 2;
	else size = 4;


	for (int i = 0; i < size; i++) {
		order.push_back(i);
		makePerm(cnt+1);
		order.pop_back();
	}
}
int main() {
	cin >> N >> M;
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> m[i][j];
			if (m[i][j] != 6 && m[i][j] != 0) {
				cameras.push_back({ m[i][j], i, j });
				camera[m[i][j]]++;
			}
		}
	}

	for (int i = 0; i < cameras.size(); i++) {
		if (cameras.at(i).camera == 5) {
			surveillance(5, 0, cameras.at(i).y, cameras.at(i).x);
		}
	}
	int size = 0;

	if (!cameras.size()) {
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!m[i][j])
					ans++;
			}
		}

		cout << ans;
		return 0;
	}


	if (cameras.at(0).camera == 2)
		size = 2;
	else size = 4;

	for (int i = 0; i < size; i++) {
		order.push_back(i);
		makePerm(1);
		order.pop_back();
	}

	cout << minVal;
	return 0;
}