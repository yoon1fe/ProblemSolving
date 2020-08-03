#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int N, M, virusNum = 0;
vector<pair<pair<int, int>, bool>> virus;
int map[50][50] = { 0, };
int dy[4] = { 0, 0, 1, -1 };
int dx[4] = { 1, -1, 0, 0 };
int emptyNum = 0;
vector<int> ans;

bool isIn(int y, int x) {
	if (0 <= y && y < N && 0 <= x && x < N) return true;
	else return false;
}

int bfs() {
	if (emptyNum == 0)
		return 0;		//ó������ �� ���� ���� ���
	int temp = 0;		
	int plusNum = 0;
	int c[50][50] = { 0, };

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] == 1)
				c[i][j] = -1;		//���� -1
		}
	}

	queue<pair<int, int>> q;
	for (int i = 0; i < virus.size(); i++) {
		if (virus[i].second) {
			c[virus[i].first.first][virus[i].first.second] = 1;			//Ȱ��ȭ�� ���̷���
			q.push({ virus[i].first.first, virus[i].first.second });
		}
		else
			c[virus[i].first.first][virus[i].first.second] = -2;		//��Ȱ��ȭ�� ���̷���
	}

	while (!q.empty()) {
		int cy = q.front().first;
		int cx = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];

			if (!isIn(ny, nx) || map[ny][nx] == 1 || c[ny][nx] > 0) continue;
			
			if(c[ny][nx] != -2)	//����� ������Ų ��쿡�� ++
				plusNum++;

			c[ny][nx] = c[cy][cx] + 1;

			if (plusNum == emptyNum)
				return c[ny][nx] - 1;		//����� ���� ��� ������Ų ���


			q.push({ ny, nx });
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!c[i][j])
				return -1;				//�� �������״µ� ����� �ִ� ���
		}
	}	
}

void setVirus(int cnt, int idx) {
	if (cnt == M) {
		ans.push_back(bfs());
		return;
	}

	for (int i = idx + 1; i < virus.size(); i++) {
		if (!virus[i].second) {
			virus[i].second = true;
			setVirus(cnt + 1, i);
			virus[i].second = false;
		}
	}
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
			if (map[i][j] == 2) {
				virus.push_back({ { i, j }, false });
			}
			else if (map[i][j] == 0)
				emptyNum++;
		}
	}

	
	for (int i = 0; i < virus.size(); i++) {
		if (!virus[i].second) {
			virus[i].second = true;
			setVirus(1, i);
			virus[i].second = false;
		}
	}

	sort(ans.begin(), ans.end());		//��� ��� -1�� ��츦 ����� �ϹǷ� �� ��ʸ��� ������� ����
	int answer = -1;
	for (int i = 0; i < ans.size(); i++) {
		if (ans[i] > answer) {
			answer = ans[i];	//-1�� �ƴ� ��찡 �������� ����� ����
			break;
		}
	}

	cout << answer;
	return 0;
}