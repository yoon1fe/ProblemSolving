#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int i, j;
	int arry[10] = { 10, 4, 6, 3, 2, 7, 1, 9, 8, 5 };

	for (i = 0; i < 10; i++) {
		for (j = 1; j < 10 - i; j++) {
			if (arry[j] < arry[j - 1]) {
				swap(arry[j], arry[j - 1]);
			}
		}
	}

	for (i = 0; i < 10; i++)
		cout << arry[i] << ' ';
	return 0;
}