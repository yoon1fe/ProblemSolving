#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int N;
int m[100][100] = { 0, };

int main() {
	cin >> N;
	int temp;

	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			cin >> m[i][j];

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				if (m[j][i] && m[i][k])
					m[j][k] = 1;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++)
			cout << m[i][j] << ' ';
		cout << endl;
	}
	return 0;
}