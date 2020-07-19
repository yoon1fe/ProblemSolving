#include <iostream>
#include <vector>
using namespace std;

int main() {
	int N;
	vector<int> v;
	cin >> N;

	for (int i = 0; i < N; i++) {
		int M;
		cin >> M;

		int* dp = new int[M + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int j = 4; j <= M; j++)
			dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
		
		v.push_back(dp[M]);
		delete[] dp;
	}

	for (int i = 0; i < N; i++)
		cout << v.at(i) << endl;


	return 0;
}