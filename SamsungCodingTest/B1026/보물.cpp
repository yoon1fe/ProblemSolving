#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool compare(int a, int b) {
	return a > b;
}

int main() {
	int N, temp;
	int ans = 0;
	vector<int> a;
	vector<int> b;

	cin >> N;
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < N; j++) {
			cin >> temp;
			if (i == 0)
				a.push_back(temp);
			else
				b.push_back(temp);
		}
	}

	sort(a.begin(), a.end());
	sort(b.begin(), b.end(), compare);

	for (int i = 0; i < N; i++)
		ans = ans + (a.at(i) * b.at(i));

	cout << ans;
	return 0;
}