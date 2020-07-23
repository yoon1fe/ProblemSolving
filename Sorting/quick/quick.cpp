#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

void quickSort(int arry[], int start, int end) {
	if (start >= end)
		return;

	int pivot = start;
	int i = start + 1;
	int j = end;

	while (i <= j) {
		while (arry[pivot] >= arry[i])
			i++;
		while (arry[pivot] <= arry[j] && j > start)
			j--;
		if (i > j)
			swap(arry[j], arry[pivot]);
		else
			swap(arry[j], arry[i]);
	}

	quickSort(arry, start, j - 1);
	quickSort(arry, j + 1, end);
}

int main() {
	int arry[10] = { 3, 7, 8, 1, 5, 9, 6, 10, 2, 4 };



	quickSort(arry, 0, 9);

	for (int i = 0; i < 10; i++)
		cout << arry[i] << ' ';

	return 0;
}