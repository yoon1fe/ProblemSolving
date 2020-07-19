#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int N, t;
	vector<int> v;
	int dp[100001];

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> t;
		v.push_back(t);
	}
	dp[0] = v.at(0);

	for (int i = 1; i < N; i++)
		dp[i] = max(dp[i - 1] + v.at(i), v.at(i));
	
	cout << *max_element(dp, dp+N) << ' ';

	return 0;
}