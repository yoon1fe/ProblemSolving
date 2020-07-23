#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int i, j, minIndex, temp;
	int arry[10] = { 10, 4, 6, 3, 2, 7, 1, 9, 8, 5 };

	for (i = 0; i < 10; i++) {
		minIndex = i;
		for (j = i + 1; j < 10; j++) {
			if (arry[j] < arry[minIndex])
				minIndex = j;
		}
		swap(arry[i], arry[minIndex]);
	}

	for (i = 0; i < 10; i++)
		cout << arry[i] << ' ';

	return 0;
}