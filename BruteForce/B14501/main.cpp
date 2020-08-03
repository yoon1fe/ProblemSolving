#include <iostream>
#include <algorithm>
#include <vector>
#define MAX_SIZE 16

using namespace std;

int N;
int T[MAX_SIZE];
int P[MAX_SIZE];
int maxValue;

void dfs(int day, int sum) {
	if (day == N + 1) {
		maxValue = max(maxValue, sum);
		return;
	}

	if (day + T[day] <= N + 1)		//상담할 수 있는 경우
		dfs(day + T[day], sum + P[day]);
	if (day + 1 <= N + 1)			//상담할 수 없는 경우
		dfs(day + 1, sum);
}

int main() {
	cin >> N;

	for (int i = 1; i <= N; i++)
		cin >> T[i] >> P[i];

	dfs(1, 0);

	cout << maxValue << endl;

	return 0;
}