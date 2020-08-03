#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
	vector<pair<int, int>> v;
	int N;
	int x, y;
	cin >> N;
	vector<int> ans;

	for (int i = 0; i < N; i++) {
		cin >> x >> y;
		v.push_back(make_pair(x, y));
	}

	for (int i = 0; i < N; i++) {
		int w, h;
		int cnt = 1;
		w = v.at(i).first;
		h = v.at(i).second;

		for (int j = 0; j < N; j++) {
			if (i == j)
				continue;
			if (w < v.at(j).first && h < v.at(j).second)
				cnt++;
		}

		ans.push_back(cnt);
	}

	for (int i = 0; i < N; i++)
		cout << ans.at(i) << ' ';

	return 0;
}