#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int N;
	cin >> N;

	int* dp = new int[N + 1];	//각 숫자(인덱스)가 되는데 걸리는 횟수

	fill(dp, dp + N, -1);
	dp[1] = 0;

	for (int i = 2; i <= N; i++) {
		dp[i] = dp[i - 1] + 1;
		if (i % 2 == 0)
			dp[i] = min(dp[i], dp[i / 2] + 1);
		if (i % 3 == 0)
			dp[i] = min(dp[i], dp[i / 3] + 1);
	}

	cout << dp[N];

	delete[] dp;
	return 0;
}