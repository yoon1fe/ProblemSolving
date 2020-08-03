#include <iostream>
#include <algorithm>

using namespace std;

int T;

int solve(int num) {
	if (num == 1) return 1; 
	if (num == 2) return 2; 
	if (num == 3) return 4; 

	return solve(num - 1) + solve(num - 2) + solve(num - 3);
}

int main() {
	cin >> T;

	for (int i = 0; i < T; i++) {
		int n;
		cin >> n;
		cout << solve(n) << "\n";
	}

	return 0;
}