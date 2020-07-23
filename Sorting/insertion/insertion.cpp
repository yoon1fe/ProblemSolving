#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int i, j, key;
	int arry[10] = { 10, 4, 6, 3, 2, 7, 1, 9, 8, 5 };

	for (i = 1; i < 10; i++) {
		key = arry[i];

		for (j = i - 1; j >= 0 && arry[j] > key; j--)
			//swap(arry[j + 1], arry[j]);
			arry[j + 1] = arry[j];
			

		arry[j + 1] = key;
	}

	for (i = 0; i < 10; i++)
		cout << arry[i] << ' ';
	return 0;
}