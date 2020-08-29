#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, M, K;	//땅 크기, 나무 개수, K년 후 구하기
int m[11][11];
int nutri[11][11] = { 0, };
int dy[8] = { 1, 1, 1, 0, 0, -1, -1, -1 };
int dx[8] = { -1, 0, 1, 1, -1, -1, 0, 1 };
vector<int> trees[11][11];

bool isIn(int y, int x) {
	if (1 <= y && y <= N && 1 <= x && x <= N) return true;
	else return false;
}

void solve() {
	//봄
	for (int y = 1; y <= N; y++) {
		for (int x = 1; x <= N; x++) {
			if (trees[y][x].empty()) continue;

			int dead = 0;
			vector<int> temp;
			if (trees[y][x].size() > 1)
				sort(trees[y][x].begin(), trees[y][x].end());

			for (int i = 0; i < trees[y][x].size(); i++) {
				int age = trees[y][x][i];
				if (m[y][x] >= age) {
					m[y][x] -= age;
					temp.push_back(age + 1);
				}
				else
					dead += age / 2;
			}

			trees[y][x].clear();
			for (int i = 0; i < temp.size(); i++)
				trees[y][x].push_back(temp[i]);

			//여름
			m[y][x] += dead;
		}
	}

	/*for (int i = 0; i < trees.size(); i++) {
		if (m[trees[i].y][trees[i].x] - trees[i].age >= 0) {
			m[trees[i].y][trees[i].x] -= trees[i].age;
			trees[i].age++;
		}
		else
			trees[i].isDead = true;
	}*/


	//가을
	for (int y = 1; y <= N; y++) {
		for (int x = 1; x <= N; x++) {
			if (trees[y][x].empty()) continue;

			for (int i = 0; i < trees[y][x].size(); i++) {
				int age = trees[y][x][i];

				if (age % 5 == 0) {
					for (int j = 0; j < 8; j++) {
						int ny = y + dy[j];
						int nx = x + dx[j];

						if (isIn(ny, nx))
							trees[ny][nx].push_back(1);
					}
				}
			}
		}
	}
	//int size = trees.size() - 1;
	//for (int i = 0; i <= size; i++) {
	//	if (trees[trees.size() - 1 - i].age % 5 != 0) continue;

	//	for (int j = 0; j < 8; j++) {
	//		int ny = trees[trees.size() - 1 - i].y + dy[j];
	//		int nx = trees[trees.size() - 1 - i].x + dx[j];

	//		if (isIn(ny, nx))
	//			trees.insert(trees.begin(), { ny, nx, 1, 0 });
	//			//trees.push_front({ ny, nx, 1, 0 });
	//	}
	//}
	//겨울
	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= N; j++)
			m[i][j] += nutri[i][j];
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int a, b, c;
	cin >> N >> M >> K;


	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> nutri[i][j];
			m[i][j] = 5;
		}
	}

	for (int i = 0; i < M; i++) {
		cin >> a >> b >> c;
		trees[a][b].push_back(c);
	}

	for (int i = 0; i < K; i++) {
		solve();
	}

	int ans = 0;

	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= N; j++)
			ans += trees[i][j].size();

	cout << ans;


	return 0;
}