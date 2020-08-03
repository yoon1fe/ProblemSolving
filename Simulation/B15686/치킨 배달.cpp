#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N, M, t;
int chickenLen = 0;
int ans = 9999;
vector<pair<int, int>> house;
vector<pair<pair<int, int>, bool>> chickenH;


void closeChicken(int idx, int cnt) {
	if (cnt == chickenH.size() - 1 - M) {
		for (int i = 0; i < house.size(); i++) {
			int tempLen = 9999;

			for (int j = 1; j < chickenH.size(); j++)
				if (chickenH.at(j).second)
					tempLen = min(tempLen, abs(house.at(i).first - chickenH.at(j).first.first) + abs(house.at(i).second - chickenH.at(j).first.second));

			chickenLen += tempLen;
		}
		ans = min(ans, chickenLen);
		chickenLen = 0;

		return;
	}

	for (int i = idx; i < chickenH.size(); i++) {
		if (chickenH.at(i).second) {
			chickenH.at(i).second = false;
			closeChicken(i, cnt + 1);
			chickenH.at(i).second = true;
		}
	}

}
int main() {
	cin >> N >> M;
	chickenH.push_back({ {0, 0}, false });
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> t;
			if (t == 1)
				house.push_back({ i, j });

			else if (t == 2)
				chickenH.push_back({ {i, j}, true });
		}
	}

	if (chickenH.size() - 1 - M == 0)
		closeChicken(1, 0);

	else {
		for (int i = 1; i < chickenH.size(); i++) {
			chickenH.at(i).second = false;
			closeChicken(1, 1);
			chickenH.at(i).second = true;
		}
	}

	cout << ans;

	return 0;
}