#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int N, B, C, temp;
	vector<int> classroom;
	cin >> N;
	long long ans = N;
	long long cnt = 0;
	
	for (int i = 0; i < N; i++) {
		cin >> temp;
		classroom.push_back(temp);
	}

	cin >> B >> C;

	for (int i = 0; i < N; i++) {
		classroom.at(i) -= B;
		if (classroom.at(i) > 0) {
			if (classroom.at(i) % C == 0)
				cnt += classroom.at(i) / C;
			else
				cnt += classroom.at(i) / C + 1;
		}
	}

	ans += cnt;

	cout << ans;

	return 0;
}