//백트래킹으로 풀었음###################################################################
#include <iostream>
#include <algorithm>

using namespace std;

int N;
int input[11];
int op[4] = { 0, };
int maxval = -1000000001, minval = 1000000001;

void dfs(int s, int result) {
	int t = 0;

	if (s == N - 1) {
		if (result > maxval)
			maxval = result;
		if (result < minval)
			minval = result;
			
		return;
	}
	
	for (int i = 0; i < 4; i++) {
		if (op[i] == 0)
			continue;
		switch (i) {
		case 0:		// +
			t = result + input[s + 1];
			op[i]--;
			dfs(s + 1, t);
			op[i]++;
			break;

		case 1:		// -
			t = result - input[s + 1];
			op[i]--;
			dfs(s + 1, t);
			op[i]++;
			break;

		case 2:		// *
			t = result * input[s + 1];
			op[i]--;
			dfs(s + 1, t);
			op[i]++;
			break;

		case 3:		// /
			t = result / input[s + 1];
			op[i]--;
			dfs(s + 1, t);
			op[i]++;
			break;
		}
	}
}

int main() {
	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> input[i];
	for (int i = 0; i < 4; i++)
		cin >> op[i];

	dfs(0, input[0]);

	cout << maxval << endl << minval;

	return 0;
}