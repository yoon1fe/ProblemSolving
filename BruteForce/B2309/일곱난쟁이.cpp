#include <iostream>
#include <algorithm>
using namespace std;

int sum(int arry[], int n) {
	int arrySum = 0;
	for (int i = 0; i < n; i++)
		arrySum += arry[i];

	return arrySum;
}
int main() {
	int arry[9], m, n;

	for (int i = 0; i < 9; i++)
		cin >> arry[i];

	sort(arry, arry + 9);

	for (int i = 0; i < 9; i++) {
		for (int j = 1; j < 9; j++) {
			int ssum = sum(arry, 9)-arry[i]-arry[j];
			if (ssum == 100) {
				m = i;
				n = j;
			}
		}
	}

	for (int k = 0; k < 9; k++) {
		if (k != m && k != n)
			cout << arry[k] << endl;
	}

	return 0;
}