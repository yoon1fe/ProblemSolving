#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int m[100][100] = { 0, };
int r, c, k;
int rNum = 3, cNum = 3;

bool compare(pair<int, int> a, pair<int, int> b) {
	if (a.second == b.second)
		return a.first < b.first;
	return a.second < b.second;
}

int solve() {
	int cnt = 0;
	while (++cnt) {
		if (cnt > 101)
			return -1;

		if (m[r - 1][c - 1] == k)
			return cnt - 1;

		if (rNum >= cNum) {
			int tempcNum = cNum;
			cNum = 0;
			for (int i = 0; i < rNum; i++) {
				int temp[101] = { 0, };
				vector<pair<int, int>> line;

				for (int j = 0; j < tempcNum; j++) {
					temp[m[i][j]]++;
					m[i][j] = 0;
				}
				for (int k = 1; k < 101; k++) {
					if (temp[k]) {
						line.push_back({ k, temp[k] });
					}
				}
				sort(line.begin(), line.end(), compare);
				for (int k = 0; k < line.size(); k++) {
					int j = k * 2;
					m[i][j] = line[k].first;
					m[i][j + 1] = line[k].second;
				}
				cNum = max(cNum, (int)line.size() * 2);
			}
		}
		else {
			int temprNum = rNum;
			rNum = 0;
			for (int i = 0; i < cNum; i++) {
				int temp[101] = { 0, };
				vector<pair<int, int>> line;

				for (int j = 0; j < temprNum; j++) {
					temp[m[j][i]]++;
					m[j][i] = 0;
				}
				for (int k = 1; k < 101; k++) {
					if (temp[k]) {
						line.push_back({ k, temp[k] });
					}
				}
				sort(line.begin(), line.end(), compare);
				for (int k = 0; k < line.size(); k++) {
					int j = k * 2;
					m[j][i] = line[k].first;
					m[j+1][i] = line[k].second;
				}
				rNum = max(rNum, (int)line.size() * 2);
			}
		}
	}
}

int main() {
	cin >> r >> c >> k;	//m[r-1][c-1] ±¸ÇÏ±â

	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			cin >> m[i][j];

	cout << solve();

	return 0;
}